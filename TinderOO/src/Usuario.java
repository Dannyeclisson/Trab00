import java.util.Scanner;
public class Usuario extends UsuarioBase{
    private boolean tipoAssinatura;

    private AssinaturaPlatinum aP;
    private String preferenciaIdade;
    private String preferenciaGenero;
    private String likesUsuario;
    private CartaoUsuario cartaousuario;

    private boolean possuiCartao = false;

    Scanner scanner = new Scanner(System.in);

    public Usuario(String nomeUsuario, String idadeUsuario, String biografiaUsuario, String alturaUsuario, String numeroUsuario, String sexoUsuario, String preferenciaIdade, String preferenciaGenero) {
        super(nomeUsuario, idadeUsuario, biografiaUsuario, alturaUsuario, numeroUsuario, sexoUsuario);
        this.preferenciaGenero = preferenciaGenero;
        this.preferenciaIdade = preferenciaIdade;
        this.aP = new AssinaturaPlatinum();
    }


    public void setPreferenciaIdade(String preferenciaIdade) {
        this.preferenciaIdade = preferenciaIdade;
    }

    public void setPreferenciaGenero(String preferenciaGenero) {
        this.preferenciaGenero = preferenciaGenero;
    }

    public boolean getPossuiCartao(){
        return possuiCartao;
    }

    public void setPossuiCartao(boolean possuiCartao){
        this.possuiCartao = possuiCartao;
    }
    public void deletarConta(){

    }

    public void cadastrarCartao() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, forneça os detalhes do cartão do usuário:");

        System.out.print("Número do Cartão: ");
        String numeroCartao = scanner.nextLine();

        System.out.print("Validade do Cartão: ");
        String validadeCartao = scanner.nextLine();

        System.out.print("Número de Segurança: ");
        int numeroSeguranca = scanner.nextInt();
        scanner.nextLine(); // Limpar a quebra de linha

        System.out.print("Nome no Cartão: ");
        String nomeNoCartao = scanner.nextLine();

        System.out.print("Bandeira do Cartão: ");
        String bandeiraCartao = scanner.nextLine();

        System.out.print("Identificador do Cartão: ");
        String identificadorCartao = scanner.nextLine();

        cartaousuario = new CartaoUsuario(numeroCartao, validadeCartao, numeroSeguranca, nomeNoCartao, bandeiraCartao, identificadorCartao);
    }

    public void solicitarCadastroCartao() {
        cadastrarCartao();
    }

    public void apagarCartao(){
        this.cartaousuario = null;
    }

    public void comprarAssinaturaCartao(){
        if(getPossuiCartao()){
            aP.ativarRecursoPremium();

        } else{
            System.out.println("Você precisa ter um cartão cadastrado para pagar a assinatura!");
        }
    }

    public void cancelarAssinatura(){
        if(!possuiAssinatura()){
            System.out.println("Não há assinatura para ser cancelada!");
        }else{
            aP.cancelarRecursoPremium();

        }
    }



    public CartaoUsuario getCartao() {
        return cartaousuario;
    }

    public boolean possuiAssinatura(){
        return aP.getAssinaturaAtivada();
    }

    public String getNomeUsuario(){
        return nomeUsuario;
    }

    public String mostrarDescricaoAssinatura(){
        return aP.detalharAssinatura();
    }

    public String mudarTipoAssinatura(){//Utilizado apenas no getInformacoesUsuario para alterar o tipo de assinatura de "false" ou "true" para "tem assinatura" ou "nao tem assinatura."
        if (aP.getAssinaturaAtivada()){
            return "Tem assinatura" ;
        }else{
            return "Nao tem assinatura";
        }
    }
    public String getInformacoesUsuario() {
        return "Nome do Usuario: " + nomeUsuario + "\n" +
                "Tipo de Assinatura: " + mudarTipoAssinatura() + "\n" +
                "Preferencia de Idade: " + preferenciaIdade + "\n" +
                "Preferencia de Genero: " + preferenciaGenero + "\n" +
                "Idade do Usuario: " + idadeUsuario + "\n" +
                "Biografia do Usuario: " + biografiaUsuario + "\n" +
                "Altura do Usuario: " + alturaUsuario + "\n" +
                "Numero do Usuario: " + numeroUsuario + "\n" +
                "Sexo do Usuario: " + sexoUsuario + "\n";
    }
}
