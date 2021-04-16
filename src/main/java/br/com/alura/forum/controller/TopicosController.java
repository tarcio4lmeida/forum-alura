package br.com.alura.forum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	TopicoRepository topicoRepository;

	@GetMapping
	public List<TopicoDTO> lista(String nomeCurso) {
		List<Topico> topicos = new ArrayList<Topico>();
		
		if (nomeCurso == null) {
			topicos = topicoRepository.findAll();
		
		}else {
			 topicos = topicoRepository.findByNomeCurso(nomeCurso);
		}
		return TopicoDTO.converter(topicos);
	}
	@PostMapping
	public void cadastrar() {
		
	}

}
