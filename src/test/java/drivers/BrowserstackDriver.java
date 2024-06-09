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

    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", browserstackConfig.browserstackUser());
        caps.setCapability("browserstack.key", browserstackConfig.browserstackKey());

        // Set URL of the application under test
        caps.setCapability("app", browserstackConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", browserstackConfig.device());
        caps.setCapability("os_version", browserstackConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", browserstackConfig.project());
        caps.setCapability("build", browserstackConfig.build());
        caps.setCapability("name", browserstackConfig.name());

        // Initialise the remote WebDriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.remote()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}