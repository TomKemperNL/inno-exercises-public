package nl.tomkemper.bep3.messaging.producer;

import nl.tomkemper.bep3.messaging.contracts.SharedMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private ExampleProducer producer;

    public Runner(ExampleProducer producer){
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
        SharedMessage testMessage = new SharedMessage("Hoi", 9999);
        this.producer.sendMessage(testMessage);
    }
}
