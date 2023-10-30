public class AssinaturaPlatinum {
    private double preco3Meses;
    private double preco6Meses;
    private double preco12Meses;
    private int duracaoAssinatura;
    private String descricaoAssinatura;


    public AssinaturaPlatinum(int duracaoAssinatura) {
        this.duracaoAssinatura = duracaoAssinatura;
    }

    public void setDuracaoAssinatura(int duracaoAssinatura) {
        this.duracaoAssinatura = duracaoAssinatura;
    }

    public void setDescricaoAssinatura(String descricaoAssinatura) {
        this.descricaoAssinatura = descricaoAssinatura;
    }

    public String detalharAssinatura(){
        return descricaoAssinatura;
    }
}
