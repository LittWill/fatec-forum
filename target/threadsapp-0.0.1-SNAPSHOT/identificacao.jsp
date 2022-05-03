<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                        crossorigin="anonymous">
    <link rel="stylesheet" href="./styles/identificacao.css">
    
    <title>Login</title>

</head>
<body>

    <div class="container mt-3" style="width: 400px;">

    <h2>Olá! Insira seu nome antes de começar!</h2>

    <form>
        <div class="mb-3">
          <label for="nome" class="form-label">Nome</label>
          <input type="nome" class="nome" id="nome" required>
          <button type="button" class="btn btn-primary" id="botao-submit" disabled>Pronto</button>
        </div>        
      </form>
    </div>
    
</body>

<script src="./js/identificacao.js"></script>

</html>