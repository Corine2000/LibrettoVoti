package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label txtVoto;

    @FXML
    private Label txtNome;

    @FXML
    private Label txtData;

    @FXML
    private Button btnInvio;

    @FXML
    private TextField txtNomeCorso;

    @FXML
    private TextField TxtPunteggioOttenuto;

 //   @FXML
   // private TextField txtDataEsame;
    
    @FXML
    private DatePicker txtDatePicker; // questo date picker mi restituira un elemento nel formato corretto di localDate

    @FXML
    private TextArea txtRisultati;

    @FXML
    void doInsert(ActionEvent event) {
    	// recupero e controllo validita dati
    	
    	String NomeCorso = txtNomeCorso.getText();
    	String votoOttenuto = TxtPunteggioOttenuto.getText();
	//	String data = txtDataEsame.getText();
		
		if(NomeCorso.isEmpty() || votoOttenuto.isEmpty() || txtDatePicker.getValue()==null) {
			txtRisultati.setText("Attenzione i campi NomeCorso, Voto e DataEsame sono obbligatori");
		//  txtNomeCorso.clear();
		//	TxtPunteggioOttenuto.clear();
		//	txtDataEsame.clear();
			return ;
		}
		
		int Punteggio =0;
		try {
			Punteggio = Integer.parseInt(votoOttenuto);
		}catch(NumberFormatException e) {
			txtRisultati.setText("il voto deve essere un numero");
			return ;
		}
		
		if(Punteggio <18 || Punteggio>30) {
			txtRisultati.setText("il voto deve essere compreso tra 18 e 30");
			return;
		}
		
		LocalDate dataEsame = txtDatePicker.getValue();
		
		
	/*	try {
			dataEsame = LocalDate.parse(data);
		}catch(NumberFormatException e) {
			txtRisultati.setText("la data deve essere nel formato AAAA-MM-GG");
			return ;
		}*/
		
		//Eseguo l'azione, se arrivo fin cui ,significa che i dati di input sono corretti
		Voto voto = new Voto(NomeCorso, Punteggio, dataEsame);
		this.model.add(voto);
		
		//aggiorno l'interfaccia
		txtRisultati.setText(model.toString());
		
		
		
		txtNomeCorso.clear();
		TxtPunteggioOttenuto.clear();
		//txtDataEsame.clear();
		txtDatePicker.setValue(null);
		
    }
    
    @FXML
    void cercaVoto(ActionEvent event) {
    	Voto votoTrovato = model.ricercaVoto(txtNomeCorso.getText());
		txtRisultati.setText("il voto dell'esame che stai cercando è: "+ votoTrovato);
    }
      public void setModel(Libretto model) {
    	  this.model = model;
      }
    @FXML
    void initialize() {
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInvio != null : "fx:id=\"btnInvio\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNomeCorso != null : "fx:id=\"txtNomeCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TxtPunteggioOttenuto != null : "fx:id=\"TxtPunteggioOttenuto\" was not injected: check your FXML file 'Scene.fxml'.";
      //  assert txtDataEsame != null : "fx:id=\"txtDataEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDatePicker != null : "fx:id=\"txtDatePicker\" was not injected: check your FXML file 'Scene.fxml'.";

        assert txtRisultati != null : "fx:id=\"txtRsultati\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
