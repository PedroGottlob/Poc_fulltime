package poc;

import org.example.Main;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Main.class)

public class RabbitMQConnectionTest {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Test
    public void testRabbitMQConnection() {
        assertNotNull(connectionFactory.createConnection());
        System.out.println("✅ Conexão com RabbitMQ bem-sucedida.");
    }
}
