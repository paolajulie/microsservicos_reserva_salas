package com.reservasala.usuarios.shared.dto;

import com.reservasala.usuarios.domain.models.valueObjects.Address;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private String name;
    private String email;
    private Address address;
} 