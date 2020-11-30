package br.com.projetovotos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetovotos.Model.SerieModel;
import br.com.projetovotos.beans.Serie;

@WebServlet("/series")
public class SeriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SerieModel serieModel = new SerieModel();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getParameter("action")) {
		case "listaSeries":
			listaSeriesAction(request, response);
			break;

		case "cadSerie":
			cadSerieAction(request, response);
			break;

		case "verSerie":
			verSerieAction(request, response);
			break;

		case "editSerie":
			editSerieAction(request, response);
			break;

		case "delSerie":
			delserieAction(request, response);
			break;

		case "addVoto":
			addVotoAction(request, response);
			break;
		}
	}

	private void addVotoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Serie serie = serieModel.getSerieByID(id);
		
		int votos = serie.getVotos() + 1;
		
		if (SerieModel.addVoto(id, votos) > 0 ){
			response.getWriter().print("Votado com Sucesso");
		} else {
			response.getWriter().print("ERRO");
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titulo = request.getParameter("titulo");
		Integer id = 0;

		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		int retorno = 0;

		Serie serieSubmit = new Serie();
		serieSubmit.setTitulo(titulo);
		if (id > 0) {
			serieSubmit.setId(id);
			retorno = SerieModel.UpdateSerie(serieSubmit);
		} else {
			retorno = SerieModel.cadastraSerie(serieSubmit);
		}

		PrintWriter out = response.getWriter();
		if (retorno > 0) {
			out.println("<body>");
			out.println("<b>serie " + titulo + " Criado/Alterado com Sucesso!</b>");
			out.println("<a href='series?action=listaSeries'>Voltar</a>");
			out.println("</body>");
		} else {
			out.println("<body>");
			out.println("<b>Ocorreu um erro, não foi possível alterar/Cadastrar o serie!</b>");
			out.println("<a href='series?action=listaSeries'>Voltar</a>");
			out.println("</body>");
		}
	}

	protected void listaSeriesAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// busca dados no banco

		List<Serie> objListaserie = new ArrayList<Serie>();
		objListaserie = serieModel.listaSeries();

		request.setAttribute("listaseries", objListaserie);
		RequestDispatcher rd = request.getRequestDispatcher("listaSeries.jsp");
		rd.forward(request, response);
	}

	protected void cadSerieAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("cadSeries.jsp");
		rd.forward(request, response);

	}

	protected void verSerieAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Serie serie = serieModel.getSerieByID(id);

		request.setAttribute("objSerie", serie);
		RequestDispatcher rd = request.getRequestDispatcher("verSeries.jsp");
		rd.forward(request, response);
	}

	private void delserieAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		if (SerieModel.delSerie(id) > 0) {
			response.getWriter().print("Série excluida com súcesso");
		} else {
			response.getWriter().print("ERRO");
		}
	}

	private void editSerieAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Serie serie = serieModel.getSerieByID(id);

		request.setAttribute("objSerie", serie);
		RequestDispatcher rd = request.getRequestDispatcher("editSeries.jsp");
		rd.forward(request, response);
	}

}