/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.aplicacaoPDV.dao;

import br.com.aplicacaoPDV.jdbc.ConnectionFactory;
import br.com.aplicacaoPDV.model.Clientes;
import br.com.aplicacaoPDV.model.Funcionarios;
import br.com.aplicacaoPDV.view.jfMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lustosas
 */
public class FuncionarioDAO {

    private Connection con;

    //Construtor
    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Método cadastrarFuncionario
    public void cadastrarFuniconario(Funcionarios obj) {
        try {
            //1º passo: Criar o comando SQL
            String sql = "INSERT INTO tb_funcionarios (nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero,"
                    + "complemento, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //2° passo: Conectar ao banco e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql); //Chama as declarações, passando a string sql como parametro
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            //3° passo: executa a query sql
            stmt.execute(); //executa a instruções repassadas pela string sql
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário Cadastrado com Sucesso!!!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Funcionário" + erro, "Erro", 0);
        }

    }

    // Método alterar funcionario
    public void alterarFuncionario(Funcionarios obj) {

        try {
            //1º passo: Criar o comando SQL
            String sql = "UPDATE tb_funcionarios SET nome=?, rg=?, cpf=?, email=?, senha=?,"
                    + "cargo=?, nivel_acesso=?, telefone=?, celular=?,"
                    + " cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? WHERE id=?";

            //2° passo: Conectar ao banco e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql); //Chama as declarações, passando a string sql como parametro
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            stmt.setInt(17, obj.getId());

            //3° passo: executa a query sql
            stmt.execute(); //executa a instruções repassadas pela string sql
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário Atualizado com Sucesso!!!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Funcionário" + erro, "Erro", 0);
        }

    }

    //Método Excluir funcionários
    public void excluirFuncionario(Funcionarios obj) {

        try {
            //1º passo: Criar o comando SQL
            String sql = "DELETE FROM tb_funcionarios WHERE id = ?";

            //2° passo: Conectar ao banco e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql); //Chama as declarações, passando a string sql como parametro
            stmt.setInt(1, obj.getId());

            //3° passo: executa a query sql
            stmt.execute(); //executa a instruções repassadas pela string sql
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário Excluído com Sucesso!!!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Funcionário" + erro, "Erro", 0);
        }

    }

    //Método Listar todos os funcionários  
    public List<Funcionarios> listarFuncionarios() {
        try {
            //1º Passo: Criar a lista
            List<Funcionarios> lista = new ArrayList<>();

            //2° Passo: Criar o comando SQL
            String sql = "SELECT * FROM tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            //Lista os 
            while (rs.next()) {
                Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id")); //acessa o número que está na coluna 'id' da tabela
                obj.setNome(rs.getString("nome")); //acessa o texto que está na coluna 'nome' da tabela
                obj.setRg(rs.getString("Rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
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

    //Consulta Funcionario por nome: retorna um único nome
    public Funcionarios consultaPorNome(String nome) {
        try {
            String sql = "SELECT * FROM tb_funcionarios WHERE nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Funcionarios obj = new Funcionarios();
            if (rs.next()) {

                obj.setId(rs.getInt("id")); //acessa o número que está na coluna 'id' da tabela
                obj.setNome(rs.getString("nome")); //acessa o texto que está na coluna 'nome' da tabela
                obj.setRg(rs.getString("Rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));

                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));

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
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
            return null;
        }

    }

    //Método buscar funcionario Por Nome: Retorna uma lista de Funcionarios na tabela
    public List<Funcionarios> buscaFuncionairoPorNome(String nome) {
        try {
            //1º Passo: Criar a lista
            List<Funcionarios> lista = new ArrayList<>();

            //2° Passo: Criar o comando SQL
            String sql = "SELECT * FROM tb_funcionarios WHERE nome LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            //Lista os 
            while (rs.next()) {
                Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id")); //acessa o número que está na coluna 'id' da tabela
                obj.setNome(rs.getString("nome")); //acessa o texto que está na coluna 'nome' da tabela
                obj.setRg(rs.getString("Rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));

                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));

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

    //Método efetuaLogin
    public void efetuaLogin(String email, String senha) {

        try {
            //SQL
            String sql = "select*from tb_funcionarios where email = ? and senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //Usuari logou
                JOptionPane.showMessageDialog(null, "Seja Bem-Vindo!");

                //Chamando a tela de menus
                jfMenu tela = new jfMenu();
                tela.setVisible(true);
                

            } else {
                //Não logou
                JOptionPane.showMessageDialog(null, "Dados Incorretos!");

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }

    }

}
