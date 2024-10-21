package br.com.fiap.challenge3.repository;

import br.com.fiap.challenge3.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {
}
