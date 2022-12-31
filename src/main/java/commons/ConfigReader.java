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

    /*   public static String getPropertyValue(String key) {
        String propertyValue = configProp.getProperty(key);
        if (StringUtils.isNotEmpty(propertyValue)) {
            return propertyValue;
        }
        propertyValue = System.getProperty(key);
        if (StringUtils.isNotEmpty(propertyValue)) {
            return propertyValue;
        }
        return System.getenv(key);
    }*/

    /*  how ro read from azure keyvault
      private static void loadkeyVault() {
        String keyVaultName = getPropertyValue(PSH_KEY_VAULT_NAME);
        if (StringUtils.isNotEmpty(keyVaultName)) {
            String keyVaultUri = "https://" + keyVaultName + ".vault.azure.net";
            SecretClient secretClient = new SecretClientBuilder()
                    .vaultUrl(keyVaultUri)
                    .credential(new DefaultAzureCredentialBuilder().build())
                    .buildClient();
            for (SecretProperties secretProperties : secretClient.listPropertiesOfSecrets()) {
                KeyVaultSecret secretWithValue = secretClient.getSecret(secretProperties.getName(), secretProperties.getVersion());
                System.setProperty(secretWithValue.getName(), secretWithValue.getValue());
            }
        }
    }
*/

    /* Read property in static block
    static {
        try (FileInputStream in = new FileInputStream(CONFIG_LOCATION)) {
            configProp.load(in);
        } catch (IOException ex) {
            System.out.println("Unable to load configuration file!");
        }
        try {
            loadkeyVault();
        } catch (Exception e) {
            System.out.println("Unable to load Key Vault!");

        }*/

}
