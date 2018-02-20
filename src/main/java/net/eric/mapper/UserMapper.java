package net.eric.mapper;

import net.eric.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * @author Eric Zhao
 * @date 2018/2/4
 */
@Mapper
public interface UserMapper {
    /**
     * 获取用户认证信息
     *
     * @param username 用户名
     * @return 返回用户信息
     */
    @Select("select * from \"user\" where username = #{username}")
    @Results(id = "userResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    User getUser(@Param("username") String username);
}
