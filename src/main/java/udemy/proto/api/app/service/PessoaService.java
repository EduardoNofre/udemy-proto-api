package udemy.proto.api.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import udemy.proto.api.app.dto.PessoaDTO;
import udemy.proto.api.app.model.Pessoa;
import udemy.proto.api.app.repository.PessoaRepository;

@Slf4j
@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public int criarPessoas() {
		log.info("criar todas as pessoas");
		return pessoaRepository.criarPessoas();
	}

	public List<PessoaDTO> pessoas() {
		log.info("lista todas as pessoas");
		return modelMapper.map(pessoaRepository.pessoas(), new TypeToken<List<PessoaDTO>>() {
		}.getType());
	}

	public PessoaDTO pessoa(Integer id) {
		log.info("busca pessoa por id");
		Pessoa pessoa = pessoaRepository.pessoa(id);
		return modelMapper.map(pessoa, PessoaDTO.class);
	}

	public void deletarPessoas(Integer id) {
		log.info("Remove a pessoa");
		pessoaRepository.deletePessoas(id);
	}


	public PessoaDTO inserirPessoa(PessoaDTO pessoaDTO) {

		log.info("Inserir uma pessoas");

		Pessoa pessoaEntity = modelMapper.map(pessoaDTO, Pessoa.class);

		pessoaEntity = pessoaRepository.inserirPessoa(pessoaEntity);

		return modelMapper.map(pessoaEntity, PessoaDTO.class);

	}
	
	public PessoaDTO atualizarPessoas(PessoaDTO pessoaDTO) {
		log.info("Atualiza dados da pessoa");
		
		Pessoa pessoaEntity = modelMapper.map(pessoaDTO, Pessoa.class);

		pessoaEntity = pessoaRepository.AtualizarPessoas(pessoaEntity);

		return modelMapper.map(pessoaEntity, PessoaDTO.class);
	}
}
