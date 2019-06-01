package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaestudante implements IDesconto{
	private BigDecimal metade = new BigDecimal(2);
	
	@Override
	public BigDecimal aplicaDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.divide(metade);
	}
	
}
