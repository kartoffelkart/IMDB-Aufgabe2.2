/*
 *  Copyright 2014 Rainer Stoermer
 */
package reldb.pres.mainmenu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import reldb.pres.ImdbSearch;

/**
 * FXML Controller class
 *
 * @author Rainer Stoermer
 */
public class MainMenuController implements Initializable {

    private ImdbSearch application;
    @FXML
    private AnchorPane mainAnchorPane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }

    
    /**
     * Setter for the application
     *
     * @param application
     */
    public void setApp(ImdbSearch application) {
        this.application = application;
    }
    
    /**
     * opens openSearchKeyword in the application
     * @param event An ActionEvent that happens by clicking "Search for Keywords"
     */
    @FXML
    private void openSearchKeyword(ActionEvent event) {
        application.openSearchKeyword();
    }
    
    @FXML
    private void openExtendedSearch(ActionEvent event) {
        application.openExtendedSearch();
    }
    
}
