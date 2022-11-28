<%@page import="beans.User"%>

<%@ include file="template/header.jsp" %>

<div class="form-box">
	<h2>Modifier un utilisateur</h2>
	<form method="post" action="modifier">
		<p class="${ status ? 'success' : 'error'}">${ statusMessage }</p>
	<input type="hidden" name="id" value="${ user.id }">
   		<div class="input-box">
			<input type="text" name="lastname" value="${user.lastname}" placeholder="Entrez son nom">
     		<label>Nom</label>
			 <span class="error">${ errors.lastname}</span>
   		</div>
   		<div class="input-box">
			<input type="text" name="firstname" value="${user.firstname}" placeholder="Entrez son prenom">
     		<label>Prenom</label>
			 <span class="error">${ errors.firstname}</span>
   		</div>
   		<div class="input-box">
			<input type="text" name="login" value="${user.login}" placeholder="Entrez son login">
     		<label>Login</label>
			 <span class="error">${ errors.login}</span>
   		</div>
   		<div class="input-box">
			<input type="password" name="password" value="${user.password}" placeholder="Entrez son mot de passe">
     		<label>Mot de passe</label>
			 <span class="error">${ errors.password}</span>
   		</div>
		   <div class="input-box">
			   <input type="password" name="confirm_password" value="${user.password}" placeholder="Ressaisissez le mot de passe">
				 <label>Confirmation du mot de passe</label>
			   <span class="error">${ errors.confirm_password}</span>
		   </div>
   		<input type="submit" class="btn new" value="Enregistrer">
   	</form>
</div>

<%@ include file="template/footer.jsp" %>