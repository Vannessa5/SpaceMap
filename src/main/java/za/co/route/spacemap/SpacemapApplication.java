package za.co.route.spacemap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "za.co.route.spacemap.*" })
@SpringBootApplication
public class SpacemapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpacemapApplication.class, args);
	}

}
