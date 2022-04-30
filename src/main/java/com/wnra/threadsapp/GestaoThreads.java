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

@WebServlet(urlPatterns = "/threads")
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
		
		switch (path) {
			case "/threads" :
				List<Thread> threads = ThreadDAO.listarThreads();
				request.setAttribute("threads", threads);
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				break;
				
			default: System.err.println("Caminho n�o esperado!");
		}
	}

}
