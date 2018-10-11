package setup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PropertyUtils{

    Properties properties = new Properties();
    public static Map<String, String> appProperties = new HashMap<String, String>();
    public PropertyUtils () {
        loadPropertyFile();
    }

    //This method is for loading properties from Properties file

    private void loadPropertyFile(){
        try {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("AppConfig.properties");
            //Loading the input stream
            properties.load(is);
            Enumeration enumeration = properties.propertyNames();
            for(;enumeration.hasMoreElements();) {
                String key = enumeration.nextElement().toString();
                appProperties.put(key,properties.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Return Property Value
    public String getPropertyValue(String key)
    {
        return appProperties.get(key);
    }
}