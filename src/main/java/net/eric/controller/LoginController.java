package net.eric.controller;

import net.eric.aspect.AuthInterceptor;
import net.eric.domain.User;
import net.eric.domain.UserInfo;
import net.eric.exception.LoginException;
import net.eric.mapper.UserInfoMapper;
import net.eric.mapper.UserMapper;
import net.eric.protocol.LoginResponse;
import net.eric.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Eric Zhao
 * @date 2018/2/4
 */
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private JwtService jwtService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestParam("username") String username,
                               @RequestParam("password") String password) throws LoginException {
        User user = userMapper.getUser(username);
        if (user == null) {
            logger.warn("invalid user name {}", username);
            throw new LoginException();
        }
        if (!password.equals(user.getPassword())) {
            logger.warn("invalid password {}", password);
            throw new LoginException();
        }
        String token = jwtService.genToken(user.getId());
        UserInfo userInfo = userInfoMapper.getUserInfo(user.getId());
        return new LoginResponse(token, userInfo);
    }

    @RequestMapping(path = "/get_user_info", method = RequestMethod.GET)
    public UserInfo getUserInfo(@RequestAttribute(AuthInterceptor.AUTH_USER_ID) int id) {
        return userInfoMapper.getUserInfo(id);
    }

    @RequestMapping(path = "/fake", method = RequestMethod.GET)
    public User fake() {
        User user = new User();
        user.setPassword("admin");
        user.setUsername("Eric");
        return user;
    }
}
