package udemy.proto.api.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/pessoa")
@Getter
@AllArgsConstructor
@Tag(name = "PessoaController", description = "Recurso Pessoa Controller")
public class PessoaController {

	/**
	 * 
	 * Busca pessoa  por id
	 * 
	 * @return
	 */
	@Operation(summary = "Busca pessoa  por id", description = "Busca cliente por id no banco de dados")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "204", description = "Sem conteudo"),
			@ApiResponse(responseCode = "400", description = "Processar a requisição"),
			@ApiResponse(responseCode = "401", description = "Não autorizado"),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado"),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada."),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out") })
	@GetMapping(value = "id/{idCliente}", produces = { "application/json", "application/xml" })
	public ResponseEntity<String> pessoa() {

		return ResponseEntity.status(HttpStatus.OK).body("2");

	}
}
