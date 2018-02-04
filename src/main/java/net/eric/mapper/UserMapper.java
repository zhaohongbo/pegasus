package net.eric.mapper;

import net.eric.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Eric Zhao
 * @date 2018/2/4
 */
@Mapper
public interface UserMapper {
    @Select("select password from user where username = #{username}")
    String getPassword(@Param("username") String username);

    @Select("select password from user_info where username = #{username}")
    User getUserInfo(@Param("username") String username);
}
