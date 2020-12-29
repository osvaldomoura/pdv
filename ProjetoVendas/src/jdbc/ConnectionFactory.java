package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public Connection getConnection(){
        
        try {
            
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas","mercado","123456");
            
        } catch (Exception e) {
            String erro = null;
         throw new RuntimeException(erro);
        }
    }

    public Connection getConnetion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
