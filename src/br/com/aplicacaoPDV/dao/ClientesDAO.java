/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.aplicacaoPDV.dao;

import br.com.aplicacaoPDV.jdbc.ConnectionFactory;
import br.com.aplicacaoPDV.model.Clientes;
import br.com.aplicacaoPDV.model.WebServiceCep;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientesDAO {

    //Para cada Tabela do BD exite uma classe DAO
    //As classes DAO inserem os dados das classes da camada de modelo no BD
    private Connection con;

    //Construtor
    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Método cadastrarClientes
    public void cadastrarCliente(Clientes obj) {
        try {
            //1º passo: Criar o comando SQL
            String sql = "INSERT INTO tb_clientes (nome, rg, cpf, email,telefone, celular, cep, endereco, numero,"
                    + "complemento, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //2° passo: Conectar ao banco e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql); //Chama as declarações, passando a string sql como parametro
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
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            //3° passo: executa a query sql
            stmt.execute(); //executa a instruções repassadas pela string sql
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!!!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Cliente" + erro, "Erro", 0);
        }

    }

    //Método alterarCliente
    public void alterarCliente(Clientes obj) {

        try {
            //1º passo: Criar o comando SQL
            String sql = "UPDATE tb_clientes SET nome=?, rg=?, cpf=?, email=?,telefone=?, celular=?,"
                    + " cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? WHERE id=?";

            //2° passo: Conectar ao banco e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql); //Chama as declarações, passando a string sql como parametro
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
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setInt(14, obj.getId());

            //3° passo: executa a query sql
            stmt.execute(); //executa a instruções repassadas pela string sql
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente Atualizado com Sucesso!!!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Cliente" + erro, "Erro", 0);
        }

    }

    //Método excluirCliente
    public void excluirCliente(Clientes obj) {

        try {
            //1º passo: Criar o comando SQL
            String sql = "DELETE FROM tb_clientes WHERE id = ?";

            //2° passo: Conectar ao banco e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql); //Chama as declarações, passando a string sql como parametro
            stmt.setInt(1, obj.getId());

            //3° passo: executa a query sql
            stmt.execute(); //executa a instruções repassadas pela string sql
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente Excluído com Sucesso!!!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Cliente" + erro, "Erro", 0);
        }

    }

    //Método listarCliente
    public List<Clientes> listarCliente() {
        try {
            //1º Passo: Criar a lista
            List<Clientes> lista = new ArrayList<>();

            //2° Passo: Criar o comando SQL
            String sql = "SELECT * FROM tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            //Lista os 
            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id")); //acessa o número que está na coluna 'id' da tabela
                obj.setNome(rs.getString("nome")); //acessa o texto que está na coluna 'nome' da tabela
                obj.setRg(rs.getString("Rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }
            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }

    //Consulta Cliente por nome: retorna um único nome
    public Clientes consultaPorNome(String nome) {
        try {
            String sql = "SELECT * FROM tb_clientes WHERE nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            if (rs.next()) {

                obj.setId(rs.getInt("id")); //acessa o número que está na coluna 'id' da tabela
                obj.setNome(rs.getString("nome")); //acessa o texto que está na coluna 'nome' da tabela
                obj.setRg(rs.getString("Rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
    
    }

    //Método buscarClientePorNome: Retorna uma lista de clientes na tabela
    public List<Clientes> buscaClientePorNome(String nome) {
        try {
            //1º Passo: Criar a lista
            List<Clientes> lista = new ArrayList<>();

            //2° Passo: Criar o comando SQL
            String sql = "SELECT * FROM tb_clientes WHERE nome LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            //Lista os 
            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id")); //acessa o número que está na coluna 'id' da tabela
                obj.setNome(rs.getString("nome")); //acessa o texto que está na coluna 'nome' da tabela
                obj.setRg(rs.getString("Rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }
            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }
    
    
    //Busca cep
    
      public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull()); //getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
      //
      
      
}
