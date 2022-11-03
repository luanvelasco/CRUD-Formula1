package br.com.velascoluan.formula1.controller;

import br.com.velascoluan.formula1.model.dto.DriverDto;
import br.com.velascoluan.formula1.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping(
            path = "/drivers",
            produces = {MediaType.APPLICATION_JSON_VALUE,
                        MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<DriverDto>> findAllDrivers(){
        var response = driverService.getDrivers();
        return ResponseEntity.ok(response);
    }

    @GetMapping(
            path = "/{driverId}",
            produces = {MediaType.APPLICATION_JSON_VALUE,
                        MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DriverDto> findDriverById(@PathVariable("driverId") Long driverId){
        var response = driverService.getDriverById(driverId);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/{driverId}")
    public ResponseEntity<?> updateDriver(
            @PathVariable("driverId") Long driverId,
            @RequestBody DriverDto driver) {

       driverService.updateDriver(driverId, driver);
       return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> registerNewDriver(@RequestBody DriverDto driver){
        driverService.registerNewDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "/{driverId}")
    public ResponseEntity<?> deleteDriver(@PathVariable("driverId") Long driverId){
        driverService.deleteDriver(driverId);
        return ResponseEntity.ok().build();
    }

}
