package br.com.zup.edu.pixkeymanager.keys;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public enum KeyType {

    CPF {

        @Override
        protected boolean isValid(String key) {

            var validator = new CPFValidator();
            validator.initialize(null);
            return validator.isValid(key, null);
        }
    },
    CNPJ {

        @Override
        protected boolean isValid(String key) {

            var validator = new CNPJValidator();
            validator.initialize(null);
            return validator.isValid(key, null);

        }
    },
    CELLPHONE {

        @Override
        protected boolean isValid(String key) {
           return key.matches("^\\+[1-9][0-9]\\d{1,14}\\$");
        }
    },
    EMAIL {

        @Override
        protected boolean isValid(String key) {

            var validator = new EmailValidator();
            validator.initialize(null);
            return validator.isValid(key, null);
        }
    },
    RANDOM {

        @Override
        protected boolean isValid(String key) {
            return key == null || key.isBlank(); // key must not be filled
        }
    };



    protected abstract boolean isValid(String key);

    public final boolean validate(String key) {

        if (this == RANDOM) {
            return isValid(key);
        }

        if (key == null || key.isBlank()) {
            return false;
        }

        return isValid(key);
    }
}
