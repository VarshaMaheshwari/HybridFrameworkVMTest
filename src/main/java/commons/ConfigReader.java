package commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
Properties properties;

  public void propertyReader() throws IOException {
      FileInputStream file=new FileInputStream("C:\\GitHubRepo\\APIFrameworkPractice\\src\\test\\resources\\properties\\application.properties");
      properties.load(file);

  }


    public String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        System.out.println("#####reportConfigPath: "+reportConfigPath);
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}
