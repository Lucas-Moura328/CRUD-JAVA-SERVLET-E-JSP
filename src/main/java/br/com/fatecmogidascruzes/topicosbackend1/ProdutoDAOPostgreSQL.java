package br.com.fatecmogidascruzes.topicosbackend1;

import br.com.fatecmogidascruzes.topicosbackend1.persistencia.BancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOPostgreSQL implements ProdutoDAO {

    @Override
    public void salvar(Produto produto) throws ClassNotFoundException, SQLException {
        try (Connection conexao = BancoDados.getConexao()) {
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO _produtos(nome, descricao, preco, link) VALUES(?, ?, ?,?)");
            sql.setString(1, produto.getNome());
            sql.setString(2, produto.getDescricao());
            sql.setFloat(3, produto.getPreco());
            sql.setString(4, produto.getLink());
            sql.executeUpdate();
        }
    }

    @Override
    public void atualizar(Produto produto) throws ClassNotFoundException, SQLException {
        try (Connection conexao = BancoDados.getConexao()) {
            PreparedStatement sql = conexao.prepareStatement("UPDATE _produtos SET nome=?, descricao=?, preco=?, link=? WHERE id=?");
            sql.setString(1, produto.getNome());
            sql.setString(2, produto.getDescricao());
            sql.setFloat(3, produto.getPreco());
            sql.setString(4, produto.getLink());
            sql.setInt(5, produto.getId());
            sql.executeUpdate();
        }
    }

    @Override
    public void excluir(int id) throws ClassNotFoundException, SQLException {
        try (Connection conexao = BancoDados.getConexao()) {
            PreparedStatement sql = conexao.prepareStatement("DELETE FROM _produtos WHERE id=?");
            sql.setInt(1, id);
            sql.executeUpdate();
        }
    }

    @Override
    public void excluir(Produto produto) throws ClassNotFoundException, SQLException {
        excluir(produto.getId());
    }

    @Override
    public List<Produto> listarTodos() throws ClassNotFoundException, SQLException {
        try (Connection conexao = BancoDados.getConexao()) {
            PreparedStatement sql = conexao.prepareStatement("SELECT id, nome, descricao, preco, link FROM _produtos");
            ResultSet resultado = sql.executeQuery();
            List<Produto> produtos = new ArrayList<>();
            while (resultado.next()) {
                Produto produto = new Produto(resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("descricao"),
                        resultado.getFloat("preco"),
                        resultado.getString("link"));
                produtos.add(produto);
            }
            return produtos;
        }
    }

    @Override
    public Produto consultarPorId(int id) throws ClassNotFoundException, SQLException {
        try (Connection conexao = BancoDados.getConexao()) {
            PreparedStatement sql = conexao.prepareStatement("SELECT id, nome, descricao, preco, link FROM _produtos WHERE id=?");
            sql.setInt(1, id);

            Produto produto = null;
            ResultSet resultado = sql.executeQuery();
            if (resultado.next()) {
                produto = new Produto(resultado.getInt("id"),
                resultado.getString("nome"),
                resultado.getString("descricao"),
                resultado.getFloat("preco"),
                resultado.getString("link"));
            }
            return produto;
        }
    }

}
