package clientweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/cliente.do")
public class ClientServlet extends HttpServlet{

	public ClientServlet() {
		System.out.println("Construindo o servlet...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Inicializando o servlet...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamando o service...");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou pelo método GET.");
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método GET.");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou pelo método POST.");
		
		resp.setCharacterEncoding("UTF-8");
		//resp.getWriter().print("Chamou pelo método POST.");
		
		String name = req.getParameter("name");
		
		resp.getWriter().print("Chamou pelo método POST com o nome: " + name);
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
