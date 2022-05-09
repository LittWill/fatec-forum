<%@ page import="java.util.List" %>
<%@ page import="com.wnra.threadsapp.model.Thread"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
            <!DOCTYPE html>
            <html>

            <head>
                  <meta charset="UTF-8" />
                  <title>Threads</title>
                  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                        crossorigin="anonymous">
                  <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/fontawesome.min.css"
                        integrity="sha512-8Vtie9oRR62i7vkmVUISvuwOeipGv8Jd+Sur/ORKDD5JiLgTGeBSkI3ISOhc730VGvA5VVQPwKIKlmi+zMZ71w=="
                        crossorigin="anonymous" referrerpolicy="no-referrer" />
                  <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/solid.min.css"
                        integrity="sha512-6/gTF62BJ06BajySRzTm7i8N2ZZ6StspU9uVWDdoBiuuNu5rs1a8VwiJ7skCz2BcvhpipLKfFerXkuzs+npeKA=="
                        crossorigin="anonymous" referrerpolicy="no-referrer" />
                  <link rel="stylesheet" href="./styles/listagem-threads.css">
                       
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
                              <li class="nav-item">
                                    <a class="nav-link" href="/threadsapp/threads?acao=criar">Criar</a>
                                  </li>
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

                  

                  <main>

                        <div class="container">

                        <div class="threads">
                              <%
                                    List<Thread> threads = (List <Thread>) request.getAttribute("threads");

                                          for (Thread thread : threads){
                                                %>
                        <div class="thread">

                              <input type="hidden" id="thread-id" value="<%=thread.getId()%>">

                              <div class="card text-center" style="width: 32rem;">
                                    <div class="card-body">
                                          <div class="top">
                                                <ul>
                                                      <li class="autor">Por: <span><%= thread.getAutorNome() %></span></li>
                                                      <li class="categoria">Categoria: <span><%= thread.getCategoria().getNome() %></span></li>
                                                      <li class="data">Data: <span><%= thread.getDataPostagemFormatada() %></span></li>
                                                </ul>
                                          </div>
                                      
                                      <h3 class="card-title"><span class="pergunta"><%= thread.getQuestao() %></span></h3>
                                      <div class="botoes-interacao">
                                      <button class="btn btn-success" id="btn-like" onclick="likeThread('<%= thread.getId() %>')">Like (<span id="likesNum-<%= thread.getId() %>"><%=thread.getLikes()%></span>)</button>
                                      <button class="btn btn-danger" id="btn-dislike" onclick="dislikeThread('<%= thread.getId() %>')">Dislike (<span id="dislikesNum-<%= thread.getId() %>"><%=thread.getDislikes()%></span>)</button>
                                      <a href="/threadsapp/respostas?acao=listar&threadId=<%=thread.getId()%>" class="btn btn-primary">Respostas (<%= thread.getRespostas().size() %>)</a>
                                    </div>
                                    </div>
                                  </div>

                                  <%
                               }
                        %>
                        </div>

                        

                  </div>

            </div>

                  
                  </main>

            </body>

<script src="./js/listagem-threads.js" defer></script>
<script src="./js/navbar-service.js" defe></script>

</html>