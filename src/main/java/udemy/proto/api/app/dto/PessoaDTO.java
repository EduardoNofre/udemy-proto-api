package udemy.proto.api.app.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class PessoaDTO {

	@Schema(name = "id", description = "Número identificador da pessoa", example = "123", type = "Integer")
	private Integer id;
	
	@Schema(name = "nome", description = "Nome da pessoa", example = "eduardo", type = "String")
	private String nome;
	
	@Schema(name = "dataNascimento", description = "Data de nascimento", example = "1900-01-22", type = "LocalDate")
	private LocalDate dataNascimento;
	
	@Schema(name = "idade", description = "Idade da pessoa", example = "45", type = "Integer")
	private Integer idade;
}
