package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class SemDesconto implements IDesconto{

	@Override
	public BigDecimal aplicaDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal;
	}

}
