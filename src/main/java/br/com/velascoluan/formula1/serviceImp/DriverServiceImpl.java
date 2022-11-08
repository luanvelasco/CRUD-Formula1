package br.com.velascoluan.formula1.serviceImp;

import br.com.velascoluan.formula1.controller.DriverController;
import br.com.velascoluan.formula1.exception.ResourceNotFoundException;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<DriverDto> getDrivers() {
        var drivers =  DozerMapper.parseListObject(driverRepository.findAll(), DriverDto.class);

        drivers.stream().forEach(d -> d.add(linkTo(methodOn(DriverController.class)
                .findDriverById(d.getKey()))
                .withSelfRel()));

        return drivers;
    }

    @Override
    public DriverDto getDriverById(Long driverId) {
        var driver = driverRepository.findById(driverId).orElseThrow(() ->
                new ResourceNotFoundException("Driver ID " + driverId + " not found"));

        var driverDto =  DozerMapper.parseObject(driver, DriverDto.class);

        driverDto.add(linkTo(methodOn(DriverController.class).findDriverById(driverId)).withSelfRel());

        return driverDto;
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
