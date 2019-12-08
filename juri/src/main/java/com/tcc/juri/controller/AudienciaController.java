package com.tcc.juri.controller;

import java.net.URI;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcc.juri.dto.audiencia.AudienciaDTO;
import com.tcc.juri.dto.audiencia.AudienciaResponse;
import com.tcc.juri.dto.audiencia.EstatisticasResposta;
import com.tcc.juri.dto.audiencia.enums.AudienciaTipoEnum;
import com.tcc.juri.dto.audiencia.enums.NomeJuizEnum;
import com.tcc.juri.entity.AudienciaEntity;
import com.tcc.juri.repository.AudienciaRepository;
import com.tcc.juri.repository.JogadorRespostaRepository;
import com.tcc.juri.repository.PerguntaRepository;
import com.tcc.juri.util.Const;


@RestController
@RequestMapping(Const.AUDIENCIA)
public class AudienciaController {

	@Autowired
	private AudienciaRepository audienciaRepository;
	
	@Autowired
	private JogadorRespostaRepository jRespRepository;
	
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	
	@CrossOrigin
	@GetMapping
	@RequestMapping("/list")
	public List<AudienciaResponse> listAudiencias(@PathParam("page") Integer page) {
		List<AudienciaResponse> audienciasResponse = new ArrayList();
		List<AudienciaResponse> audiencias = audienciaRepository.list();
		final Long qtd = perguntaRepository.countPerguntas();
		if(!audiencias.isEmpty()) {
			audiencias.forEach(audiencia ->{
				EstatisticasResposta er = jRespRepository.findEstatisticaByAudienciaId(audiencia.getId());
				addEstatisticas(qtd, audiencia, er);
				audienciasResponse.add(audiencia);
			});
		}
		return audienciasResponse;
	}

	private void addEstatisticas(final Long qtd, AudienciaResponse audiencia, EstatisticasResposta er) {
		if(er != null &&  er.getQuantidade() >0) {
			double comp = ((double)er.getQuantidade()/qtd)*100;
			audiencia.setCompletude(df2.format(comp) + "%");
			audiencia.setPontos(er.getTotal());
		}else {
			audiencia.setCompletude("0%");
			audiencia.setPontos(Long.valueOf(0));
		}
	}
	
	@CrossOrigin
	@GetMapping
	@RequestMapping("/create")
	public AudienciaDTO create() {
		
		try {			
			AudienciaEntity entity = new AudienciaEntity();
			entity.setData(new Date());
			entity.setNomeJuiz(NomeJuizEnum.generateNome());
			entity.setTipo(AudienciaTipoEnum.EM_ANDAMENTO);
			audienciaRepository.save(entity);
			
			return new AudienciaDTO(entity);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	@CrossOrigin
	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<AudienciaDTO> listAudiencia(@PathVariable("id") @NotNull Long id) {
		AudienciaEntity entity = audienciaRepository.findOne(id);
		if(entity != null) {
			return ResponseEntity.ok(new AudienciaDTO(entity));
		}
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<AudienciaDTO> insert(@RequestBody @Valid AudienciaDTO audienciaDTO, UriComponentsBuilder uriBuilder) {
		AudienciaEntity audienciaEntity = AudienciaDTO.convert(audienciaDTO);
		audienciaRepository.save(audienciaEntity);
		audienciaDTO.setId(audienciaEntity.getId());
		
		URI uri = uriBuilder.path(Const.AUDIENCIA + "/{id}").buildAndExpand(audienciaEntity.getId()).toUri();
		return ResponseEntity.created(uri).body(audienciaDTO);
	}
	
	@CrossOrigin
	@GetMapping
	@RequestMapping("/finalizar/{id}")
	public ResponseEntity finalizar(@PathVariable("id") @NotNull Long id) {
		
		Optional<AudienciaEntity> audiencia = audienciaRepository.findById(id);
		if(!audiencia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		audiencia.get().setTipo(AudienciaTipoEnum.CONCLUIDA);
		audienciaRepository.save(audiencia.get());
		return ResponseEntity.ok().build();
	}
	
}
