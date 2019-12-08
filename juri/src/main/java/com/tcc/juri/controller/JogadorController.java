package com.tcc.juri.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcc.juri.dto.JogadorDTO;
import com.tcc.juri.dto.JogadorLoginRequest;
import com.tcc.juri.dto.JogadorResponse;
import com.tcc.juri.dto.PlacarResponse;
import com.tcc.juri.entity.JogadorEntity;
import com.tcc.juri.repository.JogadorRepository;
import com.tcc.juri.repository.JogadorRespostaRepository;
import com.tcc.juri.util.Const;


@RestController
@RequestMapping(Const.JOGADOR)
public class JogadorController {

	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private JogadorRespostaRepository jogadorRespostaRepository;
	
	@CrossOrigin
	@GetMapping
	@RequestMapping("/list")
	public List<JogadorDTO> listJogadores() {
		
		List<JogadorEntity> jogadores = jogadorRepository.findAll();
		return JogadorDTO.conveter(jogadores);
	}
	
	@CrossOrigin
	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<JogadorResponse> listJogador(@PathVariable("id") @NotNull Long id) {
		
		JogadorEntity entity = jogadorRepository.findOne(id);
		if(entity != null) {
			return ResponseEntity.ok(new JogadorResponse(entity));
		}
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<JogadorDTO> insert(@RequestBody @Valid JogadorDTO jogadorDTO, UriComponentsBuilder uriBuilder) {
		
		JogadorEntity jogadorEntity = jogadorDTO.convert(jogadorDTO);
		jogadorRepository.save(jogadorEntity);
		jogadorDTO.setId(jogadorEntity.getId());
		
		URI uri = uriBuilder.path(Const.AUDIENCIA + "/{id}").buildAndExpand(jogadorEntity.getId()).toUri();
		return ResponseEntity.created(uri).body(jogadorDTO);
	}
	
	@CrossOrigin
	@PostMapping
	@RequestMapping("/login")
	public ResponseEntity<JogadorResponse> login(@RequestBody @Valid JogadorLoginRequest request){
	
		Optional<JogadorEntity> jogadorEntity = jogadorRepository.findByUsuarioAndSenha(request.getUsuario(), request.getSenha());
		if(!jogadorEntity.isPresent()) {
			return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok().body(new JogadorResponse(jogadorEntity.get()));
	}
	
	@CrossOrigin
	@GetMapping
	@RequestMapping("/placar")
	public ResponseEntity<List<PlacarResponse>> placarLideres() {
		
		List<PlacarResponse> placar = new ArrayList();
		List<JogadorEntity> jogadores = jogadorRepository.findForPlacar();
		for(JogadorEntity jogador : jogadores) {			
			placar.add(new PlacarResponse(jogador.getNome(), jogador.getTotalPts()));
		}			
			
		return ResponseEntity.ok().body(placar);
	}
	
	public boolean updatePontos(JogadorEntity jogador, int pontos) {
		try {
			int totalPontos = jogador.getTotalPts() + pontos;
			jogador.setTotalPts(totalPontos);
			jogadorRepository.save(jogador);
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
}
