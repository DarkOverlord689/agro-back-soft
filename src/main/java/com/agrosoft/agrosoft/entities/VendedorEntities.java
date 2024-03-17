package com.agrosoft.agrosoft.entities;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.agrosoft.agrosoft.model.VendedorDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vendedor")
public class VendedorEntities implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "fk_tipo_documento")
    private Long tipoDocumentoId;
    @Column(name = "numero_documento")
    private Long numeroDocumento;
    private String correo;
    private String telefono;
    private Long estado;
    private String username;
    private String password;
    @Column(name = "cambio_contrasena")
    private String cambioContrasena;
    @Column(name = "intentos_fallidos")
    private Long intentosFallidos;
    private String token;
    @Column(name = "fk_tipo_genero")
    private Long tipoGeneroId;
    private String direccion;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Devolver una lista vacía si no manejas roles en tu aplicación
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public VendedorDTO toDTO() {
        return new VendedorDTO(
                this.getId(),
                this.getPrimerNombre(),
                this.getSegundoNombre(),
                this.getPrimerApellido(),
                this.getSegundoApellido(),
                this.getTipoDocumentoId(),
                this.getNumeroDocumento(),
                this.getCorreo(),
                this.getTelefono(),
                this.getEstado(),
                this.getUsername(),
                this.getPassword(),
                this.getCambioContrasena(),
                this.getIntentosFallidos(),
                this.getToken(),
                this.getTipoGeneroId(),
                this.getDireccion(),
                this.getFechaNacimiento(),
                this.getCreatedAt(),
                this.getUpdatedAt());
    }
}
