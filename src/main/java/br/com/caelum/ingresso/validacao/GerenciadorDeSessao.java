package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	
	private List<Sessao> sessoesSala;
	
	public GerenciadorDeSessao(List<Sessao> sessoesSala) {
		this.sessoesSala = sessoesSala;
	}
	
	public boolean cabe(Sessao sessaoNova) {
		if (terminaAmanha(sessaoNova)) {
			return false;
		}
		return sessoesSala.stream().noneMatch(sessaoExistente -> horariosConflitantes(sessaoExistente, sessaoNova));
		
	}
	
	private boolean terminaAmanha(Sessao sessao) {
		LocalDateTime terminoSessaoNova = getTerminoSessaoComDiaDeHoje(sessao);
		LocalDateTime ultimoSegundoHoje = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		
		if(terminoSessaoNova.isAfter(ultimoSegundoHoje)) {
			return true;
		}
		return false;
	}
	
	private boolean horariosConflitantes(Sessao sessaoExistente, Sessao sessaoNova) {
		
		LocalDateTime inicioSessaoExistente = getInicioSessaoComDiaDeHoje(sessaoExistente);
		LocalDateTime terminoSessaoExistente = getTerminoSessaoComDiaDeHoje(sessaoExistente); 
		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaDeHoje(sessaoNova);
		LocalDateTime terminoSessaoNova = getTerminoSessaoComDiaDeHoje(sessaoNova);
		
		boolean sessaoNovaTerminaAntesDaExistente = terminoSessaoNova.isBefore(inicioSessaoExistente);
		boolean sessaoNovaComecaDepoisDaExistente = terminoSessaoExistente.isBefore(inicioSessaoNova);
		
		if(sessaoNovaTerminaAntesDaExistente || sessaoNovaComecaDepoisDaExistente) {
			return false;
		}		
		return true;
	}
	
	private LocalDateTime getInicioSessaoComDiaDeHoje(Sessao sessao) {
		LocalDate hoje = LocalDate.now();
		
		return sessao.getHorario().atDate(hoje);
	}
	
	private LocalDateTime getTerminoSessaoComDiaDeHoje(Sessao sessao) {
		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaDeHoje(sessao);
		
		return inicioSessaoNova.plus(sessao.getFilme().getDuracao());
	}
}
