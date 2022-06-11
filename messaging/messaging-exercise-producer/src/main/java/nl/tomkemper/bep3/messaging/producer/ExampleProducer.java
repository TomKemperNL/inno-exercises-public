package nl.tomkemper.bep3.messaging.producer;

import nl.tomkemper.bep3.messaging.contracts.SharedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ExampleProducer {

    private RabbitTemplate rabbitTemplate;

    public ExampleProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(SharedMessage message) {
        //TODO maak en stuur een bericht naar de queue
        //In dit geval willen we juist de exchange gebruiken, dus zorg dat je niet de queue-naam gebruikt.
    }
}
