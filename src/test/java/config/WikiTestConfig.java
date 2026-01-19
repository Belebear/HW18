package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:android.properties"
})

public interface WikiTestConfig extends Config {

    @Key("app.name")
    String appName();

    @Key("device.name")
    String deviceName();

    @Key("android.version")
    String osVersion();

    @Key("browserstack.url")
    String browserstackUrl();
}

