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
import reldb.bdo.Figure;

/**
 *
 * @author Meike Brülls
 */

public class FigureDAOImpl implements FigureDAO {

    private DbConnectionSingletonFactory dbConFactory;
    private DbConnection dbCon;
    private Connection oracleCon;
    private String oracleSchemaStr;

    /**
     * constructor, initializes Database-Connection
     */
    public FigureDAOImpl() {
        dbConFactory = DbConnectionSingletonFactory.getDbConnectionSingletonFactory();
        dbCon = dbConFactory.getDbConnection("oracle");
        oracleCon = dbCon.getConnection();
        if (!DatabaseSettings.ORACLE_SCHEMA.isEmpty()) {
            oracleSchemaStr = DatabaseSettings.ORACLE_SCHEMA + "IMDB.";
        }
        try {
            oracleCon.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(FigureDAOImpl.class.getName()).log(Level.SEVERE, "Error setting autocommit: " + ex);
        }
    }

    /**
     * retrieves a list of movie_companies to a given title id.
     *
     * @param titleId
     *
     * @return list of movie_companies
     */
    
    public ArrayList<Figure> getFiguresByTitleId(Integer titleId) {
        PreparedStatement prepStmt;
        ArrayList<Figure> characterList = new ArrayList<>();

        // Initialize query
        String query = "";

        try {
            prepStmt = oracleCon.prepareStatement(query);
            prepStmt.setInt(1, titleId);
            ResultSet figureRs = prepStmt.executeQuery();

            while (figureRs.next()) {
                Figure figure = new Figure();

                // Set content of current company
                figure.setName(figureRs.getString("name"));
                figure.setPerson(figureRs.getString("person"));
                figure.setTitle(figureRs.getString("title"));
                figure.setYear(figureRs.getString("year"));

                characterList.add(figure);
            }
            prepStmt.close();
            figureRs.close();

            return characterList;
        } catch (SQLException ex) {
            Logger.getLogger(FigureDAOImpl.class.getName()).log(Level.SEVERE, "Error while trying to load PreparedStatement: " + ex.getMessage());
        }

        return null;
    }

    /**
     * retrieves a list of movie_companies to a given keyword-String
     *
     * @param keywords seperated by blanks
     * @param match 1: match all, 2: match any, 3: match exact
     *
     * @return list of movie_companies
     */
    @Override
    public ArrayList<Figure> getFiguresByKeyword(String keywords, int match) {
        PreparedStatement prepStmt;
        ArrayList<Figure> characterList = new ArrayList<>();

        // Initialize query
        String query = "SELECT c.name AS character_name, n.name, t.title, t.production_year " 
                + "FROM " + oracleSchemaStr + " char_name c " + oracleSchemaStr + " cast_info ci "
                + oracleSchemaStr + " name n " + oracleSchemaStr + " title t "
                + "WHERE c.id = ci.person_role_id "
                + "AND ci.person_id = n.id " 
                + "AND ci.movie_id = t.id AND ";

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
                        query += ")";
                    }
                }
                break;
            case 3:
                // match exact
                query += "c.name LIKE ? ";
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

            ResultSet figureRs = prepStmt.executeQuery();

            while (figureRs.next()) {
                Figure figure = new Figure();

                // Set content of current company
                figure.setName(figureRs.getString("name"));
                figure.setPerson(figureRs.getString("person"));
                figure.setTitle(figureRs.getString("title"));
                figure.setYear(figureRs.getString("year"));

                characterList.add(figure);
            }
            prepStmt.close();
            figureRs.close();

            return characterList;
        } catch (SQLException ex) {
            Logger.getLogger(FigureDAOImpl.class.getName()).log(Level.SEVERE, "Error while trying to load PreparedStatement: " + ex.getMessage());
        }

        return null;
    }

    

}
