package udemy.proto.api.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import udemy.proto.api.app.dto.PessoaDTO;
import udemy.proto.api.app.repository.PessoaRepository;

@Slf4j
@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<PessoaDTO> pessoas(Integer id) {
		
		log.info("lista todas as pessoas");				
		
		return modelMapper.map(pessoaRepository.pessoas(), new TypeToken<List<PessoaDTO>>() {}.getType());
	}

	public PessoaDTO pessoa() {
		log.info("busca pessoa por id");
		
		return null;
	}

	public PessoaDTO criarPessoas(Integer id) {
		log.info("Criar um novo usuario");
		return null;
	}

	public void deletePessoas(Integer id) {
		log.info("Remove a pessoa");
	}

	public PessoaDTO AtualizarPessoas(Integer id) {
		log.info("Atualiza dados da pessoa");
		return null;
	}
}
