/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Cliente;

/**
 *
 * @author osval
 */
public class ClientesDAO {

    private Connection con;

    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnetion();
    }

    //Metodo CadastrarCliente
    public void cadastrarCliente(Cliente obj) {
        try {
            //criar comando sql
            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());

            stmt.execute();
            stmt.close();

            JOptionPane.showConfirmDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "Erro:" + erro);

        }
    }
    //Metodo AlterarCliente

    public void alterarCliente() {

    }
    //Metodo ExcluirCliente

    public void excluirCliente() {

    }

    //Metodo ListarCliente
    public List<Cliente> ListarClientes() {
        try {

            // 1 Passo Crio a Lista
            List<Cliente> lista = new ArrayList<>();

            //2 Passo - criar o sql, organizar e executar.
            String sql = "select*from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }
}
