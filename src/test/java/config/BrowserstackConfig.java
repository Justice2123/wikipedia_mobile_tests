package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:browserstack.properties"
})

public interface BrowserstackConfig extends Config {

    @Key("browserstackApp")
    String app();

    @Key("browserstackDevice")
    String device();

    @Key("browserstackOsVersion")
    String version();

    @Key("browserstackProject")
    String project();

    @Key("browserstackBuild")
    String build();

    @Key("browserstackName")
    String name();

    @Key("browserstackUrl")
    String url();

}