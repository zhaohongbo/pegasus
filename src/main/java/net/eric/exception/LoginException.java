package net.eric.exception;

import net.eric.protocol.ErrorMessage;

/**
 * @author Eric Zhao
 * @date 2018/2/17
 */
public class LoginException extends BasicException {
    public LoginException() {
        super(ErrorMessage.LOGIN_FAILED.getError());
    }
}
