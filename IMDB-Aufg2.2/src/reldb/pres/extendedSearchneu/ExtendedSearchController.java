/*
 *  Copyright 2014 Rainer Stoermer
 */
package reldb.pres.extendedSearchneu;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import reldb.pres.ImdbSearch;

/**
 * FXML Controller class
 *
 * @author Meike Brülls <s6mebrue@uni-bonn.de>
 */
public class ExtendedSearchController implements Initializable {
private ImdbSearch application;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     
    /**
     * Setter for the application
     *
     * @param application
     */
    public void setApp(ImdbSearch application) {
        this.application = application;
    }
    
    @FXML
    private void buttonSearch(ActionEvent event) {
        System.out.println("Ich rufe die Funktion auf");
        application.openSearchResults();
        
    }
}
