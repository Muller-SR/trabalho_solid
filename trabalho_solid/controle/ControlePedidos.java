package controle;

import modelo.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControlePedidos {
    private final List<Pedido> pedidos = new ArrayList<>();
    public void adicionar(Pedido pedido) {
        pedidos.add(Objects.requireNonNull(pedido));
    }

    public List<Pedido> porData(LocalDate data) {
        return pedidos.stream().filter(p -> p.getData().equals(data)).toList();
    }
}
