<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wnra.threadsapp.model.Thread" %>
<%@ page import="com.wnra.threadsapp.model.Resposta" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8" />
                    <title>Respostas</title>
                    <link rel="stylesheet"
                        href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                        crossorigin="anonymous">

                        <script src="./js/listagem-respostas.js"></script>
                        <link rel="stylesheet" href="./styles/listagem-respostas.css">

                        <style>

                        main {
                            width: 250px;
                            margin: 0 auto;
                            margin-top: 20px;
                        }
                        
                        .respostas {
						width: 250px;
						margin: 0 auto;
						}
                        .resposta {
                            margin-top: 20px;
                        }
                        li {
                            display: inline;
                            list-style: none;
                            font-size: 18px;
                        }
  
                        </style>

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

                    <main>
                    <% Thread thread=(Thread) request.getAttribute("thread"); %>
                    <h3>Thread</h3>
                    <div class="thread">
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
                              <button class="btn btn-success" id="btn-like-thread">Like (<span id="likesNum"><%=thread.getLikes()%></span>)</button>
                              <button class="btn btn-danger" id="btn-dislike-thread">Dislike (<span id="dislikesNum"><%=thread.getDislikes()%></span>)</button>
                            </div>
                            </div>
                          </div>
                    </div>

                        <div class="respostas">
                            <h3>Respostas</h3>
                            <% for(Resposta resposta : thread.getRespostas()){ %>

                                <div class="resposta">

                                    <input type="hidden" id="resposta-id" value="<%= resposta.getId() %>">
                                    <div class="card text-center" style="width: 32rem;">
                                        <div class="card-body">
                                            <div class="top">
                                                <ul>
                                                    <li class="autor">Por: <span>
                                                            <%= resposta.getAutorNome() %>
                                                        </span></li>
                                                    <li class="data">Data: <span>
                                                            <%= resposta.getDataPostagemFormatada() %>
                                                        </span></li>
                                                </ul>
                                            </div>

                                            <h3 class="card-title"><span class="texto">
                                                    <%= resposta.getTexto() %>
                                                </span></h3>
                                                <div class="botoes-interacao">
                                                    <button class="btn btn-success" id="btn-like-resposta">Like (<span id="likesNum"><%=resposta.getLikes()%></span>)</button>
                                                    <button class="btn btn-danger" id="btn-dislike-thread">Dislike (<span id="dislikesNum"><%=resposta.getDislikes()%></span>)</button>
                                                  </div>
                                        </div>
                                    </div>


                                </div>

                        </div>
                        <% } %>

                        <a href="/threadsapp/respostas?acao=criar&threadId=<%=thread.getId()%>">Criar resposta</a>

                        

                    </main>

                </body>

                <script src="./js/service.js" type="module"></script>
                <script src="./js/navbar-service.js" defer></script>

                </html>