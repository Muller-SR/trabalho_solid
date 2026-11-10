package relatorio;

public class RelatorioConsole implements DestinoRelatorio {
    @Override
    public void enviar(String relatorio) {
        System.out.print(relatorio);
    }
}
