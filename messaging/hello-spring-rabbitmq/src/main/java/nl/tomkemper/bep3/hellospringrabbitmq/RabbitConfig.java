package nl.tomkemper.bep3.hellospringrabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //Er zijn heel veel willekeurige hendels om aan te trekken bij het configureren van RabbitMQ.
    //Belangrijkste is om kritisch uit te zoeken wat je daadwerkelijk bouwt als je een voorbeelduitwerking
    //op internet overneemt.


    //Tijdens het opstarten maken we deze queue aan, en als deze al bestaat doen we niets
    @Bean
    public Queue demoQueue(){
        return QueueBuilder.durable("hellospring-queue").build();
    }

    //Zonder deze dependency mag je alleen Strings als message versturen
    @Bean
    MessageConverter getConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
