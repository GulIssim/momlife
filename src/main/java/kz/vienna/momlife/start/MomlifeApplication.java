package kz.vienna.momlife.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("kz.vienna.momlife")
@EnableJpaRepositories("kz.vienna.momlife.repository")
@EntityScan("kz.vienna.momlife.model.entity")
public class MomlifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MomlifeApplication.class, args);
	}
}
