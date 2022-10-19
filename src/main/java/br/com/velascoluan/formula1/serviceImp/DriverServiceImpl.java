package br.com.velascoluan.formula1.serviceImp;

import br.com.velascoluan.formula1.model.Driver;
import br.com.velascoluan.formula1.repository.DriverRepository;
import br.com.velascoluan.formula1.service.DriverService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverById(Long driverId) {
        Driver driver = driverRepository.findById(driverId).orElseThrow(() ->
                new IllegalStateException("Driver ID " + driverId + " not found"));

        return driver;
    }

    @Override
    @Transactional
    public void updateDriver(Long driverId, Driver driver) {
        var actualDriver = getDriverById(driverId);

        BeanUtils.copyProperties(driver, actualDriver, "id", "country", "name");

        driverRepository.save(actualDriver);
    }

    @Override
    public void deleteDriver(Long driverId) {
        var driver = getDriverById(driverId);

        driverRepository.delete(driver);
    }

    @Override
    public void registerNewDriver(Driver driver) {
        if (driver != null){
            driverRepository.save(driver);
        }
    }
}
