<%@ include file="template/header.jsp" %>
	<div class="form-box">
		<h2>Ajouter un utilisateur</h2>
		<form method="post" action="ajouter">
    		<div class="input-box">
				<input type="text" name="lastname" placeholder="Entrez son nom">
      			<label>Nom</label>
      			<p>Vous devez renseigner ce champ</p>
    		</div>
    		<div class="input-box">
				<input type="text" name="firstname" placeholder="Entrez son prenom">
      			<label>Prenom</label>
    		</div>
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