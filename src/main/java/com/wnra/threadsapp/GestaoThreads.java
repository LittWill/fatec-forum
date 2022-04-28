package com.wnra.threadsapp;

import java.io.IOException;

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
		
		Thread thread = ThreadDAO.obterThread("792b638e-88db-4819-9ca7-cdf65c8db588");
		System.out.println("Antes: " + thread.getDislikes());
		
		ThreadDAO.atribuirDislike(thread.getId());
		thread = ThreadDAO.obterThread("792b638e-88db-4819-9ca7-cdf65c8db588");
		System.out.println("Depois: " + thread.getDislikes());
	}

}
