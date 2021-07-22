package com.janwes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.janwes.mapper.LocationMapper;
import com.janwes.pojo.Location;
import com.janwes.service.LocationService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.service.impl
 * @date 2021/7/21 14:13
 * @description
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements LocationService {

    @Cacheable(cacheNames = "locations") // redis缓存
    @Override
    public List<Location> getLocations() {
        return list();
    }

    @CacheEvict(cacheNames = "locations", allEntries = true) // 清除缓存
    @Override
    public Boolean deleteById(Integer id) {
        return removeById(id);
    }

    /**
     * acheNames 设置缓存的值
     * key：指定缓存的key，这是指参数id值。 key可以使用spEl表达式,也可以是指定对象的成员变量
     *
     * @param location
     * @return
     */
    @CacheEvict(cacheNames = "locations", allEntries = true)
    @Override
    public Boolean insertData(Location location) {
        return save(location);
    }

    @CacheEvict(cacheNames = "locations", allEntries = true)
    @Override
    public Boolean updateLocation(Location location) {
        return updateById(location);
    }
}
