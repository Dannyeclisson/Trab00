public class CartaoUsuario {
    private String numeroCartao;
    private String validadeCartao;
    private int numeroSeguranca;
    private String nomeNoCartao;
    private String bandeiraCartao;

    public CartaoUsuario(String numeroCartao, String validadeCartao, int numeroSeguranca, String nomeNoCartao, String bandeiraCartao, String identificadorCartao) {
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.numeroSeguranca = numeroSeguranca;
        this.nomeNoCartao = nomeNoCartao;
        this.bandeiraCartao = bandeiraCartao;
    }

    public void editarCartao(String numeroCartao, String validadeCartao, int numeroSeguranca, String nomeNoCartao, String bandeiraCartao){
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.numeroSeguranca = numeroSeguranca;
        this.nomeNoCartao = nomeNoCartao;
        this.bandeiraCartao = bandeiraCartao;

    }


    public String toString() {
        return  "Numero do cartao: " +
                numeroCartao + "\n" +
                "Validade do cartao: " +
                validadeCartao + "\n" +
                "Numero de seguranca: " +
                numeroSeguranca + "\n" +
                "Nome no cartao: " +
                nomeNoCartao + "\n"+
                "Bandeira do cartao: " +
                bandeiraCartao + "\n";

    }
}
