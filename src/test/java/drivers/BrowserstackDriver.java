package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        caps.setCapability("browserstack.user", authConfig.mobileUser());
        caps.setCapability("browserstack.key", authConfig.mobilePass());
        BrowserstackConfig hostConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
        caps.setCapability("app", hostConfig.app());
        caps.setCapability("device", hostConfig.device());
        caps.setCapability("os_version", hostConfig.version());
        caps.setCapability("project", hostConfig.project());
        caps.setCapability("build", hostConfig.build());
        caps.setCapability("name", hostConfig.name());

        try {
            return new RemoteWebDriver(
                    new URL(hostConfig.url()), caps);
        } catch (
                MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}