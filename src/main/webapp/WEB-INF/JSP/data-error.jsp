<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/css/bootstrap-theme.css">

	<title>Page 404</title>

</head>

<body>

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1 style="color: red;">Oops</h1>
				<h1 style="color: blue;">${message} </h1>
			</div>
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/welcome" role="button">BACK</a>
		</div>
	</div>

</body>

</html>