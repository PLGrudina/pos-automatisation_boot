package ua.automatisationInc.pos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Man on 21.03.2017.
 */
@Configuration
@Import(PersistenceConfig.class)
@ComponentScan("ua.automatisationInc.pos.services")
public class RootConfig {
}
