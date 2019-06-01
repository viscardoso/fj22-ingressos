package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.caelum.ingresso.model.descontos.IDesconto;

public class Ingresso {
	private Sessao sessao;
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	private BigDecimal preco;
	
	public Ingresso (Sessao sessao, IDesconto tipoDesconto) {
		this.sessao = sessao;
		this.preco = tipoDesconto.aplicaDescontoSobre(sessao.getPreco());
	}
	
	public BigDecimal getPreco() {
		return preco.setScale(2,RoundingMode.HALF_UP);
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
