package br.com.zup.edu.pixkeymanager.keys.register;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


class ValidPixKeyValidator implements ConstraintValidator<ValidPixKey, NewPixKeyRequest> {

    @Override
    public boolean isValid(NewPixKeyRequest request,
                           ConstraintValidatorContext context) {

        if (request.getType() == null) {
            return true; // type must be annotated with @NotNull
        }

        boolean valid = request.validKey();

        if (!valid) {
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                   .addPropertyNode("key")
                   .addConstraintViolation();
        }

        return valid;
    }
}
