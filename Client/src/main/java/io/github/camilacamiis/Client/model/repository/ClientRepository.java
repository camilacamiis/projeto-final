package io.github.camilacamiis.Client.model.repository;

import io.github.camilacamiis.Client.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
