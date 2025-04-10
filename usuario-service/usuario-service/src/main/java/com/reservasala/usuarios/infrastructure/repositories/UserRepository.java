package com.reservasala.usuarios.infrastructure.repositories;
import com.reservasala.usuarios.domain.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long>{
}





