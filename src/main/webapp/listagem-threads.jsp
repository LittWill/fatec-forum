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

                  <div class="sessao" id="sessao">
                        <span id="nome-usuario">Usuário: </span>
                        <button class="btn btn-danger">Sair</button>
                  </div>

                  <main>

                        <div class="threads">
                              <%
                                    List<Thread> threads = (List <Thread>) request.getAttribute("threads");

                                          if (threads == null){
                                                request.getRequestDispatcher("/threads").forward(request, response);
                                                return;
                                          }

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
                                      <button class="btn btn-success" id="btn-like">Like (<span id="likesNum"><%=thread.getLikes()%></span>)</button>
                                      <button class="btn btn-danger" id="btn-dislike">Dislike (<span id="dislikesNum"><%=thread.getDislikes()%></span>)</button>
                                      <a href="/threadsapp/threads?acao=respostas&id=<%=thread.getId()%>" class="btn btn-primary">Respostas (<%= thread.getRespostas().size() %>)</a>
                                    </div>
                                    </div>
                                  </div>
                        </div>

                  </div>

                  <%
                               }
                  %>
                  </main>
            </body>

<script src="./js/listagem-threads.js" type="module" def></script>

</html>