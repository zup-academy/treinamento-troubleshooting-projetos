package br.com.zup.edu.pixkeymanager.keys.shared.integration.itau;

import br.com.zup.edu.pixkeymanager.keys.Account;
import br.com.zup.edu.pixkeymanager.keys.OwnerType;

public class AccoutResponse {

    private String institution;
    private String owner;
    private String document;
    private OwnerType ownerType;
    private String branch;
    private String number;

    public String getInstitution() {
        return institution;
    }

    public String getOwner() {
        return owner;
    }

    public String getDocument() {
        return document;
    }

    public OwnerType getOwnerType() {
        return ownerType;
    }

    public String getBranch() {
        return branch;
    }

    public String getNumber() {
        return number;
    }

    public Account toAccount() {
        return new Account(institution, owner, document, ownerType, branch, number);
    }
}
