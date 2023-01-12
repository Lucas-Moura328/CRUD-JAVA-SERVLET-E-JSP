package br.com.fatecmogidascruzes.topicosbackend1;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private float preco;
    private String link;

    public Produto(int id) {
        this.id = id;
    }

    public Produto(int id, String nome, String descricao, float preco, String link) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.link = link;
    }

    public Produto(String nome, String descricao, float preco, String link) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.link = link;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public String getLink() {
        return link;
    }

    public void setNome(String nome) {
    this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    public float getPreco() {
        return preco;
    }
}
