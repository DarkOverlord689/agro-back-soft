package com.agrosoft.agrosoft.entities;

import com.agrosoft.agrosoft.model.CategoriaMaestraDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categoria_maestra")
public class CategoriaMaestraEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    private Boolean estado;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;

    public CategoriaMaestraDTO toDTO() {
        return new CategoriaMaestraDTO(
                this.getId(),
                this.getCodigo(),
                this.getNombre(),
                this.getEstado(),
                this.getCreatedAt(),
                this.getUpdatedAt());
    }
}
