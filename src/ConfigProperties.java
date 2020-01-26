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
public class ConfigProperties extends Properties
{
    private static ConfigProperties properties = new ConfigProperties();

    private static final String CONFIG_FILE = "config.properties";

    private ConfigProperties()
    {
        super();

        try
        {
            properties.load(new FileInputStream(CONFIG_FILE));
        }
        catch (Exception exception)
        {

        }
    }

    public static Properties getConfig()
    {
        return properties;
    }

}
