package org.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String FILA_DADOS = "fila.dados";

    @Bean
    public Queue filaDados() {
        return new Queue(FILA_DADOS, true);
    }
}