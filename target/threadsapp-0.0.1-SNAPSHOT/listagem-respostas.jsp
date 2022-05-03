<%@ page import="java.util.List" %>
    <%@ page import="com.wnra.threadsapp.model.Thread" %>
        <%@ page import="com.wnra.threadsapp.model.Resposta" %>
            <%@ page contentType="text/html;charset=UTF-8" language="java" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8" />
                    <title>Respostas</title>
                    <link rel="stylesheet"
                        href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
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
                        <link rel="stylesheet" href="./styles/listagem-respostas.css">

                </head>

                <body>

                    <% Thread thread=(Thread) request.getAttribute("thread"); %>

                        <div class="respostas">

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
                                                            <%= resposta.getDataPostagem() %>
                                                        </span></li>
                                                </ul>
                                            </div>

                                            <h3 class="card-title"><span class="pergunta">
                                                    <%= resposta.getTexto() %>
                                                </span></h3>
                                        </div>
                                    </div>


                                </div>

                        </div>
                        <% } %>

                </body>


                </html>