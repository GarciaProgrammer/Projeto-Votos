<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="inc/header.jsp"></jsp:include>

<main>
<div class="container">
	<div class="row" id="cad-serie-container" >
		<a class="btn btn-success" href="series?action=cadSerie"> <i
			class="fas fa-plus"></i> Cadastrar Série
		</a>
	</div>
</div>
<div class="row">
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<td>Votar </td>
				<td>Titulo</td>
				<td>Quantidade de votos:</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="serie" items="${listaseries}">
				<tr>
					<td><a onclick="addVoto(${serie.id});" class="btn btn-primary" href="series?action=addVoto&id=${serie.id}"> Votar</a>
					<td><c:out value="${serie.titulo}" /></td>
					<td><c:out value="${serie.votos}" /></td>
					<td><a class="btn btn-sm btn-info" href="series?action=verSerie&id=${serie.id}"> 
						<i class="fas fa-search"></i> </a> | 
						<a class="btn btn-sm btn-primary" href="series?action=editSerie&id=${serie.id}"> 
						<i class="fas fa-edit"></i></a> | 
						<a onclick="delSerie(${serie.id});" class="btn btn-sm btn-danger" 
						href="series?action=delSerie&id=${serie.id}"> <i class="fas fa-trash"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</main>