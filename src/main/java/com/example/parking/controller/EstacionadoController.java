package com.example.parking.controller;

import com.example.parking.dto.EstacionadoDTO;
import com.example.parking.dto.EstacionadoResumenDTO;
import com.example.parking.dto.PatenteDto;
import com.example.parking.dto.TipoPagoDTO;
import com.example.parking.mapper.EstacionadoMapper;
import com.example.parking.model.Configuracion;
import com.example.parking.model.Estacionado;
import com.example.parking.model.Estacionamiento;
import com.example.parking.repo.ConfiguracionRepository;
import com.example.parking.repo.EstacionadoRepository;
import com.example.parking.repo.EstacionamientoRepository;
import com.example.parking.response.ApiResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.Duration;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estacionados")
@CrossOrigin(origins = "http://186.64.113.173")
// @CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class EstacionadoController {
    private final EstacionadoRepository estacionadoRepository;
    private final EstacionadoMapper estacionadoMapper;

    private final EstacionamientoRepository estacionamientoRepository;

    private final ConfiguracionRepository configuracionRepository;

    @GetMapping
    public List<EstacionadoDTO> getAll() {
        return estacionadoRepository.findAll().stream().map(estacionadoMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public EstacionadoDTO create(@RequestBody EstacionadoDTO dto) {
        return estacionadoMapper.toDto(estacionadoRepository.save(estacionadoMapper.toEntity(dto)));
    }

    @PostMapping("/ingresar")
    public ResponseEntity<?> ingresar(@RequestBody PatenteDto patenteDto) {
        System.out.println("/INGRESAR");
        System.out.println(patenteDto.getPatente());
        if (patenteDto.getPatente() == null || patenteDto.getPatente().trim().isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Debe ingresar una patente"), HttpStatus.BAD_REQUEST);
        }

        List<Estacionamiento> estacionamientosList = estacionamientoRepository.findAll();
        Estacionamiento estacionamiento = new Estacionamiento();

        Estacionado findEstacionado = estacionadoRepository
                .findByEstadoAndPatente(Estacionado.EstadoEstacionamiento.ESTACIONADO, patenteDto.getPatente());

        if (findEstacionado != null) {
            return new ResponseEntity<>(new ApiResponse("El vehiculo se encuentra estacionado"),
                    HttpStatus.BAD_REQUEST);
        }

        if (!estacionamientosList.isEmpty()) {
            estacionamiento = estacionamientosList.get(0);
        }

        Estacionado estacionado = new Estacionado();
        estacionado.setPatente(patenteDto.getPatente());
        estacionado.setEstado(Estacionado.EstadoEstacionamiento.ESTACIONADO);
        estacionado.setFechaIngreso(LocalDateTime.now(ZoneId.of("America/Santiago")));
        estacionado.setEstacionamiento(estacionamiento);
        estacionadoRepository.save(estacionado);
        estacionamiento.setCantidadLibre(estacionamiento.getCantidadLibre() - 1);
        estacionamiento.setCantidadOcupado(estacionamiento.getCantidadOcupado() + 1);
        try {
            estacionamientoRepository.save(estacionamiento);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Vehiculo ingresado", HttpStatus.OK);

    }

    @PostMapping("/sacar")
    public ResponseEntity<?> sacar(@RequestBody PatenteDto patenteDto) {

        if (patenteDto.getPatente().trim().equalsIgnoreCase("")) {
            return new ResponseEntity<>(new ApiResponse("El vehiculo no se encuentra estacionado"),
                    HttpStatus.BAD_REQUEST);
        }

        Estacionado findEstacionado = estacionadoRepository
                .findByEstadoAndPatente(Estacionado.EstadoEstacionamiento.ESTACIONADO, patenteDto.getPatente());
        List<Estacionamiento> estacionamientosList = estacionamientoRepository.findAll();
        Estacionamiento estacionamiento = new Estacionamiento();
        if (!estacionamientosList.isEmpty()) {
            estacionamiento = estacionamientosList.get(0);
        } else {
            return new ResponseEntity<>(new ApiResponse("No se encontro el estacionamiento"),
                    HttpStatus.BAD_REQUEST);
        }

        List<Configuracion> configuracionList = configuracionRepository.findAll();
        Configuracion configuracion = new Configuracion();
        if (!configuracionList.isEmpty()) {
            configuracion = configuracionList.get(0);
        }

        findEstacionado.setEstado(Estacionado.EstadoEstacionamiento.SALIDA);
        findEstacionado.setFechaSalida(LocalDateTime.now(ZoneId.of("America/Santiago")));
        findEstacionado.setTipoPago(Estacionado.TipoPago.DEBITO);

        int minutos = (int) Duration.between(findEstacionado.getFechaIngreso(), findEstacionado.getFechaSalida())
                .toMinutes();

        int valorTotal = 0;

        if (minutos > 15 && minutos < configuracion.getTiempoMinimoMinutos()) {
            valorTotal = configuracion.getValorMinimo();
        } else {
            valorTotal = configuracion.getValorMinuto() * minutos;
        }

        if (minutos < 15) {
            valorTotal = 500;
        }

        findEstacionado.setValorTotal(valorTotal);
        findEstacionado.setMinutosEstacionado(minutos);

        estacionamiento.setCantidadLibre(estacionamiento.getCantidadLibre() + 1);
        estacionamiento.setCantidadOcupado(estacionamiento.getCantidadOcupado() - 1);
        estacionamientoRepository.save(estacionamiento);
        return ResponseEntity.ok(estacionadoRepository.save(findEstacionado));

    }

    @PutMapping("/borrar")
    public ResponseEntity<EstacionadoDTO> borrarPorPatente(@RequestBody PatenteDto patenteDto) {
        Estacionado estacionado = estacionadoRepository
                .findByEstadoAndPatente(Estacionado.EstadoEstacionamiento.ESTACIONADO, patenteDto.getPatente());

        if (estacionado == null) {
            return ResponseEntity.notFound().build();
        }

        estacionado.setEstado(Estacionado.EstadoEstacionamiento.BORRADO);
        // estacionado.setFechaSalida(LocalDateTime.now());
        estacionado.setFechaSalida(LocalDateTime.now(ZoneId.of("America/Santiago")));

        // Actualizar estadísticas del estacionamiento
        Estacionamiento estacionamiento = estacionado.getEstacionamiento();
        if (estacionamiento != null) {
            estacionamiento.setCantidadLibre(estacionamiento.getCantidadLibre() + 1);
            estacionamiento.setCantidadOcupado(estacionamiento.getCantidadOcupado() - 1);
            estacionamientoRepository.save(estacionamiento);
        }

        Estacionado actualizado = estacionadoRepository.save(estacionado);
        return ResponseEntity.ok(estacionadoMapper.toDto(actualizado));
    }

    @PutMapping("/actualizar-pago/{id}")
    public ResponseEntity<EstacionadoDTO> actualizarTipoPago(
            @PathVariable Long id,
            @RequestBody TipoPagoDTO tipoPagoDto) {

        Estacionado estacionado = estacionadoRepository.findById(id).orElse(null);

        if (estacionado == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            estacionado.setEstado(Estacionado.EstadoEstacionamiento.COBRADO);
            estacionado.setTipoPago(Estacionado.TipoPago.valueOf(tipoPagoDto.getTipoPago()));
            Estacionado actualizado = estacionadoRepository.save(estacionado);
            return ResponseEntity.ok(estacionadoMapper.toDto(actualizado));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public EstacionadoDTO getById(@PathVariable Long id) {
        return estacionadoRepository.findById(id).map(estacionadoMapper::toDto).orElseThrow();
    }

    @PutMapping("/{id}")
    public EstacionadoDTO update(@PathVariable Long id, @RequestBody EstacionadoDTO dto) {
        Estacionado entity = estacionadoMapper.toEntity(dto);
        entity.setId(id);
        return estacionadoMapper.toDto(estacionadoRepository.save(entity));
    }

    /*
     * @DeleteMapping("/{id}")
     * public void delete(@PathVariable Long id) {
     * estacionadoRepository.deleteById(id);
     * }
     */

    @GetMapping("/por-fecha")
    public ResponseEntity<EstacionadoResumenDTO> getPorFecha(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {

        List<Estacionado> result = estacionadoRepository.findByFechaIngresoBetween(from, to);
        double totalRecaudado = 0;
        double totalDebito = 0;
        double totalCredito = 0;
        double totalEfectivo = 0;
        int transaccionesDebito = 0;
        int transaccionesCredito = 0;
        int transaccionesEfectivo = 0;

        for (Estacionado e : result) {
            totalRecaudado += e.getValorTotal();

            if (e.getTipoPago() == Estacionado.TipoPago.DEBITO) {
                totalDebito += e.getValorTotal();
                transaccionesDebito++;
            } else if (e.getTipoPago() == Estacionado.TipoPago.CREDITO) {
                totalCredito += e.getValorTotal();
                transaccionesCredito++;
            } else if (e.getTipoPago() == Estacionado.TipoPago.EFECTIVO) {
                totalEfectivo += e.getValorTotal();
                transaccionesEfectivo++;
            }
        }
        EstacionadoResumenDTO resumen = new EstacionadoResumenDTO();
        resumen.setEstacionados(result);
        resumen.setTotalRecaudado(totalRecaudado);
        resumen.setTotalTransacciones(result.size());
        resumen.setTotalDebito(totalDebito);
        resumen.setTransaccionesDebito(transaccionesDebito);
        resumen.setTotalCredito(totalCredito);
        resumen.setTransaccionesCredito(transaccionesCredito);
        resumen.setTotalEfectivo(totalEfectivo);
        resumen.setTransaccionesEfectivo(transaccionesEfectivo);
        resumen.setTotalTarjeta(totalDebito + totalCredito);
        resumen.setTransaccionesTarjeta(transaccionesDebito + transaccionesCredito);

        return ResponseEntity.ok(resumen);
    }

}