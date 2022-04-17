import java.util.List;

/**
 * Instances of classes that implement this interface represent a single
 * streaming show object that can be stored, sorted, and searched for based on
 * these accessors below.
 */
public interface ILink<T> extends Comparable<T> {

	// constructor args (String title, int year, int rating, String providers)
	// where the providers string includes the names of every streaming source

	String getText(); // return the text describing each Wiki page to utilize Dijkstra's Algorithm
						// to find the shortest path

	List<T> getURL(); // retrieve URL of the given Wiki page

	String getLink();// return the links found on the given Wiki page

	int compareTo(T link); // compare the Link objects lexicographically

}