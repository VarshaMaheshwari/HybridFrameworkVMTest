package constants;

public class ConfigConstants {

   private static String baseurl = "https://www.google.com";
    private String externalApp;

    public static String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public String getExternalApp() {

        return externalApp;
    }

}
