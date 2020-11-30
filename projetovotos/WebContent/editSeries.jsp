<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="inc/header.jsp"></jsp:include>

<main>
	<fieldset>
		<legend>Editando o título da Série:<c:out value="${objSerie.titulo }" /></legend>
		<div>
			<form action="series" method="post">
				<ul style="list-style: none;">
					<li>
					<label>Titulo:</label> 
					<input class="form-control col-5"
						type="text" name="titulo" value="${objSerie.titulo }"> 
						<span id="tituloValidate"></span>
						</li>
					<li>
					<input type="hidden" name="id" value="${objSerie.id }">
					<input class="btn btn-success" type="submit" value="Atualizar">
					</li>
				</ul>
			</form>
		</div>
	</fieldset>
</main>


</div>

<jsp:include page="inc/footer.jsp"></jsp:include>

</body>
</html>