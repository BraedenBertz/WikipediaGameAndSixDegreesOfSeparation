import java.util.ArrayList;
import java.util.List;

public class Link implements ILink<Object> {
	public Link() {
		super();
	}

	LinkLoader link = new LinkLoader();
        String prelink = "https://en.wikipedia.org/wiki/";
	/**
	 * Retrieve the URL Link of the page
	 */
	@Override
	public String getURL(String name) {
		// return the link of the given page
		if(name != null || !name.equals("")) {
			return prelink+name;
		}
		
		return null;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
