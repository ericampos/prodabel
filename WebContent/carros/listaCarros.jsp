<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Prodabel - Cadastro de Carros</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://github.com/ericampos" class="navbar-brand">Prodabel
					- Cadastro de Carros JSP</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Lista de Carros</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Carros</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Cadastrar
					novo carro</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Modelo</th>
						<th>Marca</th>
						<th>Placa</th>
						<th>Data de Fabricação</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listCarro" items="${listCarro}">

						<tr>
							<td><c:out value="${listCarro.modelo}" /></td>
							<td><c:out value="${listCarro.marca}" /></td>
							<td><c:out value="${listCarro.placa}" /></td>
							<td><c:out value="${listCarro.fabricacao}" /></td>

							<td><a href="edit?id=<c:out value='${listCarro.id}' />">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${listCarro.id}' />">Excluir</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
