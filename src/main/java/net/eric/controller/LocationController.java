package net.eric.controller;

import net.eric.domain.Location;
import net.eric.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Eric Zhao
 * @date 2018/2/7
 */
@RestController
public class LocationController {

    @Autowired
    private LocationMapper locationMapper;

    @RequestMapping(path = "/get_geo_data", method = RequestMethod.GET)
    public List<Location> getAllGeoData() {
        return locationMapper.getAllGeoData();
    }
}
