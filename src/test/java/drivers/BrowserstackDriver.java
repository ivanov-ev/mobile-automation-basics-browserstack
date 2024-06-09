package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "eugeneivanov_XRVOLf");
        //caps.setCapability("userName", browserstackConfig.browserstackUser());
        caps.setCapability("browserstack.key", "ajdSE72TKx91caiJVBBn");
        //caps.setCapability("accessKey", browserstackConfig.browserstackKey());

        // Set URL of the application under test
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        //caps.setCapability("app", browserstackConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        //caps.setCapability("deviceName", browserstackConfig.device());
        caps.setCapability("os_version", "9.0");
        //caps.setCapability("platformVersion", browserstackConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        //caps.setCapability("projectName", browserstackConfig.project());
        caps.setCapability("build", "browserstack-build-1");
        //caps.setCapability("buildName", browserstackConfig.build());
        caps.setCapability("name", "first_test");
        //caps.setCapability("sessionName", browserstackConfig.name());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
                    //new URL(browserstackConfig.remote()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}