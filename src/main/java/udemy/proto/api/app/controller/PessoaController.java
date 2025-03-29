package udemy.proto.api.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import udemy.proto.api.app.dto.PessoaDTO;
import udemy.proto.api.app.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
@Getter
@AllArgsConstructor
@Tag(name = "PessoaController", description = "Recurso Pessoa Controller")
public class PessoaController {

	
	@Autowired
	private PessoaService pessoaService;
	/**
	 * 
	 * Busca pessoa  por id
	 * 
	 * @return
	 */
	@Operation(summary = "Busca pessoa  por id", description = "Busca cliente por id no banco de dados")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping()
	public ResponseEntity<PessoaDTO> pessoa() {

		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.pessoa());

	}
}
