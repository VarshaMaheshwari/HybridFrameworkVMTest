package testRunner;

import io.cucumber.core.cli.Main;

public class RunMainTests {

    public static void main(String[] args) throws Throwable {
        Main.main(new String[] { "-g", "stepdefinitions", "src/test/resources/features/" });
    }
}
