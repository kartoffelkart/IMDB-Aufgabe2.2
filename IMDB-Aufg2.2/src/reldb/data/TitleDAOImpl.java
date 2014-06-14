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
import reldb.bdo.MovieCompany;
import reldb.bdo.Title;

/**
 *
 * @author Meike Brülls 
 */
public class TitleDAOImpl implements TitleDAO{
 
 
    private DbConnectionSingletonFactory dbConFactory;
    private DbConnection dbCon;
    private Connection oracleCon;
    private String oracleSchemaStr;

    /**
     * constructor, initializes Database-Connection
     */
    public TitleDAOImpl() {
        dbConFactory = DbConnectionSingletonFactory.getDbConnectionSingletonFactory();
        dbCon = dbConFactory.getDbConnection("oracle");
        oracleCon = dbCon.getConnection();
        if (!DatabaseSettings.ORACLE_SCHEMA.isEmpty()) {
            oracleSchemaStr = DatabaseSettings.ORACLE_SCHEMA + ".";
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
    public List<Title> getTitlesById(Integer titleId) {
        PreparedStatement prepStmt;
        List<Title> titleList = new ArrayList<>();

        
        /*SELECT t.id, t.title, t.production_year, k.kind
            FROM title t, kind_type k
            WHERE t.kind_id= k.id
        */
        
        
        // Initialize query
        String query = "SELECT t.id, t.title, t.production_year, k.kind "
                + "FROM " + oracleSchemaStr + "title t, " + oracleSchemaStr + "kind_type k"
                + "WHERE t.kind_id= k.id";

        try {
            prepStmt = oracleCon.prepareStatement(query);
            prepStmt.setInt(1, titleId);
            ResultSet titleRs = prepStmt.executeQuery();

            while (titleRs.next()) {
                Title title = new Title();
                
                /*
                // Set content of current company
                company.setName(companyRs.getString("name"));
                company.setNote(companyRs.getString("note"));
                company.setKind(companyRs.getString("kind"));

                companyList.add(company);*/
            }
            prepStmt.close();
            titleRs.close();

            return titleList;
        } catch (SQLException ex) {
            Logger.getLogger(MovieCompanyDAOImpl.class.getName()).log(Level.SEVERE, "Error while trying to load PreparedStatement: " + ex.getMessage());
        }

        return null;
    }

    /**
     * retrieves a list of movie_companies to a given keyword-String
     *
     * @param keywords seperated by blanks
     * @param match    1: match all, 2: match any, 3: match exact
     *
     * @return list of movie_companies
     */
    public List<Title> getTitlesByKeyword(String keywords, int match) {
        PreparedStatement prepStmt;
        List<Title> titleList = new ArrayList<>();

        // Initialize query
        String query = "SELECT t.id, t.title, t.production_year, k.kind" +
                "FROM " + oracleSchemaStr + "title t, " + oracleSchemaStr + "kind_type k" +
                "WHERE t.kind_id = k.id AND ";
                
        String[] keywordArray = keywords.split(" ");

        // Fill the query for the prepared Statement
        switch (match) {
            case 1:
                // match all
                for (int i = 0; i < keywordArray.length; i++) {
                    query += "t.title LIKE ? ";
                    if (i < keywordArray.length - 1) {
                        query += " AND ";
                    }
                }
                break;
            case 2:
                // match any
                for (int i = 0; i < keywordArray.length; i++) {
                    if (i == 0) {
                        query += "(";
                    }
                    query += "t.title LIKE ? ";
                    if (i < keywordArray.length - 1) {
                        query += "OR ";
                    }
                    if (i == keywordArray.length - 1) {
                        query += ")";
                    }
                }
                break;
            case 3:
                // match exact
                query += "t.title LIKE ? ";
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

            ResultSet titleRs = prepStmt.executeQuery();

            while (titleRs.next()) {
                Title title = new Title();
                
                // Set content of current title
                title.setTitle(titleRs.getString("title"));
                title.setProduction_year(titleRs.getString("year"));
                title.setKind(titleRs.getString("kind"));

                titleList.add(title);
            }
            prepStmt.close();
            titleRs.close();

            return titleList;
        } catch (SQLException ex) {
            Logger.getLogger(MovieCompanyDAOImpl.class.getName()).log(Level.SEVERE, "Error while trying to load PreparedStatement: " + ex.getMessage());
        }

        return null;
    }
}

    
    
    
    

