package aopsf;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
/**
 * @author bhagvank
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ProxyClassCreator
{
  public static final String PREFIX="AOPSF";
  public static final String PACKAGE="dyna";


  public static boolean createClass(String packagePath,String className)
  {
    try
    {

     Properties config = ConfigProperties.getConfig();

     String createdClassName = PREFIX +className;

     FileOutputStream file = new FileOutputStream(config.getProperty("TEMP_FOLDER")+"\\"+createdClassName+".java");

     PrintWriter writer = new PrintWriter(file);

     writer.println("package dyna; \n"+"import "+ packagePath+"."+className+";\n"+"public class "+createdClassName +" extends "+className+"{ }");

     writer.close();

     file.close();

     Runtime.getRuntime().exec(config.getProperty("JAVA_BIN_DIRECTORY")+"\\javac "+ config.getProperty("TEMP_FOLDER")+"\\"+createdClassName+".java");
     return true;
    }
    catch(Exception exception)
    {
        return false;
    }
  }

}
