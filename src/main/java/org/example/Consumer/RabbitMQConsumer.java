package org.example.Consumer;

import org.apache.logging.log4j.message.Message;
import org.example.Config.RabbitMQConfig;
import org.example.Service.IntegracaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
    private final IntegracaoService integracaoService;

    public RabbitMQConsumer(IntegracaoService integracaoService) {
        this.integracaoService = integracaoService;
    }
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void listen(String id) {
        logger.info("📥 ID recebido do RabbitMQ: {}", id);
        try {
            integracaoService.processarId(id);
            logger.info("✅ ID processado com sucesso: {}", id);
        } catch (Exception e) {
            logger.error("❌ Erro ao processar ID {}: {}", id, e.getMessage(), e);
        }
    }


}
