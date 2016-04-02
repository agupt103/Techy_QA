<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Challenges</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href='resources/css/LoginHeader.css' rel="stylesheet"
	type="text/css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/globalalter.css"/>"
	rel="stylesheet" type="text/css">


</head>
<body>

	<!--  Section for Login header -->
	<nav class="navbar navbar-default"
		style="margin-bottom:0px; background-color:#fff;">
	<div class="container-fluid">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">TechyQ&A</a>
		</div>


		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<form id="signin" class="navbar-form navbar-right" role="form">
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input id="email"
						type="email" class="form-control" name="email" value=""
						placeholder="Email Address">
				</div>

				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="password"
						type="password" class="form-control" name="password" value=""
						placeholder="Password">
				</div>

				<button type="submit" class="btn btn-primary">Login</button>
			</form>

		</div>
	</div>
	</nav>

	<!-- Header Image -->
	<header id="heading">
	<div class="container text-center">
		<h1>Techy Q&A</h1>
	</div>
	</header>

	<!-- Navigation Bar -->
	<ul id="myTab" class="nav nav-tabs">
		<li><a href="home"> Q & A </a></li>

		<li class="active"><a href="#" id="myTabDrop1"
			class="dropdown-toggle" data-toggle="dropdown"> Challenges <b
				class="caret"></b>
		</a>

			<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
				<li><a href="challenges" tabindex="-1" data-toggle="tab">Create
						Challenge</a></li>
				<li><a href="openChallenges" tabindex="-1" data-toggle="tab">Open
						Challenges</a></li>
				<li><a href="#review" tabindex="-1" data-toggle="tab">Challenges
						Under Review</a></li>
				<li><a href="#close" tabindex="-1" data-toggle="tab">Closed
						Challenges</a></li>
			</ul></li>
		<li><a href="#seminar" data-toggle="tab">Seminars</a></li>

	</ul>


	<h2 align="center">Create New Challenge</h2>
	<strong><c:if test="${not empty emptyFields}">
			<div class="msg">${emptyFields}</div>
		</c:if></strong>
	<form name='ChallengeForm'
		action="${pageContext.servletContext.contextPath}/createChallenge"
		method='POST' class="form-horizontal" role="form"
		style="margin-left: 0px; margin-right: 0px;">

		<div class="form-group"
			style="margin-bottom: 0px; margin-left: 0px; margin-right: 0px;">
			<label class="col-sm-2 control-label" for="title_id">Title</label>
			<div class="col-sm-9">
				<input class="form-control" type="text" id="title_id" name="title"
					placeholder="Enter Title" />

			</div>
		</div>
		<br>
		<div class="form-group"
			style="margin-bottom: 0px; margin-left: 0px; margin-right: 0px;">

			<label class="col-sm-2 control-label" for="ques">Question</label>
			<div class="col-sm-9">
				<textarea class="form-control" id="ques" name="ques" rows="4"
					placeholder="Enter Question"></textarea>
			</div>
		</div>
		<br>
		<div class="form-group"
			style="margin-bottom: 0px; margin-left: 0px; margin-right: 0px;">
			<label class="col-sm-2 control-label" for="ans">Answer</label>
			<div class="col-sm-9">
				<textarea class="form-control" id="ans" name="ans" rows="8"
					placeholder="Enter Answer"></textarea>
			</div>
		</div>

		<br>
		<div class="form-group"
			style="margin-bottom: 0px; margin-left: 0px; margin-right: 0px;">

			<label class="col-sm-2 control-label" for="points">Points</label>
			<div class="col-sm-9">
				<input class="form-control" type="text" id="points" name="points"
					placeholder="Enter Points" />
			</div>
		</div>
		<br>

		<div class="form-group"
			style="margin-bottom: 0px; margin-left: 0px; margin-right: 0px;">
			<div class="col-sm-offset-2 col-sm-10">
				<input class="btn btn-success" type="submit" value="Submit"
					id="submit1"
					onclick="window.location.href='${pageContext.request.contextPath}/challenges'">
				<input class="btn btn-cancel" type="button" value="cancel"
					id="cancel"
					onclick="window.location.href='${pageContext.request.contextPath}/home'">
			</div>

		</div>
	</form>
</body>
</html>