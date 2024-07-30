package testExamples;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bascis.BrowserConfig;

public class BrowserConfigUsage extends BrowserConfig{

    @BeforeMethod
    public void setUpTest() {
        setUp(Browsers.CHROMIUM); // Choose the browser type here
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }

    @Test
    public void testExample() {
        page.navigate("www.google.com");

    }
}
