package com.pi.javateam.web.config;

import com.pi.javateam.services.CrmService;
import com.pi.javateam.services.ProjectService;
import com.pi.javateam.services.TeamService;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Petri Kainulainen
 */
@Configuration
public class TestContext {

    private static final String MESSAGE_SOURCE_BASE_NAME = "i18n/messages";

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(MESSAGE_SOURCE_BASE_NAME);
        messageSource.setUseCodeAsDefaultMessage(true);

        return messageSource;
    }

    @Bean
    public CrmService crmService() {
        return Mockito.mock(CrmService.class);
    }

    @Bean
    public ProjectService projectService(){
        return Mockito.mock(ProjectService.class);
    }

    @Bean
    public TeamService teamService(){
        return Mockito.mock(TeamService.class);
    }
}
