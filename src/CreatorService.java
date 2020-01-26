package aopsf;

import java.util.Properties;
import java.io.FileInputStream;
/**
 * @author bhagvank
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class CreatorService
{
    
    private static CreatorService creator = new CreatorService();

    private static Properties configProps = new Properties();
    
    private static final String CONFIG_PROPERTIES = "config.properties";
    

    
    private CreatorService() 
    {
       try
       {
        loadConfiguration();    
       }
       catch(Exception exception)
       {
        
       }
    }

    private void loadConfiguration() throws Exception
    {
       FileInputStream file = new FileInputStream(CONFIG_PROPERTIES);
       configProps.load(file);                    
       
        
    }
        
    public static CreatorService getCreator()
    {
        return creator;   
    }
    
    public Object createInstance(String packagePath,String className,Object[] args)
    {

        boolean creationFlag = ProxyClassCreator.createClass(packagePath,className);
        
        System.out.println("Creation of Class :"+ creationFlag);
        
        Object obj;
        try
        {
          obj = Class.forName(ProxyClassCreator.PACKAGE+"."+ProxyClassCreator.PREFIX+className).newInstance();
        }
        catch(ClassNotFoundException cnfException)
        {
           cnfException.printStackTrace();
           System.out.println(cnfException.getMessage());
           return null;    
        }
        catch(InstantiationException inException)
        {
           return null;   
        }
        catch(IllegalAccessException iaException)
        {
           return null;   
        }
        
        return obj;
        
    }
        
}
