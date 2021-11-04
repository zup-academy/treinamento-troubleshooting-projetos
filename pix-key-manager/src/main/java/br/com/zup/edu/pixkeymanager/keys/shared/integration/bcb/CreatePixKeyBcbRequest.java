package br.com.zup.edu.pixkeymanager.keys.shared.integration.bcb;

import br.com.zup.edu.pixkeymanager.keys.*;

import java.util.Map;

import static br.com.zup.edu.pixkeymanager.keys.AccountType.*;
import static br.com.zup.edu.pixkeymanager.keys.OwnerType.NATURAL_PERSON;

public class CreatePixKeyBcbRequest {

    private String keyType;
    private String key;
    private BankAccountRequest bankAccount;
    private OwnerRequest owner;


    public CreatePixKeyBcbRequest(PixKey pixKey) {
        this.keyType = keyTypeFrom(pixKey.getType());
        this.key = pixKey.getKey();
        this.bankAccount = new BankAccountRequest(pixKey.getAccount().getBranch(),
                                                  pixKey.getAccount().getNumber(),
                                                  pixKey.getAccountType());
        this.owner = new OwnerRequest(pixKey.getAccount());
    }


    private String keyTypeFrom(KeyType type) {

        Map<KeyType, String> types = Map.of(KeyType.CPF, "CPF",
                                            KeyType.CNPJ, "CNPJ",
                                            KeyType.CELLPHONE, "PHONE",
                                            KeyType.EMAIL, "EMAIL",
                                            KeyType.RANDOM, "RANDOM");

        return types.get(type);

    }

    public String getKeyType() {
        return keyType;
    }

    public String getKey() {
        return key;
    }

    public BankAccountRequest getBankAccount() {
        return bankAccount;
    }

    public OwnerRequest getOwner() {
        return owner;
    }

    private static class BankAccountRequest {
        private String participant = "ITAU_UNIBANCO_ISPB";
        private String branch;
        private String accountNumber;
        private String accountType;

        public BankAccountRequest(String branch,
                                  String accountNumber,
                                  AccountType accountType) {

            this.branch = branch;
            this.accountNumber = accountNumber;
            this.accountType = resolveAccountType(accountType);
        }

        private String resolveAccountType(AccountType accountType) {
            Map<AccountType, String> accounts = Map.of(CURRENT_ACCOUNT, "CACC",
                                                       SAVING_ACCOUNT, "SVGS");

            return accounts.get(accountType);
        }

        public String getParticipant() {
            return participant;
        }

        public String getBranch() {
            return branch;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountType() {
            return accountType;
        }
    }

    private static class OwnerRequest {

        private String type;
        private String name;
        private String taxIdNumber;

        public OwnerRequest(Account account) {

            this.type = typeResolver(account.getOwnerType());
            this.name = account.getOwner();
            this.taxIdNumber = account.getDocument();
        }

        public OwnerRequest() { }

        private String typeResolver(OwnerType ownerType) {
            if (ownerType == NATURAL_PERSON) {
                return "NATURAL_PERSON";
            }

            return "LEGAL_PERSON";
        }


        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public String getTaxIdNumber() {
            return taxIdNumber;
        }
    }
}
