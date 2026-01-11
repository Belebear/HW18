package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.WikiTestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    private final WikiTestConfig config = ConfigFactory.create(WikiTestConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        String user = System.getProperty("user", "default_user");
        String key = System.getProperty("key", "default_key");

        caps.setCapability("browserstack.user", user);
        caps.setCapability("browserstack.key", key);
        caps.setCapability("app", config.appName());
        caps.setCapability("deviceName", config.deviceName());
        caps.setCapability("platformVersion", config.osVersion());

        try {
            return new RemoteWebDriver(
                    new URL(config.browserstackUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
