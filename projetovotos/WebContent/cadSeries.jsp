<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="inc/header.jsp"></jsp:include>

<main>
	<fieldset>
		<legend> Cadastro </legend>
		<div>
			<form action="series" method="post">
				<ul style="list-style: none;">
					<li><label>Titulo:</label> <input class="form-control col-5"
						type="text" name="titulo" placeholder="Informe um titulo...">
						<span id="tituloValidate"></span></li>
					<input class="btn btn-success" type="submit"
						value="Cadastrar">
					</li>
				</ul>
			</form>
		</div>
	</fieldset>
</main>

<jsp:include page="inc/footer.jsp"></jsp:include>

</body>
</html>