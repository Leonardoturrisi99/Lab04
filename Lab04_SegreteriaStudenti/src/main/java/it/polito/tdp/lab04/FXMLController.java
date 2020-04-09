package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
	private List<Corso>corsi;
	//private ObservableList<String> list=FXCollections.observableArrayList("Gestione dell'innovazione e sviluppo prodotto","Gestione dell'innovazione e sviluppo prodotto ICT","Ingegneria della qualità","Strategia,tecnologia e marketing","Economia e finanza d'impresa","Analisi e gestione dei sistemi produttivi","Analisi finanziaria e creditizia per l'impresa","Diritto commerciale","Economia dei sistemi industriali","Sistemi informativi aziendali","Analisi dei sistemi economici","Economia Aziendale","Gestione dei progetti");
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Corso> chcBox;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnV;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtRisposta;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	String s=txtMatricola.getText();
    	List<Corso>lista=new ArrayList<>();
    	int m;
    	try {
    		m=Integer.parseInt(s);
    	}catch(Exception e) {
    		throw new RuntimeException("Formato matricola errato"+e);
    	}
    	Studente ss= model.getTuttiGliStudenti(s);
    	if(ss==null)
    		txtRisposta.appendText("La matricola non esiste");
    	else {
    	lista.addAll(model.getCorso(s));
    	if(lista.size()==0) {
    		txtRisposta.appendText("La matricola non frequenta nessun corso");
    	}
    	String result="";
    	for(Corso c:lista) {
    		if(result.equals("")) {
    			result+=c.toString1();
    		}else {
    			result+="\n"+c.toString1();
    		}
    	}
    	txtRisposta.appendText(result);
    	}
    	
    	

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	Corso s =  chcBox.getValue();
    	if(s==null)
    		txtRisposta.appendText("Devi scegliere un corso");
    	else {
    	List<Studente>lista=new LinkedList<Studente>();
    	lista.addAll(model.getStudentiIscrittiAlCorso(s.getNome()));
    	if(lista.size()==0)
    		txtRisposta.appendText("Questo corso fa schifo e non ha studenti");
    	StringBuilder result=new StringBuilder();
    	for(Studente stud:lista) {
    		result.append(String.format("%-10s", stud.getMatricola()));
    		result.append(String.format("%-20s", stud.getCognome()));
    		result.append(String.format("%-20s", stud.getNome()));
    		result.append(String.format("%-10s", stud.getCds()));
    		result.append("\n");
    	}
    	txtRisposta.appendText(result.toString());
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	String matricola =txtMatricola.getText();
    	Corso corso =  chcBox.getValue();
    	if(model.inscriviStudenteACorso(matricola, corso.getCodins())==true) {
    		txtRisposta.appendText("Studente già iscritto");
    	}else {
    		txtRisposta.appendText("Studente  iscritto");
    	}
    	
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtRisposta.clear();
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    }

    @FXML
    void doV(ActionEvent event) {
    	String ss =txtMatricola.getText();
    	int m;
    	try {
    		m=Integer.parseInt(ss);
    	}catch(Exception e) {
    		throw new RuntimeException("Formato matricola errato"+e);
    	}
    	Studente s= model.getTuttiGliStudenti(ss);
    	if(s!=null) {
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	}else {
    		txtRisposta.appendText("Non esiste uno studente con questa matricola");
    	}
    
    }
    private void setComboItems() {
    	corsi=model.getCorsi();
    	
    	chcBox.getItems().addAll(corsi);
    }

    @FXML
    void initialize() {
        assert chcBox != null : "fx:id=\"chcBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnV != null : "fx:id=\"btnV\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisposta != null : "fx:id=\"txtRisposta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        
        /*for(int i=0;i<model.getCorsi().size();i++) {
        	list.add(model.getCorsi().get(i).getNome());
        }*/
      // chcBox.setItems(list);

    }
    public void setModel(Model model) {
  		this.model = model;
  		setComboItems();
  	}
}
