package com.example.parking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.model.User;
import com.example.parking.repo.LoginRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public User guardarLogin(User login) {
        return loginRepository.save(login);
    }

    public Optional<User> obtenerPorId(Long id) {
        return loginRepository.findById(id);
    }

    public Optional<User> buscarPorUsuario(String usuario) {
        return loginRepository.findByUsers(usuario);
    }

    public Optional<User> buscarPorUsuarioAndClave(String usuario, String clave) {
        return loginRepository.findByUsersAndPass(usuario, clave);
    }

    public List<User> listarTodos() {
        return loginRepository.findAll();
    }

    public void eliminarLogin(Long id) {
        loginRepository.deleteById(id);
    }
}
