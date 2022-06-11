package nl.tomkemper.bep3.hellospringrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    //Een RabbitTemplate is een object dat relatief rauw dingen naar RabbitMQ kan sturen.
    //de spring-amqp-starter zorgt er voor dat dit ge-injecteerd kan worden.
    private RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTestMessage() {
        //TODO maak en stuur een bericht naar de queue
        //We doen in deze oefening niets met 'exchanges', dus je kunt gewoon de queue-naam gebruiken
    }
}
