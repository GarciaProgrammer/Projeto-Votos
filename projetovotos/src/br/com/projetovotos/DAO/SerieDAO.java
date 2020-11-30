package br.com.projetovotos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetovotos.beans.Serie;
import br.com.projetovotos.cnn.ConnectionFactory;

public class SerieDAO {

	public static ArrayList<Serie> listaSerie() {
		Connection cnn = ConnectionFactory.getConnection();
		String query = "select * from serie order by votos desc";
		ArrayList<Serie> arSerie = new ArrayList();

		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			ResultSet rsSerie = pStm.executeQuery();

			while (rsSerie.next()) {
				Serie serie = new Serie(rsSerie.getInt("id"), rsSerie.getString("titulo"), rsSerie.getInt("votos"));
				arSerie.add(serie);
			}
			cnn.close();
			rsSerie.close();
			return arSerie;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Serie getSerieById(int id) {
		Serie serieRetorno = new Serie();
		String query = "SELECT * FROM serie WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setInt(1, id);

			ResultSet rsSerie = pStmt.executeQuery();
			while (rsSerie.next()) {
				serieRetorno.setId(id);
				serieRetorno.setTitulo(rsSerie.getString("titulo"));
				serieRetorno.setVotos(rsSerie.getInt("votos"));
			}
			rsSerie.close();
			cnn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return serieRetorno;
	}

	public static int cadastrarSerie(Serie serieSubmit) {
		String query = "INSERT INTO serie (titulo) VALUES (?)";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, serieSubmit.getTitulo());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

	public static int updateSerie(Serie serieSubmit) {
		String query = "UPDATE serie SET titulo = ? WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, serieSubmit.getTitulo());
			pStmt.setLong(2, serieSubmit.getId());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

	public static int delSerie(int id) {
		String query = "DELETE FROM serie WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setInt(1, id);
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

	public static int addVoto(int id, int votos) {
		String query = "UPDATE serie SET votos = ? WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;
		
		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setInt(1, votos);
			pStmt.setInt(2, id);
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

}
