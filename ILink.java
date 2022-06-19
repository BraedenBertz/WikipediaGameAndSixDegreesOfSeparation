import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public interface ILink<T> extends Comparable<T> {

	String getURL(String link); // retrieve URL of the given Wiki page

	
}
