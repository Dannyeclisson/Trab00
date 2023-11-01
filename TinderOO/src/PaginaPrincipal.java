import java.util.ArrayList;
import java.util.List;
public class PaginaPrincipal {
    private Usuario u;
    private int numMatches = 0;
    private Match[] matches;


    public String listarUsuarios() {
        String saida = "***** Lista de Matches ***** \n" ;
        for(int i = 0; i < numMatches; i++) {
            System.out.println(i);
            saida = saida + "\n"+ matches[i].lerDados();
        }
        return saida;
    }

}
