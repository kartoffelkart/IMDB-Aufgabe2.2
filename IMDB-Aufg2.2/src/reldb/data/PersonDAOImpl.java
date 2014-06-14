/*
 *  Copyright 2014 Rainer Stoermer
 */
package reldb.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reldb.bdo.DatabaseSettings;

import reldb.bdo.Person;

/**
 *
 * @author Rainer Stoermer
 */
public class PersonDAOImpl implements PersonDAO {

    private DbConnectionSingletonFactory dbConFactory;
    private DbConnection dbCon;
    private Connection oracleCon;
    private String oracleSchemaStr;
    String query1 = "SELECT n.id, n.name, n.gender, i.info "
            + "FROM " + oracleSchemaStr + "name n, " + oracleSchemaStr + "person_info p, " + oracleSchemaStr + "info_type i"
            + "WHERE n.id= p.person_id AND i.id= p.info_type_id AND i.id= 21";

    /**
     * constructor, initializes Database-Connection
     */
    public PersonDAOImpl() {
        dbConFactory = DbConnectionSingletonFactory.getDbConnectionSingletonFactory();
        dbCon = dbConFactory.getDbConnection("oracle");
        oracleCon = dbCon.getConnection();
        if (!DatabaseSettings.ORACLE_SCHEMA.isEmpty()) {
            oracleSchemaStr = DatabaseSettings.ORACLE_SCHEMA + "IMDB.";
        }
        try {
            oracleCon.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(MovieCompanyDAOImpl.class.getName()).log(Level.SEVERE, "Error setting autocommit: " + ex);
        }
    }

    /**
     * retrieves a list of movie_companies to a given title id.
     *
     * @param titleId
     *
     * @return list of movie_companies
     */
    public ArrayList<Person> getPersonByTitleId(Integer titleId) {
        PreparedStatement prepStmt;
        ArrayList<Person> characterList = new ArrayList<>();

        // Initialize query
        String query = "";

        try {
            prepStmt = oracleCon.prepareStatement(query);
            prepStmt.setInt(1, titleId);
            ResultSet personRs = prepStmt.executeQuery();

            while (personRs.next()) {
                Person person = new Person();

                // Set content of current company
                person.setName(personRs.getString("name"));
              //  person.setPerson(personRs.getString("person"));
                // person.setTitle(personRs.getString("title"));
                //  person.setYear(personRs.getString("year"));

                characterList.add(person);
            }
            prepStmt.close();
            personRs.close();

            return characterList;
        } catch (SQLException ex) {
            Logger.getLogger(MovieCompanyDAOImpl.class.getName()).log(Level.SEVERE, "Error while trying to load PreparedStatement: " + ex.getMessage());
        }

        return null;
    }
}
//-------------------------------------------------------------------------------------------
/**
 * retrieves a list of movie_companies to a given keyword-String
 *
 * @param keywords seperated by blanks
 * @param match 1: match all, 2: match any, 3: match exact
 *
 * @return list of movie_companies
 */
