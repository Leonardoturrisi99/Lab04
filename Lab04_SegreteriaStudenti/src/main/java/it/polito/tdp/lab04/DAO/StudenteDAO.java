package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public List<Studente> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente ";

			List<Studente> studenti = new ArrayList<>();
		

			try {
				Connection conn = DBConnect.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet rs = st.executeQuery();

				while (rs.next()) {

					String matricola = rs.getString("matricola");
					String cognome = rs.getString("cognome");
					String nome = rs.getString("nome");
					String cds = rs.getString("CDS");

					Studente s =new Studente(matricola,cognome,nome,cds);
					studenti.add(s);
				}

				conn.close();
				
				return studenti;
				

			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db", e);
			}
		}

}
