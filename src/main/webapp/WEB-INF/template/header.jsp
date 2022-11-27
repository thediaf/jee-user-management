<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>List des utilisateurs</title>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" type="text/css" href='<c:url value="/style/main.css"/>'>
</head>
<body>
	<h1 class="titre">Gestion des utilisateurs 33</h1>
	<div class="navbar">
		<div class="nav">
			<a class="item" href='<c:url value="/"/>'>Accueil</a>
			<a class="item" href='<c:url value="/list"/>'>Liste</a>
			<a class="item" href='<c:url value="/ajouter"/>'>Ajouter</a>
		<a class="signin" href="<c:url value="/connexion"/>">Connexion</a>
		</div>
	</div>