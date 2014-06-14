package reldb.pres.personDetails;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import reldb.pres.ImdbSearch;

/**
 * FXML Controller class
 *
 * @author Meike Brülls
 */
public class PersonDetailsController implements Initializable {

    private ImdbSearch application;

    @FXML
    private Label labelPersonName;
    @FXML
    private Label labelPersonSize;
    @FXML
    private Label labelBirthNotes;
    @FXML
    private Label labelDeathNotes;
    @FXML
    private ListView listViewRoleTypes;
    @FXML
    private TextField textFieldBiography;
    @FXML
    private ListView listViewFilmography;

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

}
