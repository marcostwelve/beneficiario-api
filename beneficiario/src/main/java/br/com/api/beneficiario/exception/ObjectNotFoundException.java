package br.com.api.beneficiario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String menssagem) {
        super(menssagem);
    }

    public ObjectNotFoundException(String menssagem, Throwable cause) {
        super(menssagem, cause);
    }
}
