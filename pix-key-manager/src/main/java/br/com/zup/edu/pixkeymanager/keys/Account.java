package br.com.zup.edu.pixkeymanager.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.EnumType.STRING;

@Embeddable
public class Account {

    @NotBlank
    @Column(name = "financial_institution", nullable = false)
    private String institution;

    @NotBlank
    @Column(name = "owner_name", nullable = false)
    private String owner;

    @NotBlank
    @Size(max = 11)
    @Column(name = "owner_document", length = 14, nullable = false)
    private String document;

    @NotNull
    @Enumerated(STRING)
    @Column(name = "owner_type", nullable = false)
    private OwnerType ownerType;

    @NotBlank
    @Size(max = 4)
    @Column(name = "bank_branch", length = 4, nullable = false)
    private String branch;

    @NotBlank
    @Size(max = 6)
    @Column(name = "account_number", length = 6, nullable = false)
    private String number;

    public Account(String institution,
                   String owner,
                   String document,
                   OwnerType ownerType,
                   String branch,
                   String number) {
        this.institution = institution;
        this.owner = owner;
        this.document = document;
        this.ownerType = ownerType;
        this.branch = branch;
        this.number = number;
    }

    /**
     * @deprecated hibernate eyes only
     */
    @Deprecated
    Account() { }

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

    public OwnerType getOwnerType() {
        return ownerType;
    }
}
