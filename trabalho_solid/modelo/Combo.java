package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Combo extends Prato {
    public Combo(String nome, BigDecimal precoBase, int tempoPreparo) {
        super(nome, precoBase, tempoPreparo);
    }

    @Override
    public BigDecimal calcularPreco() {
        return getPrecoBase().multiply(new BigDecimal("0.85")).setScale(2, RoundingMode.HALF_UP);
    }
}
