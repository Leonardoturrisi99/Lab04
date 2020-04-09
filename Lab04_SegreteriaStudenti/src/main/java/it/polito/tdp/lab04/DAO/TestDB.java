package it.polito.tdp.lab04.DAO;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		//System.out.println(cdao.getTuttiICorsi());
		System.out.println(cdao.inscriviStudenteACorso("146101","Sistemi informativi aziendali"));
		//StudenteDAO sdao = new StudenteDAO();
		//System.out.println(sdao.getTuttiGliStudenti());
		//System.out.println(cdao.getCorso("146101"));
		
	}

}
