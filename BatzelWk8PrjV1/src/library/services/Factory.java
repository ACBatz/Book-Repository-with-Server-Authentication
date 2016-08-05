/*
 * Class Name:  Factory
 * Description: This class instantiates and returns service layer services
 */
package library.services;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Andrew
 * @version 2
 * Created  08/01/2015
 * Modified 08/07/2015 -> made factory decoupled from the services it creates
 */
public class Factory {
      
    public Factory() {}
    
    public IService getService(String serviceName) throws Exception {
        Class c = Class.forName(getImplName(serviceName));
        return (IService) c.newInstance();
    }
    
    private String getImplName(String serviceName) throws Exception {
        FileInputStream fis = new FileInputStream("config/properties.txt");
        Properties props = new Properties();
        props.load(fis);
        fis.close();
        return props.getProperty(serviceName);
    }
}