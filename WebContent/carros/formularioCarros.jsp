<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Prodabel - Cadastro de Carros JSP</title>

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
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${carro != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${carro == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${carro != null}">
            			Atualizar Carro
            		</c:if>
						<c:if test="${carro == null}">
            			Adicionar Novo Carro
            		</c:if>
					</h2>
				</caption>

				<c:if test="${carro != null}">
					<input type="hidden" name="id" value="<c:out value='${carro.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Modelo</label> <input type="text"
						value="<c:out value='${carro.modelo}' />" class="form-control"
						name="modelo" required="required" minlength="3">
				</fieldset>

				<fieldset class="form-group">
					<label>Marca</label> <input type="text"
						value="<c:out value='${carro.marca}' />" class="form-control"
						name="marca" minlength="3">
				</fieldset>

				<fieldset class="form-group">
					<label>Placa</label> <input type="text"
						value="<c:out value='${carro.placa}' />" class="form-control"
						name="placa" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Data de Fabricação</label> <input type="date"
						value="<c:out value='${carro.fabricacao}' />" class="form-control"
						name="fabricacao" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
