package poc;


import com.mongodb.client.MongoClient;
import org.example.Main;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Main.class)

public class MongoConnectionTest {

    @Autowired
    private MongoClient mongoClient;

    @Test
    public void testMongoConnection() {
        assertNotNull(mongoClient.getDatabase("BancoPocMongo"));
        System.out.println("✅ Conexão com MongoDB bem-sucedida.");
    }
}
