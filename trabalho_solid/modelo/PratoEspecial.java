package modelo;

import java.math.BigDecimal;

public class PratoEspecial extends Prato {
    private final BigDecimal custoPremium;

    public PratoEspecial(String nome, BigDecimal precoBase, int tempoPreparo, BigDecimal custoPremium) {
        super(nome, precoBase, tempoPreparo);
        this.custoPremium = valor(custoPremium);
    }

    @Override
    public BigDecimal calcularPreco() {
        return getPrecoBase().add(custoPremium);
    }
}
