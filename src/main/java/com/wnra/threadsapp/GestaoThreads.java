package com.wnra.threadsapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wnra.threadsapp.dao.ThreadDAO;
import com.wnra.threadsapp.model.Thread;

@WebServlet(urlPatterns = {"/threads"})
public class GestaoThreads extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		String id = request.getParameter("id");
		String acao = request.getParameter("acao");

		switch (acao) {

			case "listar" :
				List<Thread> threads = ThreadDAO.listarThreads();
				request.setAttribute("threads", threads);
				request.getRequestDispatcher("/listagem-threads.jsp")
						.forward(request, response);
				break;

			case "like" :
				if (null == id) {
					throw new RuntimeException("Thread não encontrada!");
				}

				ThreadDAO.atribuirLike(id);
				break;
			case "dislike" :
				if (null == id) {
					throw new RuntimeException("Thread não encontrada!");
				}

				ThreadDAO.atribuirDislike(id);
				break;

			case "respostas" :
				if (null == id) {
					throw new RuntimeException("Thread não encontrada!");
				}

				Thread threadObtida = ThreadDAO.obterThread(id);
				request.setAttribute("thread", threadObtida);
				request.getRequestDispatcher("/listagem-respostas.jsp")
						.forward(request, response);
				break;

			case "identificar" :
				request.getRequestDispatcher("/identificacao.jsp")
						.forward(request, response);
				break;
			default :
				System.err.println("Ação não esperada!");
		}
	}

}
