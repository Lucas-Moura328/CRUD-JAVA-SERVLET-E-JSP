package br.com.fatecmogidascruzes.topicosbackend1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class GestaoProduto extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String acao = request.getParameter("acao");

        ProdutoDAO produtoDAO = FabricaDAO.getProdutoDAO();

        if (acao == null) {
            try {
                request.setAttribute("produtos", produtoDAO.listarTodos());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if (acao.equalsIgnoreCase("inserir")) {
            try {

                String precoStr = request.getParameter("preco");
                float preco = Float.valueOf(precoStr);

                String nome = request.getParameter("nome");
                String descricao = request.getParameter("descricao");
                String link = request.getParameter("link");

                Produto produto = new Produto(nome, descricao, preco, link);
                produtoDAO.salvar(produto);

                request.getRequestDispatcher("/sucessoInsercao.jsp").forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                request.setAttribute("mensagem", e.getMessage());
                request.getRequestDispatcher("/falhaInsercao.jsp").forward(request, response);
            }
        } else if (request.getParameter("alterar") != null) {
            try {
                String idStr = request.getParameter("alterar");
                int id = Integer.valueOf(idStr);

                request.setAttribute("produto", produtoDAO.consultarPorId(id));
                request.getRequestDispatcher("/alterar.jsp").forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                request.setAttribute("mensagem", e.getMessage());
                request.getRequestDispatcher("/alterar.jsp").forward(request, response);
            }
        } else if (acao.equalsIgnoreCase("atualizar")) {
            try {
                String idStr = request.getParameter("id");
                int id = Integer.valueOf(idStr);

                String precoStr = request.getParameter("preco");
                float preco = Float.valueOf(precoStr);

                String nome = request.getParameter("nome");
                String descricao = request.getParameter("descricao");
                String link = request.getParameter("link");

                Produto produto = new Produto(id, nome, descricao, preco, link);
                produtoDAO.atualizar(produto);

                request.getRequestDispatcher("/sucessoAtualizacao.jsp").forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                request.setAttribute("mensagem", e.getMessage());
                request.getRequestDispatcher("/falhaAtualizacao.jsp").forward(request, response);
            }
        } else if (request.getParameter("excluir") != null) {
            try {
                String idStr = request.getParameter("excluir");
                int id = Integer.valueOf(idStr);

                request.setAttribute("produto", produtoDAO.consultarPorId(id));
                request.getRequestDispatcher("/confirmarExclusao.jsp").forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                request.setAttribute("mensagem", e.getMessage());
                request.getRequestDispatcher("/confirmarExclusao.jsp").forward(request, response);
            }
        } else if (acao.equalsIgnoreCase("confirmarExclusao")) {
            try {
                String idStr = request.getParameter("id");
                int id = Integer.valueOf(idStr);

                Produto produto = new Produto(id);
                produtoDAO.excluir(produto);

                request.getRequestDispatcher("/sucessoExclusao.jsp").forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                request.setAttribute("mensagem", e.getMessage());
                request.getRequestDispatcher("/falhaExclusao.jsp").forward(request, response);
            }
        }

    }



}