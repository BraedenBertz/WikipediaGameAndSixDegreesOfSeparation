import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class WebScraper {

  public WebScraper() throws IOException {

    String html = getUrlContentsAsString("https://en.wikipedia.org/wiki/Summer");
    Document doc = Jsoup.parse(html);

    Elements links = doc.select("a[href]"); // a with href

    //using these links as edges, and the wikipage as the vertex
    //use dijkstra's algorithm to find the shortest path
    //form our start to our end

  }

  public String getUrlContentsAsString(String urlAsString)
  {
    try
    {
      URL url = new URL(urlAsString);
      return IOUtils.toString(url);
    }
    catch (Exception e)
    {
      return null;
    }
  }
}
