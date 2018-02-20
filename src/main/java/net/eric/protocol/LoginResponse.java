package net.eric.protocol;

import net.eric.domain.UserInfo;

import java.io.Serializable;

/**
 * @author Eric Zhao
 * @date 2018/2/7
 */
public class LoginResponse implements Serializable {
    private String token;
    private UserInfo userInfo;

    public LoginResponse(String token, UserInfo userInfo) {
        this.token = token;
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
