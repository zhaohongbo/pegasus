package net.eric.mapper;

import net.eric.domain.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Eric Zhao
 * @date 2018/2/13
 */
@Mapper
public interface LocationMapper {
    @Select("select * from \"geo_data\"")
    @Results(id = "geoDataResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "longitude", column = "longitude"),
            @Result(property = "latitude", column = "latitude"),
            @Result(property = "value", column = "value"),
            @Result(property = "name", column = "name"),
            @Result(property = "createAt", column = "create_at")
    })
    List<Location> getAllGeoData();
}
