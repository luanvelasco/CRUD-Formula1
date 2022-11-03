package br.com.velascoluan.formula1.serviceImp;

import br.com.velascoluan.formula1.model.Driver;
import br.com.velascoluan.formula1.model.dto.DriverDto;
import br.com.velascoluan.formula1.modelMapper.DozerMapper;
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
    public List<DriverDto> getDrivers() {
        var drivers =  driverRepository.findAll();
        return DozerMapper.parseListObject(drivers, DriverDto.class);
    }

    @Override
    public DriverDto getDriverById(Long driverId) {
        var driver = driverRepository.findById(driverId).orElseThrow(() ->
                new IllegalStateException("Driver ID " + driverId + " not found"));

        return DozerMapper.parseObject(driver, DriverDto.class);
    }

    @Override
    @Transactional
    public void updateDriver(Long driverId, DriverDto driver) {
        var actualDriver = getDriverById(driverId);

        BeanUtils.copyProperties(driver, actualDriver, "id", "country", "name");

        driverRepository.save(DozerMapper.parseObject(actualDriver, Driver.class));
    }

    @Override
    public void deleteDriver(Long driverId) {
        var driver = getDriverById(driverId);

        driverRepository.delete(DozerMapper.parseObject(driver, Driver.class));
    }

    @Override
    public void registerNewDriver(DriverDto driver) {
        if (driver != null){
            driverRepository.save(DozerMapper.parseObject(driver, Driver.class));
        }
    }
}
