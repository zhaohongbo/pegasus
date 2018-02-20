package net.eric.aspect;

import net.eric.exception.AuthException;
import net.eric.exception.LoginException;
import net.eric.protocol.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Eric Zhao
 * @date 2018/2/17
 */
@RestControllerAdvice
public class BasicControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(BasicControllerAdvice.class);

    @ExceptionHandler(LoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleLogicException(LoginException loginException) {
        logger.error(loginException.getMessage(), loginException);
        return new ErrorResponse(loginException.getMessage());
    }

    @ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleAuthException(AuthException authException) {
        logger.error(authException.getMessage(), authException);
        return new ErrorResponse(authException.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleOtherException(Throwable th) {
        logger.error("error {}", th);
        return new ErrorResponse("内部服务器错误");
    }

}
