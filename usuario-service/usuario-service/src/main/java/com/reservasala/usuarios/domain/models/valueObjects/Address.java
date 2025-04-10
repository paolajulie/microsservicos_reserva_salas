package com.reservasala.usuarios.domain.models.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
}



