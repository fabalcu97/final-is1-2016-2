package app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import config.WebConfig;
import domain.BaseEntity;
import storage.StorageProperties;
import storage.StorageService;

@Import(WebConfig.class)
@EnableAutoConfiguration
@EntityScan(basePackageClasses=BaseEntity.class)
@EnableConfigurationProperties(StorageProperties.class)
public class BankApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BankApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}*/
}
