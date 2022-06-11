package nl.tomkemper.bep3.messaging.contracts;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    @Bean
    public Exchange exerciseExchange(){
        return ExchangeBuilder.directExchange("exercises").build();
    }

    @Bean
    public Queue demoQueue(){
        return QueueBuilder.durable("exercises-demo-queue").build();
    }

    @Bean
    public Binding demoBinding(){
        return BindingBuilder.bind(demoQueue()).to(exerciseExchange()).with("example-key").noargs();
    }

    @Bean
    MessageConverter getConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
