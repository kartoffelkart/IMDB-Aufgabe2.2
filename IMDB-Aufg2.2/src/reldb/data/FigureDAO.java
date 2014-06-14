/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reldb.data;

import java.util.List;
import reldb.bdo.Figure;

/**
 *
 * @author Meike Brülls <s6mebrue@uni-bonn.de>
 */
interface FigureDAO {
    
    public List<Figure> getFiguresByTitleId(Integer titleId); 
    
    public List<Figure> getFiguresByKeyword(String keywords, int match);
    
}
