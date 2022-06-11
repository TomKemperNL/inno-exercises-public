package nl.tomkemper.bep3.messaging.producer;

import nl.tomkemper.bep3.messaging.contracts.RabbitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        //Normaal worden alleen @ConfigurationClasses die onder het huidige package vallen gebruikt,
        // dus zonder deze extra optie zou RabbitConfig niet ingeladen worden
        scanBasePackageClasses = {RabbitConfig.class, ProducerApplication.class})
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
