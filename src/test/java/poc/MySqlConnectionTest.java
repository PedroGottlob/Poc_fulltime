package poc;

import org.example.Main;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Main.class)

public class MySqlConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testMySqlConnection() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            assertNotNull(connection);
            System.out.println("✅ Conexão com MySQL bem-sucedida.");
        }
    }
}