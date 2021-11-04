package br.com.zup.edu.pixkeymanager.keys.shared.cache;

import br.com.zup.edu.pixkeymanager.keys.PixKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LocalCacheService {

    private static final Logger LOG = LoggerFactory.getLogger(LocalCacheService.class);


    private final ConcurrentHashMap<String, PixKey> cache = new ConcurrentHashMap<>();

    public Optional<PixKey> findBy(UUID pixId) {

        PixKey pixKey = cache.get(pixId.toString());

        return Optional.ofNullable(pixKey);
    }

    public void update(PixKey pixKey) {

        LOG.info("[PIX][CACHE] Putting key '{}' in cache", pixKey.getId());
        cache.put(pixKey.getId().toString(), pixKey);
    }

    public void invalidate(UUID pixId) {
        LOG.info("[PIX][CACHE] Removing key '{}' from cache", pixId);
        this.cache.remove(pixId.toString());
    }
}
