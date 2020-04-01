package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
	//private ObservableList<String>list=FXCollections.observableArrayList(model.get)
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> chcBox;

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

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doV(ActionEvent event) {
    	String matricola =txtMatricola.getText();
    	int m;
    	try {
    		m=Integer.parseInt(matricola);
    	}catch(Exception e) {
    		throw new RuntimeException("Formato matricola errato"+e);
    	}
    	Studente s=model.getTuttiGliStudenti(txtMatricola.getText());
    	if(s!=null) {
    		txtNome.setText(s.getNome());
    		txtCognome.setText(s.getCognome());
    	}else
    		txtRisposta.appendText("Questa matricola non corrisponde a nessun utente");
    	/*String nome=model.getTuttiGliStudenti(s).getNome();
    	String cognome=model.getTuttiGliStudenti(s).getCognome();
    	txtNome.appendText(nome);
    	txtCognome.appendText(cognome);*/
    
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
      //  chcBox.setItems(list);

    }
    public void setModel(Model model) {
  		this.model = model;
  	}
}
