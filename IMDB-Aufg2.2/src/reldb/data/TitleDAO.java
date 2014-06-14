
package reldb.data;

import java.util.List;
import reldb.bdo.Title;

/**
 *
 * @author Meike Brülls 
 */
interface TitleDAO {
    
    public List<Title> getTitlesById(Integer titleId); 
    
    public List<Title> getTitlesByKeyword(String keywords, int match);
    
}
