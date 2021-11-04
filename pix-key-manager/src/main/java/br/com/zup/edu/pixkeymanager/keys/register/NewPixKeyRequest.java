package br.com.zup.edu.pixkeymanager.keys.register;

import br.com.zup.edu.pixkeymanager.keys.Account;
import br.com.zup.edu.pixkeymanager.keys.AccountType;
import br.com.zup.edu.pixkeymanager.keys.KeyType;
import br.com.zup.edu.pixkeymanager.keys.PixKey;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

@ValidPixKey
public class NewPixKeyRequest {

    @NotNull
    private AccountType accountType;

    @Size(max = 77)
    private String key;

    @NotNull
    private KeyType type;

    @JsonCreator(mode = PROPERTIES)
    public NewPixKeyRequest(AccountType accountType,
                            String key,
                            KeyType type) {
        this.accountType = accountType;
        this.key = key;
        this.type = type;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getKey() {
        return key;
    }

    public KeyType getType() {
        return type;
    }

    public PixKey toPixKey(UUID clientId, Account account) {
        return new PixKey(clientId, type, key, accountType, account);
    }

    public boolean validKey() {
        return type.validate(key);
    }
}
