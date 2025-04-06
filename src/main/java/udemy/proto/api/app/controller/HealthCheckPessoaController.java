package udemy.proto.api.app.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/healthcheck")
@Getter
@AllArgsConstructor
@Order
@Tag(name = "Recurso Health Check Pessoa Controllerr", description = "HealthCheckPessoaController")
public class HealthCheckPessoaController {

	private static final String TIME = "time";
	
	@Autowired
	private BuildProperties properties;
	
	@GetMapping()
	@Operation(summary = "VERIFICA SE A APLICAÇÃO ESTA NO AR ", description = "ANALISE DA SAUDE ENDPOINT")
	public ResponseEntity<Map<String, Object>> healthCheck() {
		Map<String, Object> map = new ConcurrentHashMap<>();
		this.properties.forEach(p -> {
			if (TIME.equalsIgnoreCase(p.getKey())) {
				LocalDateTime time = null;
				if (Objects.nonNull(this.properties.getTime())) {
					time = LocalDateTime.ofInstant(this.properties.getTime(), ZoneId.systemDefault());
				}
				map.put(p.getKey(), time);
			} else {
				map.put(p.getKey(), p.getValue());
			}
		});
		return ResponseEntity.ok(map);
	}
}
