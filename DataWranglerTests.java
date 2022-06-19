import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.io.IOUtils;
import org.jsoup.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class DataWranglerTests {
	ILinkLoader linkloader = new LinkLoader();
	ILink link = new Link();
	@Test
	public void test1() {
		boolean linkloader1 = linkloader.ValidLinks("/wiki/Summer");
		//System.out.println(linkloader1);
		assertTrue(linkloader1 == true);
	}
	
	@Test
	public void test2() {
		boolean linkloader2 = linkloader.ValidLinks("/wiki/ejvn;ekrjv");
		assertTrue(linkloader2 == false);
	}
	@Test
	public void test3()throws IOException {
		LinkLoader linkloader3 = new LinkLoader();
		String title = linkloader3.getTitle("https://en.wikipedia.org/wiki/Facebook");
		assertTrue(title.equals("Facebook - Wikipedia"));
	}
	@Test
	public void test4() {
		boolean linkloader4 = linkloader.ValidLinks("/wiki/Winter");
		String link4 = ((ILink) link).getURL("Winter");
		assertTrue(linkloader4 == true);
		assertEquals(link4,"https://en.wikipedia.org/wiki/Winter");
	}
	@Test
	public void test5() throws IOException {
		String name = "AEX_cfiXML";
		String link5 = ((ILink) link).getURL("AEX_cfiXML");
		assertTrue(link5.equals("https://en.wikipedia.org/wiki/AEX_cfiXML"));
	}

	@Test
	public void test6() {
		boolean linkloader1 = linkloader.ValidLinks("/wiki/Summer");
		//System.out.println(linkloader1);
		assertTrue(linkloader1 == true);
	}

	@Test
	public void test7() throws IOException {
		LinkLoader linkloader7 = new LinkLoader();
		String title = linkloader7.getTitle("https://es.wikipedia.org/wiki/Matrix");
		assertTrue(title.equals("Matrix - Wikipedia, la enciclopedia libre"));
	}

	@Test
	public void test8() {
		boolean linkloader1 = linkloader.ValidLinks("/wiki/Elon_Musk");
                assertTrue(linkloader1 == true);	
	}

	@Test
	public void test9() throws IOException{
		LinkLoader linkloader9 = new LinkLoader();
		String title = linkloader9.getTitle("https://en.wikipedia.org/wiki/Alpha");
		assertTrue(title.equals("Alpha - Wikipedia"));
	}
}