/*  @Override
 public ArrayList<Person> getPersonsByKeyword(String keywords, int match) {
 PreparedStatement prepStmt;
 ArrayList<Person> characterList = new ArrayList<>();

 // Initialize query
 String query = "SELECT c.name AS character_name, n.name, t.title, t.production_year " 
 + "FROM " + oracleSchemaStr + " char_name c " + oracleSchemaStr + " cast_info ci "
 + oracleSchemaStr + " name n " + oracleSchemaStr + " title t "
 + "WHERE c.id = ci.person_role_id "
 + "AND ci.person_id = n.id " 
 + "AND ci.movie_id = t.id AND ";
 /* public List<Person> getPersonsByKeyword(String keywords, int match) { //einzelne von name ausgehend

 PreparedStatement prepStmt2;

 Person person = new Person();

 List<Person> personList = new ArrayList<>();

 // Initialize query
 String query = "SELECT name.name,name.gender, rt.role, title.title   "
 + "FROM ((" + oracleSchemaStr + "name Join " + oracleSchemaStr 
 + "cast_info ci ON ci.person_id = name.id) JOIN" + oracleSchemaStr 
 + "title ON title.id = ci.movie_id)JOIN" + oracleSchemaStr 
 + "role_type rt ON ci.role_id = rt.id "
                
 + "WHERE  pi.info_type_id = ? AND";
 >>>>>>> origin/master

 String[] keywordArray = keywords.split(" ");

 // Fill the query for the prepared Statement
 switch (match) {
 case 1:
 // match all
 for (int i = 0; i < keywordArray.length; i++) {
 query += "c.name LIKE ? ";
 if (i < keywordArray.length - 1) {
 query += " AND ";
 }
 else{                        query += "ORDER BY name.id ";}

 }
 break;
 case 2:
 // match any
 for (int i = 0; i < keywordArray.length; i++) {
 if (i == 0) {
 query += "(";
 }
 query += "c.name LIKE ? ";
 if (i < keywordArray.length - 1) {
 query += "OR ";
 }
 if (i == keywordArray.length - 1) {
 query += "ORDER BY name.id )";
 }
 }
 break;
 case 3:
 // match exact
 <<<<<<< HEAD
 query += "c.name LIKE ? ";
 =======
 query += "name.name LIKE ? ORDER BY name.id ";
 >>>>>>> origin/master
 break;
 }

 try {
 prepStmt = oracleCon.prepareStatement(query);

 // Fill the prepared Statement with the keywords
 switch (match) {
 case 1:
 // match all
 case 2:
 // match any
 for (int i = 0; i < keywordArray.length; i++) {
 prepStmt.setString(i + 1, "%" + keywordArray[i] + "%");
 }
 break;
 case 3:
 // match exact
 prepStmt.setString(1, keywords);
 break;
 }

 ResultSet personRs = prepStmt.executeQuery();

 while (personRs.next()) {
 Person person = new Person();

 // Set content of current company
 person.setName(personRs.getString("name"));
 person.setPerson(personRs.getString("person"));
 person.setTitle(personRs.getString("title"));
 person.setYear(personRs.getString("year"));

 <<<<<<< HEAD
 characterList.add(person);
 }
 prepStmt.close();
 personRs.close();
 =======
 }

 // Fill the prepared Statement with the keywords
 personList.add(person);

 prepStmt2.close();
 personRs20.close();

 return personList;
 >>>>>>> origin/master

 return characterList;
 } catch (SQLException ex) {
 Logger.getLogger(MovieCompanyDAOImpl.class.getName()).log(Level.SEVERE, "Error while trying to load PreparedStatement: " + ex.getMessage());
 }

 return null;
 }*/
    //-------------------------------------------------------------------
    /*  public List<Person> getPersonsByKeyword(String keywords, int match) { //einzelne von name ausgehend

        PreparedStatement prepStmt2;

        Person person = new Person();

        List<Person> personList = new ArrayList<>();

        // Initialize query
        String query = "SELECT name.id  "
                + "FROM " + oracleSchemaStr + "name "
                + "WHERE";

        String[] keywordArray = keywords.split(" ");

        // Fill the query for the prepared Statement
        switch (match) {
            case 1:
                // match all
                for (int i = 0; i < keywordArray.length; i++) {
                    query += "name.name LIKE ? ";
                    if (i < keywordArray.length - 1) {
                        query += " AND ";
                    }
                                        else{                        query += "ORDER BY name.id ";}

                }
                break;
            case 2:
                // match any
                for (int i = 0; i < keywordArray.length; i++) {
                    if (i == 0) {
                        query += "(";
                    }
                    query += "name.name LIKE ? ";
                    if (i < keywordArray.length - 1) {
                        query += "OR ";
                    }
                    if (i == keywordArray.length - 1) {
                        query += "ORDER BY name.id )";
                    }
                }
                break;
            case 3:
                // match exact
                query += "name.name LIKE ? ORDER BY name.id ";
                break;
        }

        try {

            prepStmt2 = oracleCon.prepareStatement(query);

            switch (match) {
                case 1:
                // match all
                case 2:
                    // match any
                    for (int i = 0; i < (keywordArray.length ); i++) {
                        prepStmt2.setString(i + 1, "%" + keywordArray[i] + "%");
                    }
                    break;
                case 3:
                    // match exact
                    prepStmt2.setString(1, keywords);
                    break;
            }
         
            ResultSet personRs2 = prepStmt2.executeQuery();
           
            while (personRs2.next()) {
   person = this.getPersonByNameId(personRs2.getInt(1)) ;

                
            // Fill the prepared Statement with the keywords
            personList.add(person);
            }
            prepStmt2.close();
            personRs2.close();

            return personList;

        } catch (SQLException ex) {
            Logger.getLogger(PersonDAOImpl.class.getName()).log(Level.SEVERE, "Error while trying to load PreparedStatement: " + ex.getMessage());
        }

        return null;
    }
}
*/
