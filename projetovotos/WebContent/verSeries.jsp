<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="inc/header.jsp"></jsp:include>

<main>
	<div class="card" style="width: 25rem; left:40em">
	<img src="imagens/image1.jpg" class="card-img-top" alt="...">
		<div class="card-body text-center" >
			<h5 class="card-title">
				Serie:
				<c:out value="${objSerie.titulo}" />
			</h5>
			<ul style="list-style:   none;">
				<h5><li>id: <b><c:out value="${objSerie.id}" /></b>
				</li></h5>
				<h5><li>Votos: <b><c:out
							value="${objSerie.votos}" /></b>
				</li></h5>
			</ul>
		</div>
	</div>
</main>
</div>


	<button onclick="window.history.back();">Voltar</button>

<jsp:include page="inc/footer.jsp"></jsp:include>

</body>
</html>