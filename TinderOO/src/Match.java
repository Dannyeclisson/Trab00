public class Match extends UsuarioBase{
    private String idMatch;



    private boolean matchAceito;

    public Match(String nomeUsuario, String idadeUsuario, String biografiaUsuario, String alturaUsuario, String numeroUsuario, String sexoUsuario, String idMatch) {
        super(nomeUsuario, idadeUsuario, biografiaUsuario, alturaUsuario, numeroUsuario, sexoUsuario);
        this.idMatch = idMatch;
    }


    public String lerDados(){
        return "Nome do Match: " + nomeUsuario + "\nIdade do Match: " + idadeUsuario + "\nBiografia do Match: " + biografiaUsuario + "\nAltura do Match" + alturaUsuario + "\nNumero do Match: " + numeroUsuario + "\nSexo do Match: " + sexoUsuario +"\n\n";
    }

    public void setMatchAceito(boolean matchAceito) {
        this.matchAceito = matchAceito;
    }

    public boolean matchAceito(){
        return matchAceito;
    }

    public void cancelarMatch(){
        this.matchAceito = false;
    }

    public void apagarContar(){
    }

    public String getNomeMatch(){
        return nomeUsuario;
    }
}
