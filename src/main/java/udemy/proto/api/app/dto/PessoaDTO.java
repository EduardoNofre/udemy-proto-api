package udemy.proto.api.app.dto;

import java.time.LocalDate;

import lombok.Data;


@Data
public class PessoaDTO {

	private Integer id;
	private String nome;
	private LocalDate dataNascimento;
	private Integer idade;
}
