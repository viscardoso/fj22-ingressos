package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public interface IDesconto {
	BigDecimal aplicaDescontoSobre(BigDecimal precoOriginal);
}
