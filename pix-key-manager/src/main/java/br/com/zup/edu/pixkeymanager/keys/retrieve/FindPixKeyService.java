package br.com.zup.edu.pixkeymanager.keys.retrieve;

import br.com.zup.edu.pixkeymanager.keys.PixKey;
import br.com.zup.edu.pixkeymanager.keys.PixKeyRepository;
import br.com.zup.edu.pixkeymanager.keys.shared.cache.LocalCacheService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindPixKeyService {

    private final LocalCacheService cacheService;
    private final PixKeyRepository repository;

    public FindPixKeyService(LocalCacheService cacheService,
                             PixKeyRepository repository) {
        this.cacheService = cacheService;
        this.repository = repository;
    }

    public Optional<PixKey> findPixKeyBy(UUID pixId) {

        Optional<PixKey> cached = cacheService.findBy(pixId);

        if (cached.isPresent()) {
            return cached;
        }

        Optional<PixKey> possiblePixKey = repository.findById(pixId);

        if (possiblePixKey.isPresent()) {
            cacheService.update(possiblePixKey.get());
            return possiblePixKey;
        }

        return Optional.empty();
    }
}
