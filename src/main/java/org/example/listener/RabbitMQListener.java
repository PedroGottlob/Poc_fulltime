package org.example.listener;

import org.example.config.RabbitConfig;
import org.example.service.DadoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    private final DadoService dadoService;

    public RabbitMQListener(DadoService dadoService) {
        this.dadoService = dadoService;
    }

    @RabbitListener(queues = RabbitConfig.FILA_DADOS)
    public void receberMensagem(String mensagem) {
        System.out.println("Mensagem recebida da fila: " + mensagem);
        dadoService.sincronizarDados();
    }
}