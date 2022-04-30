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
            </head>

            <style>
                  .threads {
                        width: 250px;
                        height: 250px;
                        margin: 0 auto;
                  }
                  .thread {
                        margin-top: 20px;
                        width: 400px;
                  }

                  li {
                        display: inline;
                        list-style: none;
                        font-size: 18px;
                  }
                  .autor {
                        float: left;
                  }

                  .pergunta {
                        font-size: 24px;
                  }
                  .data {
                        float: right;
                  }
                  .botoes-interacao {
                        margin-top: 25px;
                  }
            </style>

            <body>

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
                                      <a href="#" class="btn btn-success">Like (<%= thread.getLikes() %>)</a>
                                      <a href="#" class="btn btn-danger">Dislike (<%= thread.getDislikes() %>)</a>
                                      <a href="#" class="btn btn-primary">Exibir</a>
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

            </html>