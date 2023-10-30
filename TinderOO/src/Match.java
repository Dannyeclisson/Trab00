public class Match extends UsuarioBase{
    private int idMatch;
    private boolean matchAceito;

    public Match(String nomeUsuario, String idadeUsuario, String biografiaUsuario, double alturaUsuario, String numeroUsuario, String sexoUsuario, int idMatch) {
        super(nomeUsuario, idadeUsuario, biografiaUsuario, alturaUsuario, numeroUsuario, sexoUsuario);
        this.idMatch = idMatch;
    }


    public String lerDados(){
        return "Nome do Match: " + nomeUsuario + "\nIdade do Match: " + idadeUsuario + "\nBiografia do Match: " + biografiaUsuario + "\nAltura do Match" + alturaUsuario + "\nNumero do Match: " + numeroUsuario + "\nSexo do Match: " + sexoUsuario;
    }
}
