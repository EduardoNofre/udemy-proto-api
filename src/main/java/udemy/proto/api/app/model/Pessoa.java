package udemy.proto.api.app.model;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class Pessoa {

	private Integer id;
	private String nome;
	private LocalDate dataNascimento;
	private Integer idade;

}
