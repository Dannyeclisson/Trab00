public class CartaoUsuario {
    private String numeroCartao;
    private String validadeCartao;
    private int numeroSeguranca;
    private String nomeNoCartao;
    private String bandeiraCartao;
    private String identificadorCartao;

    public CartaoUsuario(String numeroCartao, String validadeCartao, int numeroSeguranca, String nomeNoCartao, String bandeiraCartao, String identificadorCartao) {
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.numeroSeguranca = numeroSeguranca;
        this.nomeNoCartao = nomeNoCartao;
        this.bandeiraCartao = bandeiraCartao;
        this.identificadorCartao = identificadorCartao;
    }

    public void editarCartao(String numeroCartao, String validadeCartao, int numeroSeguranca, String nomeNoCartao, String bandeiraCartao, String identificadorCartao){
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.numeroSeguranca = numeroSeguranca;
        this.nomeNoCartao = nomeNoCartao;
        this.bandeiraCartao = bandeiraCartao;
        this.identificadorCartao = identificadorCartao;
    }


    public String toString() {
        return "CartaoUsuario{" +
                "numeroCartao='" + numeroCartao + '\'' +
                ", validadeCartao='" + validadeCartao + '\'' +
                ", numeroSeguranca=" + numeroSeguranca +
                ", nomeNoCartao='" + nomeNoCartao + '\'' +
                ", bandeiraCartao='" + bandeiraCartao + '\'' +
                ", identificadorCartao='" + identificadorCartao + '\'' +
                '}';
    }
}
