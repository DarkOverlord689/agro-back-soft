package com.agrosoft.agrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.Jwt.JwtService;
import com.agrosoft.agrosoft.entities.VendedorEntities;
import com.agrosoft.agrosoft.model.AuthDTO;
import com.agrosoft.agrosoft.model.AuthenticationDTO;
import com.agrosoft.agrosoft.repository.VendedoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final VendedoRepository vendedoRepository;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthDTO login(AuthenticationDTO request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = vendedoRepository.findByUsername(request.getUsername()).orElseThrow();
        VendedorEntities userEntities = vendedoRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        vendedoRepository.updateToken(token, request.getUsername());
        return AuthDTO.builder()
                .id(userEntities.getId())
                .primerNombre(userEntities.getPrimerNombre())
                .segundoNombre(userEntities.getSegundoNombre())
                .primerApellido(userEntities.getPrimerApellido())
                .segundoApellido(userEntities.getSegundoApellido())
                .correo(userEntities.getCorreo())
                .telefono(userEntities.getTelefono())
                .token(token)
                .build();

    }
}
