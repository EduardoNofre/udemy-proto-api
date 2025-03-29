package udemy.proto.api.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import udemy.proto.api.app.dto.PessoaDTO;

@Repository
public interface PessoaRepository {

	public PessoaDTO pessoa(Integer id);

	public List<PessoaDTO> pessoas();

	public PessoaDTO criarPessoas(Integer id);

	public void deletePessoas(Integer id);

	public PessoaDTO AtualizarPessoas(Integer id);
}
