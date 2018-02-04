package net.eric.api;

import net.eric.domain.User;
import net.eric.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric Zhao
 * @date 2018/2/4
 */
@RestController
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public User login(@RequestParam("username") String username,
                      @RequestParam("password") String password) {
        String realPassword = userMapper.getPassword(username);
        if (password.equals(realPassword)) {
            return null;
        }
        return userMapper.getUserInfo(username);
    }

    @RequestMapping(path = "/fake", method = RequestMethod.GET)
    public User fake() {
        User user = new User();
        user.setRole("admin");
        user.setUsername("Eric");
        return user;
    }
}
