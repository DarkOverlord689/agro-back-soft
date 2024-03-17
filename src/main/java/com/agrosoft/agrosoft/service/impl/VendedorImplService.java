package com.agrosoft.agrosoft.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrosoft.agrosoft.entities.VendedorEntities;
import com.agrosoft.agrosoft.model.VendedorDTO;
import com.agrosoft.agrosoft.repository.VendedoRepository;
import com.agrosoft.agrosoft.service.VendedorService;

@Service
public class VendedorImplService implements VendedorService {

    @Autowired
    VendedoRepository vendedoRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<VendedorDTO> listVendedores() {
        Iterable<VendedorEntities> entidades = vendedoRepository.findAll();

        List<VendedorDTO> dtos = new ArrayList<>();

        // Iterar sobre el Iterable y mapear cada entidad a su DTO correspondiente
        for (VendedorEntities entidad : entidades) {
            VendedorDTO dto = entidad.toDTO();
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public void createdVendedores(VendedorDTO vendedorDTO) {
        // Crear una entidad VendedorEntities con los datos del DTO
        VendedorEntities vendedorEntity = new VendedorEntities(
            null,
            vendedorDTO.getPrimerNombre(),
            vendedorDTO.getSegundoNombre(),
            vendedorDTO.getPrimerApellido(),
            vendedorDTO.getSegundoApellido(),
            vendedorDTO.getTipoDocumentoId(),
            vendedorDTO.getNumeroDocumento(),
            vendedorDTO.getCorreo(),
            vendedorDTO.getTelefono(),
            vendedorDTO.getEstado(),
            vendedorDTO.getUsername(),
            passwordEncoder.encode(vendedorDTO.getPassword()),
            vendedorDTO.getCambioContrasena(),
            vendedorDTO.getIntentosFallidos(),
            vendedorDTO.getToken(),
            vendedorDTO.getTipoGeneroId(),
            vendedorDTO.getDireccion(),
            vendedorDTO.getFechaNacimiento(),
            vendedorDTO.getCreatedAt(),
            vendedorDTO.getUpdatedAt());

        // Guardar la entidad en la base de datos utilizando el repositorio
        vendedoRepository.save(vendedorEntity);
    }

    @Override
    public void changeStatusVendedor(Long estado, Long id) {
        vendedoRepository.changeStatusVendedor(estado, id);
    }

}
