package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private final Cliente cliente;
    private final LocalDate data;
    private final List<Prato> pratos = new ArrayList<>();

    public Pedido(Cliente cliente, LocalDate data) {
        this.cliente = Objects.requireNonNull(cliente);
        this.data = Objects.requireNonNull(data);
    }
    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public List<Prato> getPratos() {
        return List.copyOf(pratos);
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(Objects.requireNonNull(prato));
    }

    public BigDecimal calcularTotal() {
        return pratos.stream().map(Prato::calcularPreco).reduce(new BigDecimal("0.00"), BigDecimal::add);
    }
}
