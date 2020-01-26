package aopsf;

/**
 * @author bhagvank
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Client
{

  public static void main(String[] args)
  {
   
    Test test = (Test) CreatorService.getCreator().createInstance("aopsf","Test",null);
    
    test.setName("check");
    
    System.out.println(test.getClass());
    
    Test test2 = new Test();
    
    test2.setName("tell");
    
  }
}
