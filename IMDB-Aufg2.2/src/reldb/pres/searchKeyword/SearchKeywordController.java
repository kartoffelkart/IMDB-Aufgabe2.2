/*
 *  Copyright 2014 Rainer Stoermer
 */
package reldb.pres.searchKeyword;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import reldb.pres.ImdbSearch;

/**
 * FXML Controller class
 *
 * @author Meike Brülls
 */
public class SearchKeywordController implements Initializable {

    private ImdbSearch application;

    @FXML
    private TextField textFieldSearch;
    @FXML
    private RadioButton buttonMatchAll;
    @FXML
    private RadioButton buttonMatchExact;
    @FXML
    private RadioButton buttonMatchAny;
    @FXML
    private CheckBox checkPersons;
    @FXML
    private CheckBox checkTitles;
    @FXML
    private CheckBox checkCompanies;
    @FXML
    private CheckBox checkCharacters;
    @FXML
    private CheckBox checkDeSelectAll;
    @FXML
    private Button buttonToSearch;
    @FXML
    private ToggleGroup toggleGroup1;

    private CheckBox[] filters;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initialize Toggle Group
        buttonMatchAll.setUserData("1");
        buttonMatchAny.setUserData("2");
        buttonMatchExact.setUserData("3");

        //Array of the CheckBoxes
        filters = new CheckBox[4];
        filters[0] = checkPersons;
        filters[1] = checkTitles;
        filters[2] = checkCompanies;
        filters[3] = checkCharacters;

        checkDeSelectAll.selectedProperty().addListener(this::checkAllChanged);

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
     * This method sets all CheckBoxes to true/false
     *
     * @param observable
     * @param oldValue checks if the old value is set true or false
     * @param newValue is the new value of the CheckBoxes (true/false)
     */
    private void checkAllChanged(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        for (CheckBox filter : filters) {
            filter.selectedProperty().set(newValue);
        }
    }

    /**
     * gets the keyword(s) from the textfield and puts them in a String
     *
     * @return keywords a String with all keywords
     */
    public String getKeyword() {

        String keywords = textFieldSearch.getText();
        System.out.println(keywords);

        return keywords;

    }

    /**
     * gets the number (that was set with setUserData) of a RadioButton and
     * returns it in a String
     *
     * @return selectedToggle a String with the number of a Toggle (1: Match
     * all, 2: Match any, 3: Match exact)
     */
    public Integer getSelectedToggle() {
        int match = 0;

        if (toggleGroup1.getSelectedToggle() != null) {

            if (toggleGroup1.getSelectedToggle().getUserData().toString().matches("1")) {
                System.out.print("Match All - ");
                match = 1;
            }
            if (toggleGroup1.getSelectedToggle().getUserData().toString().matches("2")) {
                System.out.print("Match Any - ");
                match = 2;
            }
            if (toggleGroup1.getSelectedToggle().getUserData().toString().matches("3")) {
                System.out.print("Match Exact - ");
                match = 3;
            }

        }

        System.out.println(match);

        return match;
    }

    private void getSelectedCheckBoxes() {

        String selectedCheckBoxes;

        if (checkPersons.isSelected()) {
            System.out.println("Persons is selected");
        }
        if (checkTitles.isSelected()) {
            System.out.println("Titles is selected");
        }
        if (checkCharacters.isSelected()) {
            System.out.println("Persons is selected");
        }
        if (checkCompanies.isSelected()) {
            System.out.println("Persons is selected");
        }
    }

    @FXML
    private void buttonSearch(ActionEvent event) {
        
        getKeyword();
        getSelectedToggle();
        getSelectedCheckBoxes();
        
        application.openSearchResults();

    }
}
