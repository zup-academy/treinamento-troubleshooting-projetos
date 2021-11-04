package br.com.zup.edu.pixkeymanager.keys;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PixKeyRepository extends JpaRepository<PixKey, UUID> {

    boolean findByKey(String key);
}
