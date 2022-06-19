import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class WebScraper {

  String wikiStartLink = "https://en.wikipedia.org/wiki/";
  public WebScraper() {

  }

  Set<String> getEdgesFromNode(String urlAsString) throws IOException {
    String html = getUrlContentsAsString(urlAsString);
    if(html == null) throw new IOException("Could not get html");
    Document doc = Jsoup.parse(html);
    String title = doc.title();
    Elements links = doc.select("a[href]"); // a with href
    //if the link does not contain "/wiki/" then it is not a wikipedia link and we should not include it
    //also, each link should be unique
    return filterLinks(links);
  }

  private Set<String> filterLinks(Elements links) {
    Set<String> hrefs = new HashSet<>();
    for(Element link : links) {
      //link should not be a picture
      if(link.attr("href").contains("/wiki/")
          && !link.attr("href").contains("/wiki/File")
          && !link.attr("href").contains("/wiki/Category")
          && !link.attr("href").contains("/wiki/Template")
          && !link.attr("href").contains("//")
          && !link.attr("href").contains("Wikipedia:")
          && !link.attr("href").contains("/wiki/Help:")
          && !link.attr("href").contains("/wiki/Portal:")
          && !link.attr("href").contains("/wiki/Special:")
          && !link.attr("href").contains("Talk:")
          && !link.attr("href").contains("Main_Page")) {
        hrefs.add(link.attr("href"));
      }

    }
    return hrefs;
  }

  public String getUrlContentsAsString(String urlAsString) {
    try {
      URL url = new URL(urlAsString);
      return IOUtils.toString(url);
    } catch(Exception e) {
      return null;
    }
  }
}
