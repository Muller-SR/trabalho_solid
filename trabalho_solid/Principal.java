import controle.ControlePedidos;
import java.math.BigDecimal;
import java.time.LocalDate;
import modelo.Cliente;
import modelo.Combo;
import modelo.Pedido;
import modelo.PratoExecutivo;
import modelo.PratoEspecial;
import relatorio.FechamentoDia;
import relatorio.RelatorioConsole;

public class Principal {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        ControlePedidos controle = new ControlePedidos();

        Cliente ana = new Cliente("Ana Silva", "Rua das Flores, 10", "11999990001");
        Cliente bruno = new Cliente("Bruno Souza", "Rua do Sol, 25", "11999990002");

        Pedido pedidoAna = new Pedido(ana, hoje);
        pedidoAna.adicionarPrato(new PratoExecutivo("Executivo", new BigDecimal("30.00"), 20));
        pedidoAna.adicionarPrato(new Combo("Combo", new BigDecimal("40.00"), 25));
        controle.adicionar(pedidoAna);

        Pedido pedidoBruno = new Pedido(bruno, hoje);
        pedidoBruno.adicionarPrato(new PratoEspecial("Especial", new BigDecimal("50.00"), 30,
                new BigDecimal("15.00")));
        controle.adicionar(pedidoBruno);

        new FechamentoDia(controle, new RelatorioConsole()).fechar(hoje);
    }
}
