// --== CS400 File Header Information ==--
// Name: Maicheng Thao
// Email: mthao43@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian
// Notes to Grader: Backend placeholder for DW Link class
public class BDLink implements ILink<Object> {
  BDLinkLoader link;
  
  public BDLink() {
    link = new BDLinkLoader();
  }

  @Override
  public int compareTo(Object o) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String getURL(String link) {
    if(this.link.ValidLinks(link) == true) {
      return link;
  }
    return null;
  }

}
