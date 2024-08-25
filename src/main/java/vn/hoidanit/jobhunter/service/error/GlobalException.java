package vn.hoidanit.jobhunter.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vn.hoidanit.jobhunter.domain.RestResponse;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = IdInvaLidException.class)
    public ResponseEntity<RestResponse<Object>> handleBlogAlreadyExistsException(IdInvaLidException idException) {

        RestResponse<Object> rest = new RestResponse<Object>();
        rest.setStatusCode(HttpStatus.BAD_REQUEST.value());
        rest.setError(idException.getMessage());
        rest.setMessage("IdInvaLidException");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rest);
    }

}
