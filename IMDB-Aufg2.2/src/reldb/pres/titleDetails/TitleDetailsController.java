
package reldb.pres.titleDetails;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import reldb.pres.ImdbSearch;

/**
 *
 * @author Meike
 */
public class TitleDetailsController implements Initializable {

    private ImdbSearch application;
    @FXML
    private Label labelFilmTitle;
    @FXML
    private Label labelFilmYear;
    @FXML
    private Label labelFilmAge;
    @FXML
    private Label labelGenreType;
    @FXML
    private Label labelFilmType;
    @FXML
    private Label labelTagLine;
    @FXML
    private TextField textFieldPlot;
    @FXML
    private ListView listViewRuntimes;
    @FXML
    private ListView listViewReleaseDate;
    @FXML
    private Label labelRating;
    @FXML
    private ListView listViewBudget;
    @FXML
    private ListView listViewBooks;
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setApp(ImdbSearch application) {
        this.application = application;
    }
    
    @FXML
    private void buttonShowFullPlots(ActionEvent event){
    }
    
    @FXML
    private void buttonOpenPersonDetails(ActionEvent event){
        
    }
    @FXML
    private void buttonOpenTitleDetails(ActionEvent event){
        
    }

}
