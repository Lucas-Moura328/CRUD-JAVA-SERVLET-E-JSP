<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inserir produto</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="offset-lg-3 col-lg-6">
            <h1>Inserir produto</h1>
            <form action="produto" method="post">
                <label for="nome">Nome:</label>
                <input type="text" name="nome" id="nome" class="form-control" />
                <label for="descricao">Descricao:</label>
                <input type="text" name="descricao" id="descricao" class="form-control" />
                <label for="preco">preco:</label>
                <input type="text" name="preco" id="preco" class="form-control" />
                <label for="link">Link da imagem:</label>
                <input type="text" name="link" id="link" class="form-control" />
                <button class="btn btn-primary" name="acao" value="inserir">Cadastrar</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>