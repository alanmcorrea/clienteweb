package clientweb.servlet;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientweb.model.Cliente;
import clientweb.service.ClientService;

@WebServlet(urlPatterns="/cliente.do")
public class ClientServlet extends HttpServlet{

	ClientService clientService;
	
	public ClientServlet() {
		System.out.println("Construindo o servlet...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Inicializando o servlet...");
		
		clientService = new ClientService();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamando o service...");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou pelo método GET.");
		
		//resp.setCharacterEncoding("UTF-8");
		//resp.getWriter().print("Chamou pelo método GET.");
		
		String i = req.getParameter("i");
		
		if(i != null && i != ""){
			clientService.excluir(Integer.parseInt(i));
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
	
		req.setAttribute("lista", clientService.getTodosClientes());
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou pelo método POST.");
		
		String nome = req.getParameter("name");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		
		clientService.cadastrar(cliente);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		
		req.setAttribute("msg", "Cadastrado com sucesso.");
		req.setAttribute("lista", clientService.getTodosClientes());
		
		dispatcher.forward(req, resp);
		
		//resp.sendRedirect("cliente.do"); redirecionamento onde onde mandamos o navegador pedir para o server pelo método get.
		
		//resp.getWriter().print("Chamou pelo método POST com o nome: " + nome);
		//resp.setCharacterEncoding("UTF-8");
		//resp.getWriter().print("Chamou pelo método POST.");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou pelo método PUT.");
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método PUT.");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou pelo método DELETE.");
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método DELETE.");
	}
	
	@Override
	public void destroy() {
		System.out.println("Service sendo destruído...");
		super.destroy();
	}

}
