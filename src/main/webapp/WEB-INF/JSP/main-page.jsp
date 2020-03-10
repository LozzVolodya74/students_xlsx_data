<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="uk">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/static/css/bootstrap.css">
<link rel="stylesheet" href="/static/css/bootstrap-theme.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
					
						<style>
  							.center { text-align: center;  }
						</style>
								<div class = "center">
					
						    <a class="btn btn-primary" 
								href="/upload" role="button">Upload Students</a>
								
								<!-- Button for opening window modal 1 -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#myModal">ADD new student</button>
						            STUDENTS IN DATABASE 
						<!-- Button for opening window modal 2 -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#myModal_1">DELETE student</button>
						
						<!-- Button for opening window modal 3 -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#myModal_2">EDIT student</button>
						</div>
					</h3>
				</div>
				<div class="panel-body">

					<!-- Modal window 1 -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="CLOSE">
										<span aria-hidden="true">×</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">INPUT NEW STUDENT</h4>
								</div>
								<div class="modal-body"> <!-- CONTENT MODAL WINDOW -->
					<!-- INPUN NEW STUDENT INTO FORM -->			
		<form action="${pageContext.request.contextPath}/save" method="post">
			<h3 style="color: red;">Please INPUT NEXT DATA</h3>
				<h4 style="color: blue;">
  					<div>
    					<label for="text">INPUT FIRST NAME</label>
    					<input id="text" name="firstName" required minlength="1" maxlength="30">
  					</div>
  					<div>
    					<label for="text">INPUT LAST NAME</label>
    					<input id="text" name="lastName" required minlength="1" maxlength="30">
  					</div>
  					<div>
    					<label for="text">INPUT AGE</label>
    					<input id="text" name="age" required minlength="1" maxlength="3">
  					</div>
  					<div>
    					<label for="text">INPUT BIRTHDAY in format (DD-MM-YYYY)</label>
   						<input id="text" name="birthday" required minlength="6" maxlength="20">
  					</div>
  					<div>
    					<label for="text">INPUT FACULTY</label>
    					<input id="text" name="faculty" required minlength="1" maxlength="30">
  					</div>
  					</h4>
  				<div>
    					<button>Submit</button>
  				</div>
		</form>
								
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">CLOSE</button>
								</div>
							</div>
						</div>
					</div>

							<!-- Modal window 2 -->
					<div class="modal fade" id="myModal_1" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="CLOSE">
										<span aria-hidden="true">×</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">DELETE STUDENT</h4>
								</div>
								<div class="modal-body"> <!-- CONTENT MODAL WINDOW -->
				
				<!-- DELETE FORM -->				
	<form action="${pageContext.request.contextPath}/remove" method="post">
	    <h3 style="color: red;">Please input id student</h3>
	    <h4 style="color: blue;"> INPUT ID <input type="number" name="id"> </h4> <br>
		<input type="submit">
	</form>
								
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">CLOSE</button>
								</div>
							</div>
						</div>
					</div>
					
					<!-- Modal 3 -->
					<div class="modal fade" id="myModal_2" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="CLOSE">
										<span aria-hidden="true">×</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">INPUT NEW STUDENT</h4>
								</div>
								<div class="modal-body"> <!-- CONTENT MODAL WINDOW -->
				<!-- Update FORM -->				
	<form action="${pageContext.request.contextPath}/update" method="post">
	    <h3 style="color: red;">Please input ID student for edit</h3>
	    <h4 style="color: blue;"> INPUT ID <input type="number" name="id"> </h4> <br>
	    <h3 style="color: green;">Please input new data</h3>
		<h4 style="color: blue;"> INPUT FIRST NAME <input type="text" name="firstName"> </h4>
		<h4 style="color: blue;"> INPUT LAST NAME <input type="text" name="lastName"> </h4>
		<h4 style="color: blue;"> INPUT AGE <input type="text" name="age"> </h4>
		<h4 style="color: blue;"> INPUT BIRTHDAY in format (DD-MM-YYYY) <input type="text" name="birthday"> </h4>
		<h4 style="color: blue;"> INPUT FACULTY <input type="text" name="faculty"> </h4>
		<input type="submit">
	</form>
								
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">CLOSE</button>
								</div>
							</div>
						</div>
					</div>


					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Age</th>
									<th>Date of birthday</th>
									<th>Faculty</th>
								</tr>
							</thead>
							<tbody>
							
							<c:forEach var="stud" items="${students }">
								<tr>
									<th scope="row">${stud.id }</th>
									<td>${stud.firstName }</td>
									<td>${stud.lastName }</td>
									<td>${stud.age }</td>
									<td>${stud.birthday }</td>
									<td>${stud.faculty }</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						
					</div>
				</div>
			</div>
		</div>
		
		<!-- FOOTER PANEL -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
						 <!-- INCLUDE JSP with buttons -->
							<jsp:include page="include.jsp" />
						</h3>
					</div>
				</div>
			
	</div>
	<script src="/static/js/jquery.js"></script>
	<script src="/static/js/bootstrap.js"></script>
	<script src="/static/js/app.js"></script>
</body>
</html>
