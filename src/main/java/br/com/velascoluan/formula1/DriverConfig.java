package br.com.velascoluan.formula1;

import br.com.velascoluan.formula1.model.Driver;
import br.com.velascoluan.formula1.repository.DriverRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DriverConfig {
    @Bean
    CommandLineRunner commandLineRunner(DriverRepository driverRepository){
        return args -> {
            Driver max = new Driver(
                    "Max Verstappen",
                    "Red Bull Racing",
                    "Netherlands",
                    74,
                    2,
                    159,
                    1923.5);

            Driver checo = new Driver(
                    "Carlos Peres",
                    "Red Bull Racing",
                    "Mexico",
                    24,
                    0,
                    232,
                    1149.0);

            driverRepository.saveAll(List.of(max, checo));
        };
    }
}
