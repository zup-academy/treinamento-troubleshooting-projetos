package br.com.zup.edu.pixkeymanager.keys.retrieve;

import br.com.zup.edu.pixkeymanager.keys.Account;
import br.com.zup.edu.pixkeymanager.keys.KeyType;
import br.com.zup.edu.pixkeymanager.keys.PixKey;

import java.time.LocalDateTime;
import java.util.UUID;

public class PixKeyDetailResponse {

    private UUID clientId;
    private UUID pixId;
    private PixKeyResponse key;


    public PixKeyDetailResponse(UUID clientId,
                                UUID pixId,
                                PixKeyResponse key) {
        this.clientId = clientId;
        this.pixId = pixId;
        this.key = key;
    }

    public UUID getClientId() {
        return clientId;
    }

    public UUID getPixId() {
        return pixId;
    }

    public PixKeyResponse getKey() {
        return key;
    }

    public static PixKeyDetailResponse of(PixKey pixKey) {

        return new PixKeyDetailResponse(pixKey.getClientId(),
                                        pixKey.getId(),
                                        new PixKeyResponse(pixKey));
    }

    private static class PixKeyResponse {

        private KeyType type;
        private String key;
        private AccountResponse account;
        private LocalDateTime createdAt;

        public PixKeyResponse(PixKey pixKey) {
            this.type = pixKey.getType();
            this.key = pixKey.getKey();
            this.account = new AccountResponse(pixKey.getAccount());
            this.createdAt = pixKey.getCreatedAt();
        }

        public KeyType getType() {
            return type;
        }

        public String getKey() {
            return key;
        }

        public AccountResponse getAccount() {
            return account;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }
    }

    private static class AccountResponse {

        private String institution;
        private String owner;
        private String document;
        private String branch;
        private String number;

        public AccountResponse(Account account) {

            this.institution = account.getInstitution();
            this.owner = account.getOwner();
            this.document = account.getDocument();
            this.branch = account.getBranch();
            this.number = account.getNumber();
        }

        public String getInstitution() {
            return institution;
        }

        public String getOwner() {
            return owner;
        }

        public String getDocument() {
            return document;
        }

        public String getBranch() {
            return branch;
        }

        public String getNumber() {
            return number;
        }
    }
}
