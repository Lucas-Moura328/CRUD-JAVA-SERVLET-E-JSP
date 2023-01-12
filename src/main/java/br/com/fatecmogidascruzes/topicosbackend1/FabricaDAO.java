package br.com.fatecmogidascruzes.topicosbackend1;

public class FabricaDAO {
    public static ProdutoDAO getProdutoDAO() {
        return new ProdutoDAOPostgreSQL();
    }

}
