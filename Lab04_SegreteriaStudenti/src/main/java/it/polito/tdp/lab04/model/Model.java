package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	private CorsoDAO cdao;
	private StudenteDAO sdao;
	private Map<String,Studente>mappa=new TreeMap<String,Studente>();
	
	public Model() {
		sdao=new StudenteDAO();
		cdao= new CorsoDAO();
	}
	
	public List<Studente>getStudenti(){
		return sdao.getTuttiGliStudenti();
	}
	
	
	public Studente getTuttiGliStudenti(String matricola){
		/*List<Studente>studenti=new ArrayList<>(this.getStudenti());
		for(Studente s: studenti) {
			if(s.getMatricola().equals(matricola)) {
				return s;
				}
			}
		return null;*/
		for(int i=0;i<sdao.getTuttiGliStudenti().size();i++) {
			if(sdao.getTuttiGliStudenti().get(i).getMatricola().equals(matricola))
				return sdao.getTuttiGliStudenti().get(i);
		}
		return null;
	}
	
	
	public List<Corso>getCorsi(){
		return cdao.getTuttiICorsi();
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(String corso) {
		return cdao.getStudentiIscrittiAlCorso(corso);
	}
		
	public List<Corso> getCorso(String matricola) {
		return cdao.getCorso(matricola);
	}
	
	public boolean inscriviStudenteACorso(String matricola, String nome) {
		return cdao.inscriviStudenteACorso(matricola, nome);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public ArrayList<String> getNomiCorsi(){
		List<Corso>corsi=new ArrayList<Corso>(cdao.getTuttiICorsi());
		ArrayList<String>nomi=new ArrayList<String>();
		for(Corso c:corsi)
			nomi.add(c.getNome());
		return nomi;
		
		
		
		
	/*	ArrayList<String>lista=new ArrayList<String>();
		for(int i=0;i<this.getCorsi().size();i++) {
			lista.add(this.getCorsi().get(i).getNome());
		}
		return lista;*/
	}
	
	
	
	
	


