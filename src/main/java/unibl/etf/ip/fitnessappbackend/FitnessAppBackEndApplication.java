package unibl.etf.ip.fitnessappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@EnableScheduling
@SpringBootApplication
public class FitnessAppBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessAppBackEndApplication.class, args);
    }

}
