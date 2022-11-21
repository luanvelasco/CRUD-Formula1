package br.com.velascoluan.formula1.serviceImp;

import br.com.velascoluan.formula1.model.Driver;
import br.com.velascoluan.formula1.model.dto.DriverDto;
import br.com.velascoluan.formula1.modelMapper.DozerMapper;
import br.com.velascoluan.formula1.repository.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class DriverServiceImplTest {

    private Driver driver;
    private DriverDto driverDto;

    @InjectMocks
    private DriverServiceImpl driverService;

    @Mock
    DriverRepository driverRepository;

    @BeforeEach
    void setUpMocks() {
        driver = new Driver();
        driver.setId(1L);
        driver.setName("Name-Test");
        driver.setCountry("Country-Test");
        driver.setTeam("Team-Test");
        driver.setGrandsPrixEntered(150);
        driver.setPodiums(20);
        driver.setPoints(845.45);
        driver.setWorldChampionships(1);

        driverDto = DozerMapper.parseObject(driver, DriverDto.class);
    }

    @Test
    void getDrivers() {
        List<Driver> driverList = new ArrayList<>();
        driverList.add(driver);

        when(driverRepository.findAll()).thenReturn(driverList);

        var drivers = driverService.getDrivers();

        assertNotNull(drivers);
        assertEquals(1, drivers.size());
    }

    @Test
    void getDriverById() {
        /**
         * Estou mockando a seguinte ação no DriverServiceImpl -> driverRepository.findById(driverId)
         * Porém, ele não irá buscar definitivamente no DB, pois estamos mockando o repositório.
         */
        when(driverRepository.findById(1L)).thenReturn(Optional.of(driver));

        var response = driverService.getDriverById(1L);

        assertNotNull(response);
        assertNotNull(response.getKey());
        assertNotNull(response.getLinks());
        System.out.println(response.toString());
        assertTrue(response.toString().contains("links: [</api/v1/driver/1>;rel=\"self\"]"));
    }

    @Test
    void updateDriver() {
        when(driverRepository.findById(1L)).thenReturn(Optional.of(driver));

        var actualDriver = driverService.getDriverById(1L);

        driverDto.setName("Updated-Name");

        driverService.updateDriver(1L, driverDto);

        driverRepository.save(DozerMapper.parseObject(driverDto, Driver.class));
    }

    @Test
    void deleteDriver() {
        when(driverRepository.findById(1L)).thenReturn(Optional.of(driver));

        driverService.deleteDriver(1L);

        var response = driverService.getDriverById(1L);

        driverRepository.delete(DozerMapper.parseObject(response, Driver.class));
    }

    @Test
    void registerNewDriver() {
        when(driverRepository.save(driver)).thenReturn(driver);

        driverService.registerNewDriver(driverDto);
    }
}