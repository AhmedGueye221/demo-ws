package sn.courwebservice.demo_ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("sn.courwebservice.demo_ws.models")
@EnableJpaRepositories("sn.courwebservice.demo_ws.repository")
public class DemoWsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoWsApplication.class, args);
    }
}