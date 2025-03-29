package udemy.proto.api.app.model;

import java.util.Date;

import lombok.Data;

@Data
public class Pessoa {

	private Integer id;
	private String nome;
	private Date dataNascimento;
	private Integer idade;

}
