<!DOCTYPE html>
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
		%>
	</div>

	<form method="post" action="cliente.do">
		Nome:
		<input type="text" name="name"/>
		<button>Salvar</button>
	</form>
	
	<%

		List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
		
	int i = 0;
		for (Cliente c :lista){
			out.print(c.getNome()+ " <a href='javascript:confirmar("+i+");'>Excluir</a><br/>");
			i++;	 
	}
	%>
	<script>
		function confirmar(pi){
			
			if(window.confirm("Tem certeza que deseja excluir?")){
				location.href="cliente.do?i=" + pi;
			}
		}
	</script>
</body>
</html>