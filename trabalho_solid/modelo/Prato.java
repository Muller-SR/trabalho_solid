package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class Prato {
    private final String nome;
    private final BigDecimal precoBase;
    private final int tempoPreparo;

    protected Prato(String nome, BigDecimal precoBase, int tempoPreparo) {
        if (nome == null || nome.isBlank() || tempoPreparo <= 0) {
            throw new IllegalArgumentException("Informe um nome e um tempo de preparo positivo.");
        }
        this.precoBase = valor(precoBase);
        this.nome = nome;
        this.tempoPreparo = tempoPreparo;
    }

    protected static BigDecimal valor(BigDecimal valor) {
        Objects.requireNonNull(valor, "Valor obrigatório.");
        if (valor.signum() < 0 || valor.stripTrailingZeros().scale() > 2) {
            throw new IllegalArgumentException("O valor deve ser não negativo e ter até duas casas decimais.");
        }
        return valor.setScale(2, RoundingMode.UNNECESSARY);
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public abstract BigDecimal calcularPreco();
}
