package org.example.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "minhaFila";
    public static final String EXCHANGE_NAME = "meuExchange";
    public static final String ROUTING_KEY = "minha.chave.routing";

    @Bean
    public Queue fila() {
        return new Queue(QUEUE_NAME, true); // durável
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue fila, TopicExchange exchange) {
        return BindingBuilder.bind(fila).to(exchange).with(ROUTING_KEY);
    }
}
