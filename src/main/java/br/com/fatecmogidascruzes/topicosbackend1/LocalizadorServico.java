package br.com.fatecmogidascruzes.topicosbackend1;

public class LocalizadorServico {

    public static ProdutoDAO getProdutoDAO() {
        return new ProdutoDAOPostgreSQL();
    }

}
