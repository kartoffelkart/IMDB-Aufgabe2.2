/*
 *  Copyright 2014 Rainer Stoermer
 */
package reldb.pres.extendedSearch;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.layout.HBox;
import reldb.pres.ImdbSearch;

/**
 * FXML Controller class
 *
 * @author Meike Brülls 
 */

public class ExtendedSearchController implements Initializable {
private ImdbSearch application;
    //@FXML
    //private HBox titleLine;
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
