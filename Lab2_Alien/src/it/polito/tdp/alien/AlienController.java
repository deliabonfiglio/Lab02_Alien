/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class AlienController {

	private TreeMap<String, String> parole= new TreeMap<String,String>();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtWord"
    private TextArea txtWord; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }

  
    
    @FXML
    void doTranslate(ActionEvent event) {
    String[] parola = txtWord.getText().split(" ");
    String parolaAliena = parola[0];
   
    		if(parola.length==2){
	        	String traduzione = parola[1];      	
	    		traduci(parolaAliena, traduzione);
	    	}
	    	if(parola.length==1)
	    		cercaTraduzione(parolaAliena);
    }
    
    private void cercaTraduzione(String parolaAliena) {
    	String chiave= parolaAliena.toLowerCase();
    	
    	if(chiave.compareTo("")==0){
	    	txtResult.appendText("Inserire almeno una parola!\n");
			txtWord.clear();
	    }
    	
    	else{
			if(parole.containsKey(chiave)){
				txtResult.appendText(parole.get(chiave).toLowerCase()+"\n");
				txtWord.clear();
			
			if(chiave.contains("?")){
				cercaTraduzioneGiusta(chiave);
	    	}
			}
			else{
				txtResult.appendText("Non trovata traduzione per la parola inserita!\n");
				txtWord.clear();
			}
    	}
	}

    private void traduci(String parolaAliena, String traduzione){
    	String chiave = parolaAliena.toLowerCase();
    	String valore = traduzione.toLowerCase();
    	
    	if( chiave.matches("[a-zA-Z]+") && valore.matches("[a-zA-Z]+")){
    		if(!parole.containsKey(chiave))
    			parole.put(chiave, valore);
    			
    		else
    			parole.put(chiave, valore);
    		
    		//txtResult.appendText(chiave+" "+valore+"\n");
			txtWord.clear();
    	}
    	else if(chiave.contains("?")){
    		cercaTraduzioneGiusta(chiave);
    	}
    		
    	else{
    		txtResult.appendText("Errore nel formato!Accettati solo caratteri alfabetici!\n");
    		txtWord.clear();
    	}
    	
    	
    }


	private String cercaTraduzioneGiusta(String chiave) {
		chiave = chiave.replaceAll("\\?", ".");
		int matchcounter=0;
		
		StringBuilder sb= new StringBuilder();
		for(String stemp: parole.keySet()){
		if(stemp.matches(chiave)){
			matchcounter++;
			
			sb.append(stemp.toString()+ "\n");
			//txtResult.appendText(parole.get(parola)+"\n");
			//txtWord.clear();
		}
		}
		if(matchcounter !=0)
			return sb.toString();
		else 
			return null;
			
	}


	@FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }

    
}
