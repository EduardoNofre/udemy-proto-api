package udemy.proto.api.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import udemy.proto.api.app.dto.PessoaDTO;
import udemy.proto.api.app.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
@Getter
@AllArgsConstructor
@Order
@Tag(name = "Recurso Pessoa Controller", description = "PessoaController")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Operation(summary = "Lista as pessoa ", description = "lista de pessoas")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PessoaDTO.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping()
	public ResponseEntity<List<PessoaDTO>> pessoas() {

		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.pessoas());

	}

	@Operation(summary = "Cria uma lista pessoas ", description = "Criar lista de pessoas de tamanho 10")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "criado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping("/criar")
	public ResponseEntity<Integer> criarPessoas() {

		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.criarPessoas());

	}

	@Operation(summary = "Busca pessoa  por id", description = "Retorna a pessoa de acordo com o numero do ID informado.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PessoaDTO.class)) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping("/pessoa")
	public ResponseEntity<PessoaDTO> pessoa(
			@Parameter(name = "id", description = "Número identificador da pessoa", example = "123") @RequestParam(name = "id", required = true) Integer id) {

		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.pessoa(id));

	}

	@Operation(summary = "Excluir pessoa  por id", description = "Remove a pessoas de acordo com o ID informado. ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@DeleteMapping()
	public ResponseEntity<Void> exlcuirPessoa(
			@Parameter(name = "id", description = "Número identificador da pessoa", example = "123") @RequestParam(name = "id", required = true) Integer id) {

		pessoaService.deletarPessoas(id);

		return ResponseEntity.ok().build();

	}

	@Operation(summary = "Inserir pessoa ", description = " Faz o cadastro de uma nova pessoa ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PessoaDTO.class)) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@PostMapping()
	public ResponseEntity<PessoaDTO> inserirPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {

		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.inserirPessoa(pessoaDTO));

	}

	@Operation(summary = " Atualizar pessoa ", description = " Atualiza os dados da pessoa conforme o ID informado ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PessoaDTO.class)) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@PutMapping()
	public ResponseEntity<PessoaDTO> atualizarPessoas(@RequestBody @Valid PessoaDTO pessoaDTO) {

		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.atualizarPessoas(pessoaDTO));

	}
}
