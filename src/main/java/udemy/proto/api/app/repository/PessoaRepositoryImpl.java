package udemy.proto.api.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;

import udemy.proto.api.app.dto.PessoaDTO;
import udemy.proto.api.app.model.Pessoa;

@Repository
public class PessoaRepositoryImpl {

	private final List<Pessoa> pessoas = new ArrayList<>();

	private final Faker faker = new Faker();

	public PessoaDTO pessoa(Integer id) {
		return null;
	}

	public PessoaDTO criarPessoas(Integer id) {
		return null;
	}

	public void deletePessoas(Integer id) {
	}

	public PessoaDTO AtualizarPessoas(Integer id) {
		return null;
	}
	
	public List<Pessoa> pessoas() {

		for (int x = 0; x > 10; x++) {
			Pessoa p = new Pessoa();
			p.setId(UUID.randomUUID().variant());
			p.setNome(faker.name().name());
			p.setIdade(5*x);
			p.setDataNascimento(faker.date().birthday());
			pessoas.add(p);
		}
		return pessoas;
	}

}
