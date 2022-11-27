<%@ include file="template/header.jsp" %>
	<div class="form-box">
		<h2>Connexion</h2>
			<p> <c:out value="${ message }"/></p>
		<form method="post" action="connexion">
    		<div class="input-box">
				<input type="text" name="login" placeholder="Entrez son login">
      			<label>Login</label>
    		</div>
    		<div class="input-box">
				<input type="text" name="password" placeholder="Entrez son mot de passe">
      			<label>Mot de passe</label>
    		</div>
    		<input type="submit" class="btn new" value="Enregistrer">
    	</form>
	</div>

<%@ include file="template/footer.jsp" %>