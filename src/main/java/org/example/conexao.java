package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {
    private static final String USUARIO= "root";
    private static final String SENHA = "1234";
    private static final String URL = "root@localhost:3306";
    private static final String DRIVER = "";


    public static Connection abrir() throws Exception{
         Class.forName(DRIVER);
         Connection conn = DriverManager.getConnection(URL, USUARIO,SENHA);
         return conn;
    }
}
