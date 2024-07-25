package codegen;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CodegenRecordings {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Special Hot").setExact(true)).click();
      page.getByText("There are no special offer").click();
      assertThat(page.locator("#entry_212499")).containsText("There are no special offer products to list.");
      page.locator("#widget-navbar-217834").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Home")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search For Products")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search For Products")).fill("iphone");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
      page.getByText("Shop by Category Home Special").click();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("About Us"))).isVisible();
      assertThat(page.locator("h1")).containsText("About Us");
      assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Poco Electro"))).isVisible();
      assertThat(page.locator("#widget-navbar-217834")).containsText("Featured");
      page.getByLabel("Wishlist").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue")).click();
      page.getByText("This is a dummy website for").click();
      assertThat(page.getByText("This is a dummy website for")).isVisible();
      assertThat(page.locator("#entry_217838")).containsText("This is a dummy website for Web Automation Testing");
      page.getByPlaceholder("First Name").click();
      page.getByPlaceholder("First Name").fill("Arun");
      page.getByPlaceholder("Last Name").click();
      page.getByPlaceholder("Last Name").fill("Prasanth");
      page.getByPlaceholder("Last Name").press("Tab");
      page.getByPlaceholder("E-Mail").fill("abc@gmail.com");
      page.getByPlaceholder("Telephone").click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" My account")).click();
      page.close();
      browser.close();
      playwright.close();

    }
  }
}