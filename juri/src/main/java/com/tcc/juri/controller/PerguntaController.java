package com.tcc.juri.controller;

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

import com.tcc.juri.dto.PerguntaRespostaDTO;
import com.tcc.juri.dto.RespostaRequest;
import com.tcc.juri.entity.AudienciaEntity;
import com.tcc.juri.entity.JogadorEntity;
import com.tcc.juri.entity.JogadorRespostaEntity;
import com.tcc.juri.entity.PerguntaEntity;
import com.tcc.juri.entity.RespostaEntity;
import com.tcc.juri.repository.AudienciaRepository;
import com.tcc.juri.repository.JogadorRepository;
import com.tcc.juri.repository.JogadorRespostaRepository;
import com.tcc.juri.repository.PerguntaRepository;
import com.tcc.juri.repository.RespostaRepository;
import com.tcc.juri.util.Const;


@RestController
@RequestMapping(Const.PERGUNTA)
public class PerguntaController {

	@Autowired
	private PerguntaRepository perguntaRepository;
	
	@Autowired
	private RespostaRepository respostaRepository;
	
	@Autowired
	private JogadorRespostaRepository jogadorRespostaRepository;
	
	@Autowired
	private AudienciaRepository audienciaRepository;
	
	@Autowired
	private JogadorRepository jogadorRepository; 
	
	@Autowired
	private JogadorController jogadorController;

	@CrossOrigin
	@GetMapping
	@RequestMapping("/random/{id}")
	public ResponseEntity<PerguntaRespostaDTO> getPergunta(@PathVariable("id") @NotNull Long id) {
		
		List<PerguntaEntity> perguntas = perguntaRepository.findNotUsedTerminalByIdAudiencia(id);
		if(perguntas != null && !perguntas.isEmpty()) {
			List<RespostaEntity> respostas = respostaRepository.findByPerguntaId(perguntas.get(0).getId());
			return ResponseEntity.ok(new PerguntaRespostaDTO(perguntas.get(0), respostas));
		}
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin
	@PostMapping
	@RequestMapping("/resposta")
	public ResponseEntity<String> postResposta(@RequestBody @Valid RespostaRequest request ) {
		
		
		Optional<AudienciaEntity> audienciaEntity = audienciaRepository.findById(request.getIdAudiencia());
		if(!audienciaEntity.isPresent()) {
			return new ResponseEntity<>("Audiencia não localizada", HttpStatus.UNAUTHORIZED);	
		}
		
		Optional<JogadorEntity> jogadorEntity = jogadorRepository.findById(request.getIdJogador());
		if(!jogadorEntity.isPresent()) {
			return new ResponseEntity<>("Jogador não localizado", HttpStatus.UNAUTHORIZED);
		}
		
		Optional<RespostaEntity> respostaEntity = respostaRepository.findById(request.getIdResposta());
		if(!respostaEntity.isPresent()) {
			return new ResponseEntity<>("Resposta não localizada", HttpStatus.UNAUTHORIZED);
		}
		Optional<JogadorRespostaEntity> jgr = jogadorRespostaRepository.findByJogadorIdAndRespostaIdAndAudienciaId(jogadorEntity.get().getId(), respostaEntity.get().getId(), audienciaEntity.get().getId());
		if(jgr.isPresent()) {
			return new ResponseEntity<>("Resposta já aplicada", HttpStatus.UNAUTHORIZED);
		}
		
		JogadorRespostaEntity entity = JogadorRespostaEntity.builder()
				.audienciaId(audienciaEntity.get().getId())
				.jogadorId(jogadorEntity.get().getId())
				.respostaId(respostaEntity.get().getId())
				.somaPeso(respostaEntity.get().getPeso())
				.build();
		
		jogadorRespostaRepository.save(entity);
		
		jogadorController.updatePontos(jogadorEntity.get(), respostaEntity.get().getPeso());
		
		 return new ResponseEntity<>("", HttpStatus.OK);
	}
	
}
