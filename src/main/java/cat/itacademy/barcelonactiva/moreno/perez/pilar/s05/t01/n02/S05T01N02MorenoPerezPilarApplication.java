package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Flors API", version = "1.0", description = "Nom de les flors i països d'on son originàries"))
public class S05T01N02MorenoPerezPilarApplication {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(S05T01N02MorenoPerezPilarApplication.class, args);
	}

	//http://localhost:9001/v3/api-docs  para el json de swagger
	//http://localhost:9001/swagger-ui/index.html  para la interfaz
}
