package modelo;

public record Cliente(String nome, String endereco, String telefone) {
    public Cliente {
        if (nome == null || nome.isBlank() || endereco == null || endereco.isBlank()
                || telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Nome, endereço e telefone são obrigatórios.");
        }
    }
}
