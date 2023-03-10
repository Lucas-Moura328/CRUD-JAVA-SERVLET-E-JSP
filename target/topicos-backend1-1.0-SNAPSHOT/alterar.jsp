<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.com.fatecmogidascruzes.topicosbackend1.Produto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Alterar produto</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/fontawesome.min.css"
          integrity="sha512-8Vtie9oRR62i7vkmVUISvuwOeipGv8Jd+Sur/ORKDD5JiLgTGeBSkI3ISOhc730VGvA5VVQPwKIKlmi+zMZ71w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/solid.min.css"
          integrity="sha512-6/gTF62BJ06BajySRzTm7i8N2ZZ6StspU9uVWDdoBiuuNu5rs1a8VwiJ7skCz2BcvhpipLKfFerXkuzs+npeKA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="offset-lg-3 col-lg-6">
            <h1>Alterar produto</h1>
            <%
                Produto produto = (Produto) request.getAttribute("produto");
                if (produto != null) {
            %>
                <form action="produto" method="get">
                    <input type="hidden" name="id" value="<%= produto.getId() %>" />
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" id="nome" class="form-control" value="<%= produto.getNome() %>" />
                    <label for="descricao">Descricao:</label>
                    <input type="text" name="descricao" id="descricao" class="form-control" value="<%= produto.getDescricao() %>" />
                    <label for="preco">preco:</label>
                    <input type="text" name="preco" id="preco" class="form-control" value="<%= produto.getPreco() %>" />
                    <label for="link">Link da imagem:</label>
                    <input type="text" name="link" id="link" class="form-control" value="<%= produto.getLink() %>" />
                    <button class="btn btn-primary" name="acao" value="atualizar">Alterar</button>
                </form>
            <%
                } else {
                    out.println("Nenhum produto com este identificador foi encontrado");
                }
            %>
        </div>
    </div>
</div>
</body>
</html>