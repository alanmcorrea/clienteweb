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
		${requestScope.msg}
	</div>

	<form method="post" action="cliente.do">
	
		<input type="hidden" name="i" value="${requestScope.indice}">
		Nome:
		<input type="text" value="${requestScope.cliente.nome}" name="name"/>
		<button>Salvar</button>
	</form>
	<table border="1">
	
		<tr>
			<th>Nome</th>
			<th>Ação</th>
		</tr>
		
		<c:set var="i" value="0"/>
		<c:forEach items="${requestScope.lista}" var="cliente">
		
			<tr>
				<td>
					${cliente.nome}
				</td>
				<td>
					<a href="javascript:confirmar(${i})">Excluir</a>
					<a href="cliente.do?i=${i}&acao=editar">Editar</a><br/>
				</td>
			
			</tr>
				
			<c:set var="i" value="${i+1}"/>
			
		</c:forEach>	

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