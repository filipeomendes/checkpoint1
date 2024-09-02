package br.com.fiap.checkpoint1.repository;

import br.com.fiap.checkpoint1.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}