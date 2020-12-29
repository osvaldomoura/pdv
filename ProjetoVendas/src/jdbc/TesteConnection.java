
package jdbc;

import javax.swing.JOptionPane;

public class TesteConnection{
    
    public static void main(String[] args) {
        
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null,"Conectado com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"Aconteceu um Erro:" +erro);
        }
    }
    
}
