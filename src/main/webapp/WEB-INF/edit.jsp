<%@page import="beans.User"%>

<%@ include file="template/header.jsp" %>

<div class="form-box">
	<h2>Modifier un utilisateur</h2>
	<form method="post" action="modifier">
	<input type="hidden" name="id" value="${ user.id }">
   		<div class="input-box">
			<input type="text" name="lastname" value="${user.lastname}" placeholder="Entrez son nom">
     		<label>Nom</label>
   		</div>
   		<div class="input-box">
			<input type="text" name="firstname" value="${user.firstname}" placeholder="Entrez son prenom">
     		<label>Prenom</label>
   		</div>
   		<div class="input-box">
			<input type="text" name="login" value="${user.login}" placeholder="Entrez son login">
     		<label>Login</label>
   		</div>
   		<div class="input-box">
			<input type="text" name="password" value="${user.password}" placeholder="Entrez son mot de passe">
     		<label>Mot de passe</label>
   		</div>
   		<input type="submit" class="btn new" value="Enregistrer">
   	</form>
</div>

<%@ include file="template/footer.jsp" %>