package drivers;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface BrowserstackConfig extends Config {

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    String app();

    String device();

    @Key("os_version")
    String osVersion();

    String project();

    String build();

    String name();

    String remote();
}