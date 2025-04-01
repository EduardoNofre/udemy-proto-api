package udemy.proto.api.app.repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sound.midi.Sequence;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;

import lombok.Data;
import udemy.proto.api.app.model.Pessoa;

@Data
@Repository
public class PessoaRepository {

	private final List<Pessoa> pessoas = new ArrayList<>();

	private final Faker faker = new Faker();

	public Pessoa pessoa(Integer id) {
		int index = 0;
		for (Pessoa p : pessoas) {
			if (p.getId().equals(id)) {
				return pessoas.get(index);
			}
			index++;
		}
		return null;
	}

	public Pessoa inserirPessoa(Pessoa pessoa) {

		pessoas.add(pessoa);

		return pessoa;
	}

	public void deletePessoas(Integer id) {
		int index = 0;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getId().equals(id)) {
				pessoas.remove(index);
				break;
			}
			index++;
		}
	}

	public List<Pessoa> pessoas() {

		return pessoas;
	}

	public int criarPessoas() {

		for (int x = 0; x < 10; x++) {
			Pessoa p = new Pessoa();
			 int randomNum = (int)(Math.random() * 101);
			p.setId(randomNum);
			p.setNome(faker.gameOfThrones().character());
			p.setIdade(faker.date().birthday().getYear());
			p.setDataNascimento(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(faker.date().birthday())));
			pessoas.add(p);
		}
		return pessoas.size();
	}

	public Pessoa AtualizarPessoas(Pessoa pessoa) {

		int index = 0;
		Pessoa pessoaAutal = null;
		for (Pessoa p : pessoas) {
			if (p.getId().equals(pessoa.getId())) {
				pessoaAutal = pessoas.get(index);
				pessoaAutal.setId(pessoa.getId());
				pessoaAutal.setDataNascimento(pessoa.getDataNascimento());
				pessoaAutal.setIdade(pessoa.getIdade());
				pessoaAutal.setNome(pessoa.getNome());
				pessoas.add(pessoaAutal);
				pessoas.remove(index);
				break;

			}
			index++;
		}
		return pessoaAutal;

	}
}
