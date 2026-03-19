package com.example.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.model.User;
import com.example.parking.service.impl.LoginService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
// @CrossOrigin(origins = "http://186.64.113.173")
@CrossOrigin(origins = "${parking.server.url}")
// @CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public User crear(@RequestBody User login) {
        return loginService.guardarLogin(login);
    }

    @GetMapping("/{id}")
    public User obtener(@PathVariable Long id) {
        return loginService.obtenerPorId(id).orElse(null);
    }

    @GetMapping("/{usuario}/{clave}")
    public User obtenerUsuarioLogin(@PathVariable String usuario, @PathVariable String clave) {
        System.out.println("Validando usuarios");
        System.out.println(usuario);
        System.out.println(clave);
        Optional<User> user = loginService.buscarPorUsuarioAndClave(usuario, clave);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
        // return loginService.buscarPorUsuarioAndClave(usuario, clave).orElse(null);
    }

    @GetMapping("/usuario/{usuario}")
    public User buscarPorUsuario(@PathVariable String usuario) {
        return loginService.buscarPorUsuario(usuario).orElse(null);
    }

    @GetMapping
    public List<User> listar() {
        return loginService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        loginService.eliminarLogin(id);
    }
}