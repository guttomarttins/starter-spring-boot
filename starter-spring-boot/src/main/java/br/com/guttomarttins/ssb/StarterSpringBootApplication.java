package br.com.guttomarttins.ssb;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class StarterSpringBootApplication {
	
	private static final Logger log = LoggerFactory.getLogger(StarterSpringBootApplication.class);


	public static void main(String[] args) {
		ConfigurableApplicationContext config = SpringApplication.run(StarterSpringBootApplication.class, args);
		Environment env = config.getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" + "Application '{}' is running!\n\t"
		+ "Profile Active is :{}\n" + "----------------------------------------------------------",
		StarterSpringBootApplication.class.getCanonicalName(), Arrays.asList(env.getActiveProfiles()));
	}

}
