import org.apache.commons.io.IOUtils;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;


public class LinkLoader implements ILinkLoader {
	public LinkLoader() {
		super();
	}
	
	public LinkLoader(String link) {
		this();
	}

        String prelink = "https://en.wikipedia.org";
	Document dox;
	/**
	 * Checks if the link is valid or not return false if it throws exception;
	 * otherwise, return true.
	 * 
	 * @throws IOException
	 */
	@Override
	public boolean ValidLinks(String urlAsString) {
	    try {
	      String url = prelink + urlAsString;
	      Jsoup.parse(getUrlContentsAsString(url));

	      return true;
	    } catch(Exception e) {
	      return false;
	    }
	  }


	/**
	 * Get all the related links in the given Wiki page
	 * 
	 * @throws IOException
	 */
	@Override
	public Set<String> getEdges(String node) throws IOException {

		String link = prelink + node;
		if (node == null) {
			throw new NullPointerException("Cannot get the URL Link.");
		}
		dox = Jsoup.parse(getUrlContentsAsString(link));
		Elements links = dox.select("a[href]");
		return filterLinks(links);

	}

	/**
	 * Remove all the unrelative links in the given Wiki page
	 */
	@Override
	public Set<String> filterLinks(Elements links) {
		Set<String> sets = new HashSet<>();
		for (Element link : links) {
			if (link.attr("href").contains("/wiki/") && !link.attr("href").contains("/wiki/File")
					&& !link.attr("href").contains("/wiki/Category") && !link.attr("href").contains("/wiki/Template")
					&& !link.attr("href").contains("//") && !link.attr("href").contains("Wikipedia:")
					&& !link.attr("href").contains("/wiki/Help:") && !link.attr("href").contains("/wiki/Portal:")
					&& !link.attr("href").contains("/wiki/Special:") && !link.attr("href").contains("Talk:")
					&& !link.attr("href").contains("Main_Page")) {
				sets.add(link.attr("href"));
			}
		}
		return sets;
	}
	

	/**
	 * Retrieve the title page
	 */
	public String getTitle(String link) throws IOException {
		URL url = new URL(link);
		String Link = IOUtils.toString(url);
		dox = Jsoup.parse(Link);
		return dox.title();
	}

	public String getUrlContentsAsString(String urlAsString) {
		try {
			URL url = new URL(urlAsString);
			return IOUtils.toString(url);
		} catch(Exception e) {
			System.out.println(urlAsString);
			return null;
		}
	}

}
