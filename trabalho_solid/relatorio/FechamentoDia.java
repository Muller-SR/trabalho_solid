package relatorio;

import controle.ControlePedidos;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Prato;

public class FechamentoDia {
    private final ControlePedidos controle;
    private final DestinoRelatorio destino;

    public FechamentoDia(ControlePedidos controle, DestinoRelatorio destino) {
        this.controle = Objects.requireNonNull(controle);
        this.destino = Objects.requireNonNull(destino);
    }

    public void fechar(LocalDate data) {
        List<Pedido> pedidos = controle.porData(Objects.requireNonNull(data));
        StringBuilder relatorio = new StringBuilder("\nFechamento do dia ").append(data).append('\n');
        BigDecimal faturamento = BigDecimal.ZERO.setScale(2);
        for (Pedido pedido : pedidos) {
            Cliente cliente = pedido.getCliente();
            relatorio.append("\nCliente: ").append(cliente.nome()).append(" | ")
                    .append(cliente.endereco()).append(" | ").append(cliente.telefone()).append('\n');
            for (Prato prato : pedido.getPratos()) {
                relatorio.append("  ").append(prato.getNome()).append(" - R$ ")
                        .append(prato.calcularPreco()).append('\n');
            }
            relatorio.append("Total do pedido: R$ ").append(pedido.calcularTotal()).append('\n');
            faturamento = faturamento.add(pedido.calcularTotal());
        }
        if (pedidos.isEmpty()) {
            relatorio.append("Nenhum pedido registrado neste dia.\n");
        }
        relatorio.append("\nFaturamento total: R$ ").append(faturamento).append('\n');
        pedidos.stream().max(Comparator.comparing(Pedido::calcularTotal)).ifPresent(pedido ->
                relatorio.append("Pedido mais caro: ").append(pedido.getCliente().nome())
                        .append(" - R$ ").append(pedido.calcularTotal()).append('\n'));
        destino.enviar(relatorio.toString());
    }
}
