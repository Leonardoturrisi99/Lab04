package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		//System.out.println(model.getTuttiGliStudenti("146101"));
		//System.out.println(model.getCorso("146101"));
		System.out.println(model.inscriviStudenteACorso("146101","Sistemi informativi industriali"));
	}

}
