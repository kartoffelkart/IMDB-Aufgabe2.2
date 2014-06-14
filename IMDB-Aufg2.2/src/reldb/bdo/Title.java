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
public class Title {

    private IntegerProperty titleId = new SimpleIntegerProperty();
    private StringProperty title = new SimpleStringProperty();
    private IntegerProperty kindId = new SimpleIntegerProperty();
    private StringProperty kind = new SimpleStringProperty();
    private StringProperty production_year = new SimpleStringProperty();
    
    /*
    public Title(int titleId, String title, int kindId, String kind, String produktion_year){
        this.titleId = new SimpleIntegerProperty();
        this.title = new SimpleStringProperty();
        this.kindId = new SimpleIntegerProperty();
        this.kind = new SimpleStringProperty();
        this.production_year = new SimpleStringProperty();
    }*/



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

    public Integer getKindId() {
        return kindId.get();
    }

    public IntegerProperty getKindIdProperty() {
        return kindId;
    }

    public void setKindId(Integer nameId) {
        this.kindId.set(nameId);
    }

    public String getKind() {
        return kind.get();
    }

    public StringProperty getKindProperty() {
        return kind;
    }

    public void setKind(String name) {
        this.kind.set(name);
    }

    public String getProduction_year() {
        return production_year.get();
    }

    public StringProperty getProduction_yearProperty() {
        return production_year;
    }

    public void setProduction_year(String name) {
        this.production_year.set(name);
    }
}
