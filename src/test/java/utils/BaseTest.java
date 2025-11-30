package utils;

import com.microsoft.playwright.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.List;

public class BaseTest {
    protected Playwright playwright;
    protected Page page;

    private static final Dotenv dotenv = Dotenv.configure().load();

    public static String URL = dotenv.get("WP_URL");
    public static String USERNAME = dotenv.get("WP_USERNAME");
    public static String PASSWORD = dotenv.get("WP_PASSWORD");

    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();
        page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                        .setArgs(List.of("--start-maximized")))
                .newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();
        page.navigate(URL);
    }

    @AfterMethod
    public void teardown() {
        page.close();
        playwright.close();
    }
}
