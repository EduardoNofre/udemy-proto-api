package udemy.proto.api.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import udemy.proto.api.app.dto.PessoaDTO;

@Service
@Slf4j
public class PessoaService {

	public PessoaDTO pessoa() {
		log.info("busca pessoa por id");
		
		return null;
	}

	public List<PessoaDTO> pessoas(Integer id) {
		log.info("lista todas as pessoas");
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
