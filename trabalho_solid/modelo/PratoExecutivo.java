package modelo;

import java.math.BigDecimal;

public class PratoExecutivo extends Prato {
    public PratoExecutivo(String nome, BigDecimal precoBase, int tempoPreparo) {
        super(nome, precoBase, tempoPreparo);
    }

    @Override
    public BigDecimal calcularPreco() {
        return getPrecoBase();
    }
}
