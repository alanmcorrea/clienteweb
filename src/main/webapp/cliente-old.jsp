<!DOCTYPE html>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="clientweb.model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>

	<div>
		<%
			Object msg = request.getAttribute("msg");
			if(msg != null){
				String msgString = (String) msg;
				out.print(msg);
			}
			
			Cliente cliente = (Cliente) request.getAttribute("cliente");
			Object indice = request.getAttribute("indice");
		%>
	</div>

	<form method="post" action="cliente.do">
	
		<input type="hidden" name="i" value="<%=indice%>">
		Nome:
		<input type="text" value="<%=cliente.getNome() %>" name="name"/>
		<button>Salvar</button>
	</form>
	<table border="1">
	
		<tr>
			<th>Nome</th>
			<th>Ação</th>
		</tr>
	<%

		List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
		
	int i = 0;
		for (Cliente c :lista){
	%>		
		<tr>
			<td>
				<%=c.getNome()%> 
			</td>
			<td>
				<a href="javascript:confirmar(<%=i%>)">Excluir</a>
				<a href="cliente.do?i=<%=i%>&acao=editar">Editar</a><br/>
			</td>
			
		</tr>		
	<%
			i++;	 
		}
	%>
	</table>
	<script>
		function confirmar(pi){
			
			if(window.confirm("Tem certeza que deseja excluir?")){
				location.href="cliente.do?i=" + pi + "&acao=excluir";
			}
		}
	</script>
</body>
</html>