package br.com.fatecmogidascruzes.topicosbackend1;

import java.sql.SQLException;
import java.util.List;

import br.com.fatecmogidascruzes.topicosbackend1.Produto;

public interface ProdutoDAO {

    void salvar(Produto produto) throws ClassNotFoundException, SQLException;

    void atualizar(Produto produto) throws ClassNotFoundException, SQLException;

    void excluir(int id) throws ClassNotFoundException, SQLException;

    void excluir(Produto produto) throws ClassNotFoundException, SQLException;

    List<Produto> listarTodos() throws ClassNotFoundException, SQLException;

    Produto consultarPorId(int id) throws ClassNotFoundException, SQLException;

}
