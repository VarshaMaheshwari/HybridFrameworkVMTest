package Selenium;

import org.testng.annotations.*;

public class TestNGAnnotationTest {

    @BeforeSuite
    public void beforeSuiteMethod() {
        System.out.println("In before suite method");
    }

    @BeforeClass
    public void beforeClassMethod() {
        System.out.println("In before class method");
    }
    @BeforeTest
    public void beforetestMethod() {
        System.out.println("In before test method");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("In before method method");
    }


    @AfterSuite
    public void afterSuiteMethod() {
        System.out.println("In after suite method");
    }

    @AfterClass
    public void afterClassMethod() {
        System.out.println("In after class method");
    }
    @AfterTest
    public void aftertestMethod() {
        System.out.println("In after test method");
    }

    @AfterMethod
    public void afterMethodMethod() {
        System.out.println("In after method method");
    }
  @Test
  public void testMethod() {
      System.out.println("In Test method");
  }
}
