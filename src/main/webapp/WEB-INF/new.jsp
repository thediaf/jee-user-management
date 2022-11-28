<%@ include file="template/header.jsp" %>
	<div class="form-box">
		<h2>Ajouter un utilisaeur</h2>
		<form method="post" action="ajouter">
			<p class="${ status ? 'success' : 'error'}">${ statusMessage }</p>
    		<div class="input-box">
				<input type="text" name="lastname" value="${ user.lastname }" placeholder="Saisissez le nom">
      			<label>Nom</label>
				<span class="error">${ errors.lastname}</span>
    		</div>
    		<div class="input-box">
				<input type="text" name="firstname" value="${ user.firstname }" placeholder="Saisissez le prenom">
      			<label>Prenom</label>
				<span class="error">${ errors.firstname}</span>
    		</div>
    		<div class="input-box">
				<input type="text" name="login" value="${ user.login }" placeholder="Saisissez le login">
      			<label>Login</label>
				<span class="error">${ errors.login}</span>
    		</div>
    		<div class="input-box">
				<input type="password" name="password" placeholder="Saisissez le mot de passe">
      			<label>Mot de passe</label>
				<span class="error">${ errors.password}</span>
    		</div>
    		<div class="input-box">
				<input type="password" name="confirm_password" placeholder="Ressaisissez le mot de passe">
      			<label>Confirmation du mot de passe</label>
				<span class="error">${ errors.confirm_password}</span>
    		</div>
    		<input type="submit" class="btn new" value="Enregistrer">
    	</form>
	</div>

<%@ include file="template/footer.jsp" %>