package nl.tomkemper.bep3.hellospringrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    //TODO: Gebruik de @RabbitListener annotatie op een methode om berichten op te kunnen halen.
    //We doen in deze oefening niets met 'exchanges', dus je kunt gewoon de queue-naam gebruiken
}
