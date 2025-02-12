package de.togares.sevencord.application;

import de.togares.sevencord.services.discord.api.SevencordApi;
import de.togares.sevencord.services.discord.core.DiscordCoreConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        DiscordCoreConfiguration.class
})
@ComponentScan
public class SevencordConfiguration implements CommandLineRunner {
    @Autowired
    private SevencordApi api;

    @Override
    public void run(String... args) throws Exception {
        api.initializeBot();
    }
}
