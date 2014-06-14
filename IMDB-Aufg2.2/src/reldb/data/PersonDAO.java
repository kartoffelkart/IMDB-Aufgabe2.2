package reldb.data;

import java.util.ArrayList;
import reldb.bdo.Person;

/**
 *
 * @author Rainer Stoermer
 */
public interface PersonDAO {

    /**
     * 
     * @param personId
     * @return 
     */
   public ArrayList<Person> getPersonByTitleId(Integer titleId) ;


    /**
     * retrieves a list of persons to a given keyword-String
     * 
     * @param keywords seperated by blanks
     * @param match 1: match all, 2: match any, 3: match exact
     * 
     * @return list of persons 
     */
   
 //   public List<Person> getPersonsByKeyword(String keywords, int match);
}
