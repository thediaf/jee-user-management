<%@page import="beans.User"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="template/header.jsp" %>
	<div class="header">
		<h2 class="titre">Liste des utilisateurs</h2>
	</div>
		<c:choose>
			<c:when test="${ empty users }">
				<p>La liste est vide ! </p>			
			</c:when>
			<c:otherwise>
			
			<table class="styled-table">
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Login</th>
					<th>Mot de passe</th>
					<th colspan="2">Actions</th>
				</tr>
					<c:forEach items="${ users }" var="user">
					<tr>
						<td> <c:out value="${ user.id }"/> </td>
						<td> <c:out value="${ user.lastname }"/> </td>
						<td> <c:out value="${ user.firstname }"/> </td>
						<td> <c:out value="${ user.login }"/> </td>
						<td> <c:out value="${ user.password }"/> </td>
						<td><a class="btn edit" href="modifier?id=<c:out value="${ user.id }"/>">Modifier</a></td>
						<td><a class="btn delete" onclick="return confirmation()" href="supprimer?id=<c:out value="${ user.id }"/>">Supprimer</a></td>
					</tr>
					</c:forEach>
			</table>
			</c:otherwise>
		</c:choose>
		
<%@ include file="template/footer.jsp" %>