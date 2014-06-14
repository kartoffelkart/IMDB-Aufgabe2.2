package reldb.pres.searchResults;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import reldb.bdo.*;
import reldb.data.MovieCompanyDAOImpl;
import reldb.data.TitleDAOImpl;
import reldb.pres.ImdbSearch;
import reldb.pres.searchKeyword.SearchKeywordController;

/**
 * FXML Controller class
 *
 * @author Meike Brülls
 */
public class SearchResultsController implements Initializable {

    private ImdbSearch application;

    @FXML
    private TableView<Title> tableTitles;
    @FXML
    private TableColumn<Title, String> columnTTitle;
    @FXML
    private TableColumn<Title, String> columnTYear;
    @FXML
    private TableColumn<Title, String> columnTKind;
    @FXML
    private TableView<Person> tablePersons;
    @FXML
    private TableColumn<Person, String> columnPName;
    @FXML
    private TableColumn<Person, String> columnPGender;
    @FXML
    private TableColumn<Person, String> columnPBirth;
    @FXML
    private TableView<Figure> tableCharacters;
    @FXML
    private TableColumn<Figure, String> columnChRole;
    @FXML
    private TableColumn<Figure, String> columnChActor;
    @FXML
    private TableColumn<Figure, String> columnTitle;
    @FXML
    private TableColumn<Figure, String> columnYear;
    @FXML
    private TableView<MovieCompany> tableCompanies;
    @FXML
    private TableColumn<MovieCompany, String> columnCoName;
    @FXML
    private TableColumn<MovieCompany, String> columnCoType;
    
    
    FXMLLoader loader = new FXMLLoader();

    SearchKeywordController SKC = (SearchKeywordController) loader.getController();
    
    int match = SKC.getSelectedToggle();
    String keyword = SKC.getKeyword();
    
    
    MovieCompanyDAOImpl MCDI = new MovieCompanyDAOImpl();
    TitleDAOImpl TDI = new TitleDAOImpl();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //company_einfuegen();
        
    }

    /**
     * Setter for the application
     *
     * @param application
     */
    public void setApp(ImdbSearch application) {
        this.application = application;
    }
    
    /*
    ArrayList<Title> titleDAOList = new ArrayList<Title>();
    final ObservableList<Title> titleList = FXCollections.observableArrayList(TDI.getTitlesByKeyword(keyword, match));
    */
    
    //ArrayList<MovieCompany> companyDAOList = new ArrayList<MovieCompany>();
    //final ObservableList<MovieCompany> companyList = FXCollections.observableArrayList(MCDI.getMovieCompaniesByKeyword(keyword, match));
    
    
    @FXML
    private void closeWindow(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void title_einfuegen() {
        columnTTitle.setCellValueFactory(new PropertyValueFactory<Title, String>("title"));
        columnTYear.setCellValueFactory(new PropertyValueFactory<Title, String>("production_year"));
        columnTKind.setCellValueFactory(new PropertyValueFactory<Title, String>("kind"));
    }
    
    private void person_einfuegen() {
        columnPName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnPGender.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));
        columnPBirth.setCellValueFactory(new PropertyValueFactory<Person, String>("birthDate"));
    }

    private void figure_einfuegen() {
        columnChRole.setCellValueFactory(new PropertyValueFactory<Figure, String>("name"));
        columnChActor.setCellValueFactory(new PropertyValueFactory<Figure, String>("person"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<Figure, String>("title"));
        columnYear.setCellValueFactory(new PropertyValueFactory<Figure, String>("year"));
    }

    private void company_einfuegen() {
        columnCoName.setCellValueFactory(new PropertyValueFactory<MovieCompany, String>("name"));
        columnCoType.setCellValueFactory(new PropertyValueFactory<MovieCompany, String>("kind"));
        
       // tableCompanies.setItems(companyList);
    }

    @FXML
    private void showTitleDetails(ActionEvent event) {
        application.openTitleDetails();
    }

    @FXML
    private void showPersonDetails(ActionEvent event) {
        application.openPersonDetails();
    }

}
