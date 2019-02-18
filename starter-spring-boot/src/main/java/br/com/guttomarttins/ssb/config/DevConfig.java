package br.com.guttomarttins.ssb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.guttomarttins.ssb.service.H2Service;
import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private H2Service h2Service;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDataBase() throws ParseException {

		if (!"create".equals(strategy)) {
			return false;
		}

		h2Service.instantiateH2DataBase();
		return true;
	}
}
