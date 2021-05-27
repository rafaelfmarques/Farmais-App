package controller;

import java.io.IOException;

import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.DAO;
import model.Remedio;
import model.Func;

@WebServlet(urlPatterns = { "/main", "/cadastrar", "/autenticar", "/login", "/insert", "/list", "/editar", "/deletar" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	Remedio remedio = new Remedio();
	Func func = new Func();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		
		//usuario recebe a sessao
		
		String usuario = (String) request.getSession().getAttribute("usuario");
		
		//condicao que barra o acesso pela url, caso nao possua sessao
		if (action.equals("/main")) {
			if (usuario != null) {
				remedios(request, response);
				response.sendRedirect("main");
			}
			else {
				response.sendRedirect("login.jsp");
			}
		} else 
			if (action.equals("/insert")) {
				novoRemedio(request, response);
				response.sendRedirect("main");
		} else 
			if (action.equals("/list")) {
				listarRemedio(request, response);
		} else 
			if (action.equals("/editar")) {
				editarRemedio(request, response);
		} else 
			if (action.equals("/deletar")) {
				excluiRemedio(request, response);
		}else
			if(action.equals("/cadastrar")) {
				cadastraFunc(request, response);
				response.sendRedirect("login.jsp");
			}else
				if(action.equals("/autenticar")) {
					autenticacao(request, response);
				}else
					if(action.equals("/login")){
						 request.getSession().invalidate();
						 response.sendRedirect("login.jsp");
					}
	}

	public Controller() {
		super();
	}

	//gera a tabela com os remedios e despacha para o /main
	protected void remedios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Remedio> lista = dao.readRemedios();

		request.setAttribute("remedios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}
	
	protected void novoRemedio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// pegar os dados do formulario
		remedio.setNome_tec(request.getParameter("nome_tec"));
		remedio.setNome_fab(request.getParameter("nome_fab"));
		remedio.setNome_com(request.getParameter("nome_com"));
		remedio.setTipo_tarja(request.getParameter("tarja"));
		
		//Chama o insert da classe dao
		dao.insertRemedio(remedio);

	}
	//pega os remedios cadastrados
	protected void listarRemedio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idrem = request.getParameter("idrem");
		remedio.setIdrem(idrem);
		
		dao.selecionarRemedio(remedio);

		request.setAttribute("nome_tec", remedio.getNome_tec());
		request.setAttribute("nome_fab", remedio.getNome_fab());
		request.setAttribute("nome_com", remedio.getNome_com());
		request.setAttribute("tarja", remedio.getTipo_tarja());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	//edita o remedio
	protected void editarRemedio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		remedio.setNome_tec(request.getParameter("nome_tec"));
		remedio.setNome_fab(request.getParameter("nome_fab"));
		remedio.setNome_com(request.getParameter("nome_com"));
		remedio.setTipo_tarja(request.getParameter("tarja"));

		dao.alterarRemedio(remedio);
		
		response.sendRedirect("main");
	}
	//exclui o remedio
	protected void excluiRemedio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idrem = request.getParameter("idrem");
		remedio.setIdrem(idrem);
		dao.removerRemedio(remedio);

		response.sendRedirect("main");

	}
	//cadastra funcionario
	protected void cadastraFunc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		func.setNome(request.getParameter("nome"));
		func.setFone(request.getParameter("fone"));
		func.setEmail(request.getParameter("email"));
		func.setPassw(request.getParameter("passw"));
		
		dao.cadastraFunc(func);
	}
	//recebe a autenticacao e manda a DAO
	protected void autenticacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		func.setEmail(request.getParameter("login"));
		func.setPassw(request.getParameter("senha"));
		String usuario = request.getParameter("login");
		
		//validacao se usuario existe
		
		boolean validar = (dao.autenticar(func));
		
		if (validar == true) {
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("main");
			
		} else {
			response.sendRedirect("login.jsp");
			
		}
	}
}
