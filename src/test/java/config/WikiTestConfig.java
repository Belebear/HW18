package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:android.properties"
})

public interface WikiTestConfig extends Config {

    @Key("appName")
    String appName();

    @Key("deviceName")
    String deviceName();

    @Key("android.version")
    String osVersion();

    @Key("browserstack.url")
    String browserstackUrl();
}

