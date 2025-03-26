package udemy.proto.api.app.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ComponentScan("udemy.proto.api.app")
public class ApplicationModelMapper  {

	  @Bean
	  public ModelMapper modelMapper() {
		log.info("[UDEMY-PROTO] - modelMapper - inicializado");
	    final ModelMapper mp = new ModelMapper();
	    mp.getConfiguration().setAmbiguityIgnored(true).setDeepCopyEnabled(false)
	        .setFullTypeMatchingRequired(true).setMatchingStrategy(MatchingStrategies.STRICT);
	    return mp;
	  }
}
