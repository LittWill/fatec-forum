package com.wnra.threadsapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wnra.threadsapp.dao.CategoriaDAO;
import com.wnra.threadsapp.dao.ThreadDAO;
import com.wnra.threadsapp.model.Thread;

@WebServlet(urlPatterns = {"/threads", "/threads/like", "/threads/dislike"})
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
		switch (path) {
			case "/threads" :
				List<Thread> threads = ThreadDAO.listarThreads();
				request.setAttribute("threads", threads);
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				break;
			case "/threads/like" : 
				if (null == id) {
					throw new RuntimeException ("Thread não encontrada!");
				}
				
				ThreadDAO.atribuirLike(id);
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				break;
			case "/threads/dislike" : 
				if (null == id) {
					throw new RuntimeException ("Thread não encontrada!");
				}
				
				ThreadDAO.atribuirDislike(id);
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				break;
				
			default: System.err.println("Caminho não esperado!");
		}
	}

}
