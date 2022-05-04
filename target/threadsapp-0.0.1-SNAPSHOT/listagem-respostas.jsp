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
                              <button class="btn btn-success" onclick="like('<%= thread.getId() %>')">Like (<span id="likesNum"><%=thread.getLikes()%></span>)</button>
                              <button class="btn btn-danger" onclick="dislike('<%= thread.getId() %>')">Dislike (<span id="dislikesNum"><%=thread.getDislikes()%></span>)</button>
                            </div>
                            </div>
                          </div>
                    </div>

                        <div class="respostas">
                            <h3>Respostas</h3>
                            <% for(Resposta resposta : thread.getRespostas()){ %>

                                <div class="resposta">
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
                                                    <button class="btn btn-success" onclick="like('<%= resposta.getId() %>')">Like (<span id="likesNum"><%=resposta.getLikes()%></span>)</button>
                                                    <button class="btn btn-danger" onclick="dislike('<%= resposta.getId() %>')">Dislike (<span id="dislikesNum"><%=resposta.getDislikes()%></span>)</button>
                                                  </div>
                                        </div>
                                    </div>


                                </div>

                        </div>
                        <% } %>

                    </main>

                </body>

                <script src="./js/service.js" type="module"></script>

                </html>