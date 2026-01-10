package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        //"classpath:${device}.properties",
        "classpath:android.properties"
})

public interface WikiTestConfig extends Config {

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("appName")
    String appName();

    @Key("deviceName")
    String deviceName();

    @Key("android.version")
    String osVersion();

    @Key("browserstack.url")
    String browserstackUrl();
}

