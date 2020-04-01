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
		this.cdao = cdao;
		this.sdao = sdao;
	}
	public Studente getTuttiGliStudenti(String matricola){
		List<Studente>studenti=new ArrayList<>(sdao.getTuttiGliStudenti());
		for(Studente s: studenti)
			if(s.getMatricola().equals(matricola))
				return s;
		return null;
		
		
		
		/*for(int i=0;i<sdao.getTuttiGliStudenti().size();i++) {
			if(sdao.getTuttiGliStudenti().get(i).getMatricola().equals(matricola))
				return sdao.getTuttiGliStudenti().get(i);
		}
		return null;*/
	}
}

