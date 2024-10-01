package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:realDevice.properties"
})

public interface RealDeviceConfig extends Config {

    String deviceName();

    String mobileUrl();

}
