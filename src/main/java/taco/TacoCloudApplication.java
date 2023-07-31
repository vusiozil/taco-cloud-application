package taco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class TacoCloudApplication{

	private static final Logger LOG = LoggerFactory.getLogger(TacoCloudApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
		LOG.info("starting taco cloud application");
	}

}
