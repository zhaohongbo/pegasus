package net.eric.exception;

import net.eric.protocol.ErrorMessage;

/**
 * @author Eric Zhao
 * @date 2018/2/17
 */
public class AuthException extends BasicException {
    public AuthException() {
        super(ErrorMessage.AUTH_FAILED.getError());
    }
}
