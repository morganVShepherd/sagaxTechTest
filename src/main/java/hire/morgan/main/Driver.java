package hire.morgan.main;

import hire.morgan.service.LogicService;

import hire.morgan.service.impl.LogicServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Driver {
    public static void main(String[] args) {
        SpringApplication.run(Driver.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean
    public LogicService logicService() {
        return new LogicServiceImpl();
    }
}
