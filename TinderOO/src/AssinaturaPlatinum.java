public class AssinaturaPlatinum {


    private String descricaoAssinatura = "Pague uma assinatura para conseguir voltar à matches anteriores!\n Preco: R$29,90 P/Mes \n ";


    private boolean assinaturaAtivada;

    public AssinaturaPlatinum() {

        this.assinaturaAtivada = false;
    }


    public String detalharAssinatura(){
        return descricaoAssinatura;
    }

    public void ativarRecursoPremium(){

        this.assinaturaAtivada = true;
        System.out.println("Assinatura Platinum pagae e ativada com sucesso!");
    }

    public void cancelarRecursoPremium(){

        this.assinaturaAtivada = false;
        System.out.println("Assinatura Platinum cancelada!");
    }

    public boolean getAssinaturaAtivada(){
        return assinaturaAtivada;
    }
}
