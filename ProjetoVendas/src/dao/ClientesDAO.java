/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Cliente;

/**
 *
 * @author osval
 */
public class ClientesDAO {
   
    private Connection con;
    
    public ClientesDAO(){
        this.con = new ConnectionFactory().getConnetion();
    }
    
    //Metodo CadastrarCliente
    public void cadastrarCliente(Cliente obj){
        try {
            //criar comando sql
            String sql="insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,cidade,estado)"
                                             + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setInt(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(11,obj.getCidade());
            stmt.setString(12,obj.getUf());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showConfirmDialog(null,"Cadastrado com Sucesso!");
            
        } catch (SQLException erro){
            JOptionPane.showConfirmDialog(null,"Erro:"+erro);
 
    }
}
     //Metodo AlterarCliente
    public void alterarCliente(){
        
    }
     //Metodo ExcluirCliente
    public void excluirCliente(){
        
    }
 }   
