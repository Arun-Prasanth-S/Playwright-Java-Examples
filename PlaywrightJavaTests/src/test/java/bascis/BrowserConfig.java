package bascis;

import com.microsoft.playwright.*;

public class BrowserConfig {
    private Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    public enum Browsers {
        CHROMIUM, FIREFOX, WEBKIT
    }

    public void setUp(Browsers browserType) {
        playwright = Playwright.create();
        switch (browserType) {
            case CHROMIUM:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case FIREFOX:
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case WEBKIT:
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (browserContext != null) {
            browserContext.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}

