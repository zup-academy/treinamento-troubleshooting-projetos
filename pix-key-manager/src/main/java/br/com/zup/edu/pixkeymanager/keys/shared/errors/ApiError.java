package br.com.zup.edu.pixkeymanager.keys.shared.errors;

import java.util.Objects;
import java.util.StringJoiner;

public class ApiError {

    private String code;
    private String msg;

    public ApiError(String code, String msg) {

        this.code = Objects.requireNonNull(code);
        this.msg = Objects.requireNonNull(msg);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ApiError.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("msg='" + msg + "'")
                .toString();
    }
}
