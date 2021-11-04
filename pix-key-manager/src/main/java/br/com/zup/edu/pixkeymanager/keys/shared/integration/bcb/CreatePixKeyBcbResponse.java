package br.com.zup.edu.pixkeymanager.keys.shared.integration.bcb;

import java.time.LocalDateTime;

public class CreatePixKeyBcbResponse {

    private String keyType;
    private String key;
    private LocalDateTime createdAt;

    public String getKeyType() {
        return keyType;
    }

    public String getKey() {
        return key;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
