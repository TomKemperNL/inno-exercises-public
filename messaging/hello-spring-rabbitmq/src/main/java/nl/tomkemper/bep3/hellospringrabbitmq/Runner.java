package nl.tomkemper.bep3.hellospringrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final Producer messageProducer;

    public Runner(Producer messageProducer){
        this.messageProducer = messageProducer;
    }

    @Override
    public void run(String... args) throws Exception {
        this.messageProducer.sendTestMessage();
    }
}
