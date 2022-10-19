package br.com.velascoluan.formula1.service;

import br.com.velascoluan.formula1.model.Driver;

import java.util.List;

public interface DriverService{

    List<Driver> getDrivers();

    Driver getDriverById(Long driverId);

    void updateDriver(Long driverId, Driver driver);

    void deleteDriver(Long driverId);

    void registerNewDriver(Driver driver);
}
