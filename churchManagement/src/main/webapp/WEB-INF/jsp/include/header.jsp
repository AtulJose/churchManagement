<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>St Thomas Syro-Malabar Catholic Mission</h1>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="col-sm-8" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="contactList">Contact
						List</a></li>
				<li class="nav-item"><a class="nav-link" href="reading">Liturgy</a></li>
				<li class="nav-item"><a class="nav-link" href="events">Events</a></li>
				<li class="nav-item"><a class="nav-link" href="home">Home</a></li>

			</ul>

		</div>
		<div class="col-sm-4">
			<li class="navbar-brand">Logged in as <b>${sessionScope.family.familyName}</b></li>
		</div>
	</nav>