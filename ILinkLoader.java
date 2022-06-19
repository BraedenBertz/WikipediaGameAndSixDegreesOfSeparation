import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.Elements;
import java.util.HashSet;
import java.util.Set;
import java.io.IOException;

/**
 *
 */
public interface ILinkLoader {

    boolean ValidLinks(String start);
    
    Set<String> getEdges(String node) throws IOException;

	/**
	 * Remove all the unrelative links in the given Wiki page
	 */
    Set<String> filterLinks(org.jsoup.select.Elements links);
}
