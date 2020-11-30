package br.com.projetovotos.Model;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.projetovotos.DAO.SerieDAO;
import br.com.projetovotos.beans.Serie;

public class SerieModel implements Serializable{
	
	public static final long serialversionUID = 1l;

	public ArrayList<Serie> listaSeries(){
			return SerieDAO.listaSerie();
	}
	
	public Serie getSerieByID(int id) {
		return SerieDAO.getSerieById(id);
	}
	
	public static int cadastraSerie(Serie serieSubmit) {
		return SerieDAO.cadastrarSerie(serieSubmit);
	}

	public static int UpdateSerie (Serie serieSubmit) {
		return SerieDAO.updateSerie(serieSubmit);
	}
	
	public static int delSerie (int id) {
		return SerieDAO.delSerie(id);
	}

	public static int addVoto(int id, int votos) {
		return SerieDAO.addVoto(id, votos);
	}
}
