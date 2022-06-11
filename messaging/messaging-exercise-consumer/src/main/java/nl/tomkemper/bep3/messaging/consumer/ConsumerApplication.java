package nl.tomkemper.bep3.messaging.consumer;


import nl.tomkemper.bep3.messaging.contracts.RabbitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackageClasses = {RabbitConfig.class, ConsumerApplication.class})
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
