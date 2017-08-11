package de.bonprix.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.bonprix.base.demo.service.ApplicationService;
import de.bonprix.base.demo.service.SecurityDemoService;
import de.bonprix.jersey.ClientFactoryConfig;
import de.bonprix.jersey.ClientFactoryConfig.ClientSideLogLevel;
import de.bonprix.jersey.JaxRsClientFactory;

@Configuration
public class WebserviceClientConfiguration {

	@Value("${webservice.url.demo}")
	private String webserviceDemoUrl;

	@Bean
	public SecurityDemoService securityDemoService(final JaxRsClientFactory jaxRsClientFactory) {
		final ClientFactoryConfig config = new ClientFactoryConfig();
		config.setClientSideLogging(ClientSideLogLevel.METHOD_TIME);

		return jaxRsClientFactory.createClient(this.webserviceDemoUrl, SecurityDemoService.class, config);
	}

	@Bean
	public ApplicationService applicationService(final JaxRsClientFactory jaxRsClientFactory) {
		final ClientFactoryConfig config = new ClientFactoryConfig();
		config.setClientSideLogging(ClientSideLogLevel.METHOD_TIME);

		return jaxRsClientFactory.createClient(this.webserviceDemoUrl, ApplicationService.class, config);
	}
}
