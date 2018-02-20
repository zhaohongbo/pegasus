package net.eric.mapper;

import net.eric.domain.UserInfo;
import org.apache.ibatis.annotations.*;

/**
 * @author Eric Zhao
 * @date 2018/2/13
 */
@Mapper
public interface UserInfoMapper {
    @Select("select * from \"user_info\" where uid = #{uid}")
    @Results(id = "userInfoResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "uid", column = "uid"),
            @Result(property = "nickname", column = "nickname")
    })
    UserInfo getUserInfo(@Param("uid") int uid);
}
