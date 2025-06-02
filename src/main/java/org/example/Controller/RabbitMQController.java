package org.example.Controller;

import org.example.RabbitTemplate.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mensagens")
public class RabbitMQController {

    private final RabbitMQProducer producer;

    public RabbitMQController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarMensagem(@RequestParam String id) {
        producer.enviarMensagem(id);
        return ResponseEntity.ok("📤 Mensagem com ID enviada para o RabbitMQ: " + id);
    }
}
