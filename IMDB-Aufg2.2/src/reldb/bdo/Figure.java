/*
 *  Copyright 2014 Rainer Stoermer
 */
package reldb.bdo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Rainer Stoermer
 */
public class Figure {

    private IntegerProperty nameId = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty personId = new SimpleIntegerProperty();
    private StringProperty person = new SimpleStringProperty();
    private IntegerProperty titleId = new SimpleIntegerProperty();
    private StringProperty title = new SimpleStringProperty();
    private StringProperty year = new SimpleStringProperty();

    public Integer getNameId() {
        return nameId.get();
    }

    public IntegerProperty getNameIdProperty() {
        return nameId;
    }

    public void setNameId(Integer nameId) {
        this.nameId.set(nameId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Integer getPersonId() {
        return personId.get();
    }

    public IntegerProperty getPersonIdProperty() {
        return personId;
    }

    public void setPersonId(Integer nameId) {
        this.personId.set(nameId);
    }

    public String getPerson() {
        return person.get();
    }

    public StringProperty getPersonProperty() {
        return person;
    }

    public void setPerson(String name) {
        this.person.set(name);
    }

    public Integer getTitleId() {
        return titleId.get();
    }

    public IntegerProperty getTitleIdProperty() {
        return titleId;
    }

    public void setTitleId(Integer nameId) {
        this.titleId.set(nameId);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty getTitleProperty() {
        return title;
    }

    public void setTitle(String name) {
        this.title.set(name);
    }
    
    public String getYear() {
        return year.get();
    }

    public StringProperty getYearProperty() {
        return year;
    }

    public void setYear(String name) {
        this.year.set(name);
    }

}
