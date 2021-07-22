package com.janwes.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.janwes.pojo.Location;

import java.util.List;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.service
 * @date 2021/7/21 14:13
 * @description
 */
public interface LocationService extends IService<Location> {

    List<Location> getLocations();

    Boolean deleteById(Integer id);

    Boolean insertData(Location location);

    Boolean updateLocation(Location location);
}
