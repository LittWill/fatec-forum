<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wnra.threadsapp.dao.CategoriaDAO"%>
<%@ page import="com.wnra.threadsapp.model.Categoria"%>
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
    
    <title>Criar Thread</title>

</head>
<body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="/threadsapp/threads?acao=listar">Threads</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Ex.: Como ocorre a chuva?" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Buscar</button>
        </form>
      </div>

      <li class="nav-item">
          <div class="sessao" id="sessao">
                <span id="nome-usuario" style="color: white;">Usuário: </span>
                <button class="btn btn-danger">Sair</button>
          </div>
    </li>
    </div>
  </nav>

    <div class="container mt-3" style="width: 400px;">

    <h2>Criar Thread</h2>

    <form method="post" action="/threadsapp/threads?acao=salvar">
      
        <div class="mb-3">
          <input type="hidden" name="autorNome" id="autorNome">
          <div>
          <label for="categoria">Categoria</label>
            <select name="categoria" id="categoria">
                <% 
                
                List<Categoria> categorias = (List <Categoria>) request.getAttribute("categorias");

                  for (Categoria categoria : categorias){
              %>
                <option value="<%=categoria.getNome()%>"><%=categoria.getNome()%></option>
                <%
                  }
                %>
                 
            </select>
          </div>
          <label for="questao" class="form-label">Questão</label>
          <input type="text" class="questao" name="questao" id="questao" required>
          <button type="submit" class="btn btn-primary" id="botao-submit">Postar</button>
        </div>        
      </form>
    </div>
    
</body>

<script src="./js/criar-thread.js" defer></script>
<script src="./js/navbar-service.js" defer></script>


</html>