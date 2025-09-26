package newspaperoot.common;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Configuration {
    private Properties p;
    private Configuration(){
        Path p1 = Paths.get("src/main/resources/properties/mysql-properties.xml");
        p= new Properties();
        InputStream propertiesStream;
        try {
            propertiesStream = Files.newInputStream(p1);
            p.loadFromXML(propertiesStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String clave) {
        return p.getProperty(clave);
    }
}
