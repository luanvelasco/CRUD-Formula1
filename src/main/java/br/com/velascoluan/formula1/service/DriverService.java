package br.com.velascoluan.formula1.service;

import br.com.velascoluan.formula1.model.dto.DriverDto;

import java.util.List;

public interface DriverService{

    List<DriverDto> getDrivers();

    DriverDto getDriverById(Long driverId);

    void updateDriver(Long driverId, DriverDto driver);

    void deleteDriver(Long driverId);

    void registerNewDriver(DriverDto driver);
}
