package org.example.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String FILA_DADOS = "amq.direct";



    @Bean
    public Queue filaDados(String nomeFila)
    {
        return new Queue(FILA_DADOS, true,false ,false);
    }

    private DirectExchange trocaDireta(){
        return new DirectExchange(FILA_DADOS);
    }
    private Binding relacionamento (Queue fila,DirectExchange troca){
      return  new Binding(fila.getName(), Binding.DestinationType.EXCHANGE, troca.getName(), FILA_DADOS, null);
    }

     private void adiciona(){
        Queue filaDados =  this.filaDados(FILA_DADOS);

        DirectExchange troca = this.trocaDireta();

        this.relacionamento(filaDados, troca);
     }

}