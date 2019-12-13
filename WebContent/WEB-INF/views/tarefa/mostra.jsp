<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet" />
</head>
<body>
	<h3>Alterar tarefa - ${ tarefa.id }</h3>
	<form action="alteraTarefa" method="post">
	
		<input type="hidden" name="id" value="${ tarefa.id }">
		
		Descrição: <br/>
		<textarea name="descricao" rows="5" cols="100">${ tarefa.descricao }</textarea><br/>

		Finalizado?
		<input type="checkbox" name="finalizado" value="true"
			${ tarefa.finalizado ? 'checked' : '' } /><br/>
		
		Data de finalização:
		<input 
			type="text" 
			name="dataFinalizacao"
			value="<fmt:formatDate 
				value="${ tarefa.dataFinalizacao.time }"
				pattern="dd/MM/yyyy" />" 
		/><br/>
		<br/>
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>