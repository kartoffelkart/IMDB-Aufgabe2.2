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
public class MovieCompany {

    private IntegerProperty nameId = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty kindId = new SimpleIntegerProperty();
    private StringProperty kind = new SimpleStringProperty();
    private StringProperty note = new SimpleStringProperty();

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

    public String getNote() {
        return note.get();
    }

    public StringProperty getNoteProperty() {
        return note;
    }

    public void setNote(String name) {
        this.note.set(name);
    }
}
