public class Usuario extends UsuarioBase{
    private boolean tipoAssinatura;
    private String preferenciaIdade;
    private String preferenciaGenero;
    private String likesUsuario;
    private CartaoUsuario cartaousuario;


    public Usuario(String nomeUsuario, String idadeUsuario, String biografiaUsuario, String alturaUsuario, String numeroUsuario, String sexoUsuario, String preferenciaIdade, String preferenciaGenero) {
        super(nomeUsuario, idadeUsuario, biografiaUsuario, alturaUsuario, numeroUsuario, sexoUsuario);
        this.preferenciaGenero = preferenciaGenero;
        this.preferenciaIdade = preferenciaIdade;
    }

    public void setPreferenciaIdade(String preferenciaIdade) {
        this.preferenciaIdade = preferenciaIdade;
    }

    public void setPreferenciaGenero(String preferenciaGenero) {
        this.preferenciaGenero = preferenciaGenero;
    }

    public void deletarConta(){

    }

    public String getNomeUsuario(){
        return nomeUsuario;
    }

}
