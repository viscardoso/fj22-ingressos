package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaBancos implements IDesconto{
	
	@Override
	public BigDecimal aplicaDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.subtract(trintaPorCento(precoOriginal));
	}
	
	public BigDecimal trintaPorCento(BigDecimal precoOriginal) {
		return precoOriginal.multiply(new BigDecimal(0.3));
	}

	

}
