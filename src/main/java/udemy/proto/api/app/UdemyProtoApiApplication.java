package udemy.proto.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Micro Service estudo KeyCloack ", version = "1.0",description = " Key Cloack "))
public class UdemyProtoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyProtoApiApplication.class, args);
	}

}
