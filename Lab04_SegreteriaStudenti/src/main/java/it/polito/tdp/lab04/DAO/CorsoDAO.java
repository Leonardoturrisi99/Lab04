package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				Corso c=new Corso(codins,numeroCrediti,nome,periodoDidattico);
				corsi.add(c);

			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	/*
	 * Data una matricola , ottengo i corsi
	 */
	public List<Corso> getCorso(String matricola) {
		final String sql = "SELECT c.codins ,c.crediti,c.nome,c.pd"+" FROM studente AS s,iscrizione i,corso c"+" WHERE c.codins=i.codins AND s.matricola=i.matricola AND s.matricola=?";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				Corso c=new Corso(codins,numeroCrediti,nome,periodoDidattico);
				corsi.add(c);

			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(String corso) {
		final String sql = "SELECT s.matricola ,s.nome,s.cognome,s.CDS"+" FROM studente AS s,iscrizione i,corso c"+" WHERE c.codins=i.codins AND s.matricola=i.matricola AND c.nome=?";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso);
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

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(String matricola,String nome) {
		StudenteDAO sdao=new StudenteDAO();
		List<Corso>corso=new ArrayList<Corso>();
		List<Studente>lista=new ArrayList<Studente>(sdao.getTuttiGliStudenti());
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getMatricola().equals(matricola)) {
				//for(int k=0;k<this.getCorso(lista.get(i).getMatricola()).size();k++) {
					corso.addAll(this.getCorso(lista.get(i).getMatricola()));
			}
		}
		for(int i=0;i<corso.size();i++) {
			if(corso.get(i).getNome().equals(nome))
				return true;
			else
				return false;
					
					
					
					
					/*if(this.getCorso(lista.get(i).getMatricola()).get(k).getNome().equals(nome)) {
						return true;
					}else {
						return false;
					}*/
					
				}
			
		//}
		
		
		return false;
	}
	

}

