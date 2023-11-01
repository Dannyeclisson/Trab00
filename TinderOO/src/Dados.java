public class Dados {

        private Usuario[] usuarios;
        private int nUsuarios = 0;
        private Match[] matches;
        private int nMatches = 0;

        public Dados() {
            usuarios = new Usuario[100];
            matches = new Match[50];
        }




        public Match[] getMatches() {
            return matches;
        }

            public Match getMatch(int i) {
            return matches[i];
        }

        public String[] getNomeMatch() {
            String[] s = new String[nMatches];
            for(int i = 0; i < nMatches; i++) {
                s[i] = matches[i].getNomeMatch();
            }
            return s;
        }

        public void setMatch(Match[] matches) {
            this.matches = matches;
        }

        public void setMatches(int i, Match m) {
            matches[i] = m;
        }

        public int getnMatches() {
            return nMatches;
        }

        public void setnMatches(int nMatches) {
            this.nMatches = nMatches;
        }





    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuario(int i) {
        return usuarios[i];
    }

    public String[] getNomeUsuario() {
        String[] s = new String[nUsuarios];
        for(int i = 0; i < nUsuarios; i++) {
            s[i] = usuarios[i].getNomeUsuario();
        }
        return s;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public void setUsuario(int i, Usuario u) {
        usuarios[i] = u;
    }

    public int getnUsuarios() {
        return nUsuarios;
    }

    public void setnUsuarios(int nUsuarios) {
        this.nUsuarios = nUsuarios;
    }




    public void preencherDados() {
            for(int i = 0; i < 10; i++) {
                String s = String.valueOf(i);
                usuarios[i] = new Usuario("Usuario".concat(s), "Idade".concat(s), "Biografia".concat(s),
                        "Altura".concat(s), "Numero do Usuario".concat(s), "Sexo".concat(s), "Preferencia de Idade".concat(s), "Preferencia de Genero".concat(s));
                matches[i] = new Match("Match".concat(s), "Idade".concat(s), "Biografia".concat(s),
                        "Altura do Match".concat(s), "Numero do Match".concat(s), "Sexo do Match".concat(s), "IdMatch".concat(s));

            }
            nUsuarios = nMatches = 10;
        }


}
