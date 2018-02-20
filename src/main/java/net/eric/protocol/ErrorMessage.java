package net.eric.protocol;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Eric Zhao
 * @date 2018/2/7
 */
public enum ErrorMessage {
    SYSTEM_EXCEPTION("系统异常"),
    LOGIN_FAILED("用户名或密码错"),
    AUTH_FAILED("认证失败"),
    BAD_PARAMS("参数错误");
    private String error;

    ErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "error='" + error + '\'' +
                '}';
    }
}
