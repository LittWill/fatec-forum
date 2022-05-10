package com.wnra.threadsapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wnra.threadsapp.dao.CategoriaDAO;
import com.wnra.threadsapp.dao.RespostaDAO;
import com.wnra.threadsapp.dao.ThreadDAO;
import com.wnra.threadsapp.model.Categoria;
import com.wnra.threadsapp.model.Resposta;
import com.wnra.threadsapp.model.Thread;

@WebServlet(urlPatterns = { "/threads", "/respostas", "/identificacao" })
public class GestaoThreads extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);

		String acao = request.getParameter("acao");
		

		if (path.equals("/identificacao")) {
			request.getRequestDispatcher("/identificacao.jsp").forward(request, response);
		}

		else if (path.equals("/threads")) {

			switch (acao) {

			case "criar": {
				List<Categoria> categorias = CategoriaDAO.listarCategorias();
				request.setAttribute("categorias", categorias);
				request.getRequestDispatcher("/criar-thread.jsp").forward(request, response);
				break;
			}
			
			case "salvar": {
				String autorNome = request.getParameter("autorNome");
				Categoria categoria = CategoriaDAO.obterCategoria(request.getParameter("categoria"));
				String questao = request.getParameter("questao");
				Thread thread = new Thread(autorNome, categoria, questao);
				ThreadDAO.salvarThread(thread);
				
				listarThreads(request, response);
				break;
				
			}

			case "listar":
					listarThreads(request, response);
				break;

			case "like": {
				String id = request.getParameter("id");
				if (null == id) {
					throw new RuntimeException("Thread não encontrada!");
				}
				ThreadDAO.atribuirLike(id);
				break;

			}
			case "dislike": {
				String id = request.getParameter("id");
				if (null == id) {
					throw new RuntimeException("Thread não encontrada!");
				}

				ThreadDAO.atribuirDislike(id);
				break;
			}

			default:
				System.err.println("Ação não esperada!");
			}
		}

		else if (path.equals("/respostas")) {

			switch (acao) {
				
			case "criar": {
					String threadId = request.getParameter("threadId");
					Thread thread = ThreadDAO.obterThread(threadId);
					if (null == thread) {
						throw new RuntimeException("Thread não encontrada!");
					}
					request.setAttribute("thread", thread);
					request.getRequestDispatcher("/criar-resposta.jsp").forward(request, response);
					break;
			}

			case "salvar": {
				String autorNome = request.getParameter("autorNome");
				String texto = request.getParameter("texto");
				String threadId = request.getParameter("threadId");
				
				Thread thread = ThreadDAO.obterThread(threadId);
				Resposta resposta = new Resposta(texto, autorNome, thread);
				System.out.println(resposta.getTexto());
				RespostaDAO.salvarResposta(resposta);
				listarRespostas(request, response);
				break;
			}

			case "listar": {
				System.out.println("certo");
				listarRespostas(request, response);
				break;

			}
			
			case "like": {
				String respostaId = request.getParameter("respostaId");
				Resposta resposta = RespostaDAO.obterResposta(respostaId);
				if (null == resposta) {
					throw new RuntimeException("Resposta não encontrada!");
				}
				RespostaDAO.atribuirLike(respostaId);
				break;
			}
			
			case "dislike": {
				String respostaId = request.getParameter("respostaId");
				Resposta resposta = RespostaDAO.obterResposta(respostaId);
				if (null == resposta) {
					throw new RuntimeException("Resposta não encontrada!");
				}
				RespostaDAO.atribuirDislike(respostaId);
				break;
			}
			}
		}

	}

	private void listarThreads(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Thread> threads = ThreadDAO.listarThreads();
		request.setAttribute("threads", threads);
		request.getRequestDispatcher("/listagem-threads.jsp").forward(request, response);
	}

	private void listarRespostas(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String threadId = request.getParameter("threadId");
		if (null == threadId) {
			throw new RuntimeException("Thread não encontrada!");
		}

		Thread threadObtida = ThreadDAO.obterThread(threadId);
		request.setAttribute("thread", threadObtida);
		request.getRequestDispatcher("/listagem-respostas.jsp").forward(request, response);
	}

}
