package com.janwes.controller;

import com.janwes.common.Result;
import com.janwes.pojo.Location;
import com.janwes.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.controller
 * @date 2021/7/21 14:11
 * @description
 */
@Api(tags = "地理位置")
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @ApiOperation(value = "地理位置信息列表")
    @GetMapping("/list")
    public Result<List<Location>> getLocations() {
        return Result.ok(locationService.getLocations());
    }

    @ApiOperation(value = "删除地理位置信息")
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteById(@PathVariable("id") Integer id) {
        return Result.ok(locationService.deleteById(id));
    }

    @ApiOperation(value = "保存地理位置信息")
    @PostMapping("/add")
    public Result<Boolean> insertData(@RequestBody Location location) {
        return Result.ok(locationService.insertData(location));
    }

    @ApiOperation(value = "更新地理位置信息")
    @PutMapping("/update")
    public Result<Boolean> updateLocation(@RequestBody Location location) {
        return Result.ok(locationService.updateLocation(location));
    }
}
