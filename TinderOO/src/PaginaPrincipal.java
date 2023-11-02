import java.util.Scanner;

public class PaginaPrincipal {
    private Usuario u;
    private Match[] matches;



    private Match[] listaMatchesAceitos;
    private int numMatchesAceitos = 0;
    private static Dados dados;
    private int numMatches = 0; // Variável para controlar o próximo Match a ser exibido

    public static void limparTela() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }

    public static void pausarAntesDeLimpar() {
        System.out.println("Pressione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        limparTela();
    }

    public PaginaPrincipal() {
        dados = new Dados();
        dados.preencherDados();
        matches = dados.getMatches();
        listaMatchesAceitos = new Match[10];
    }

    public String listarMatches() {
        String saida = "***** Lista de Matches *****\n";

        for (int i = 0; i < dados.getnMatches(); i++) {
            saida = saida + "\n" + matches[i].lerDados();
        }

        return saida;
    }

    public void criarCartao() {
        Usuario usuario = dados.getUsuario();
        if (!usuario.getPossuiCartao()) {
            System.out.println("Você deseja criar um cartão? (Sim/Não)");
            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("Sim")) {
                usuario.solicitarCadastroCartao();
                CartaoUsuario cartaoDoUsuario = usuario.getCartao();
                usuario.setPossuiCartao(true);
                limparTela();
                System.out.println("Cartão criado com sucesso:");
                System.out.println(cartaoDoUsuario.toString());
                pausarAntesDeLimpar();
            } else {
                System.out.println("Operação cancelada.");
            }
        } else {
            System.out.println("Você já tem um cartão cadastrado!");
        }
    }

    public void apagarCartao() {
        Usuario usuario = dados.getUsuario();
        if(usuario.getPossuiCartao()) {
            usuario.apagarCartao();
            usuario.setPossuiCartao(false);
            pausarAntesDeLimpar();
        }else{
            limparTela();
            System.out.println("\nVocê não possui cartões para apagar!");
            pausarAntesDeLimpar();
        }
    }

    public void configuracoesUsuario() {
        Usuario usuario = dados.getUsuario();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Configurações de Usuário");
        System.out.println("1. Alterar idade");
        System.out.println("2. Alterar biografia");
        System.out.println("3. Alterar altura");
        System.out.println("4. Alterar número de telefone");
        System.out.println("5. Alterar preferência de idade");
        System.out.println("6. Alterar preferência de gênero");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.print("Nova idade: ");
                String novaIdade = scanner.next();
                usuario.setIdadeUsuario(novaIdade);
                break;
            case 2:
                System.out.print("Nova biografia: ");
                String novaBiografia = scanner.next();
                usuario.setBiografiaUsuario(novaBiografia);
                break;
            case 3:
                System.out.print("Nova altura: ");
                String novaAltura = scanner.next();
                usuario.setAlturaUsuario(novaAltura);
                break;
            case 4:
                System.out.print("Novo número de telefone: ");
                String novoNumero = scanner.next();
                usuario.setNumeroUsuario(novoNumero);
                break;
            case 5:
                System.out.print("Nova preferência de idade: ");
                String novaPreferenciaIdade = scanner.next();
                usuario.setPreferenciaIdade(novaPreferenciaIdade);
                break;
            case 6:
                System.out.print("Nova preferência de gênero: ");
                String novaPreferenciaGenero = scanner.next();
                usuario.setPreferenciaGenero(novaPreferenciaGenero);
                break;
            default:
                System.out.println("Escolha inválida.");
        }
        pausarAntesDeLimpar();
    }

    public void proximoMatch() {
        Match[] listaMatches = dados.getMatches();
        int totalMatches = dados.getnMatches();

        if (totalMatches > 0) {
            if (numMatches < totalMatches) {
                Match proximoMatch = listaMatches[numMatches];

                System.out.println("Próximo Match:\n\n");
                System.out.println(proximoMatch.lerDados());
                numMatches++; // Atualiza o índice para o próximo Match
            } else {
                System.out.println("Você já visualizou todos os Matches disponíveis.");
            }
        } else {
            System.out.println("Nenhum Match disponível.");
        }
    }

    public void darMatch() {
        Match[] listaMatches = dados.getMatches();
        int totalMatches = dados.getnMatches();

        if (totalMatches > 0) {
            if (numMatches > 0 && numMatches <= totalMatches) {
                // Defina o estado de matchAceito para true no Match atual
                listaMatches[numMatches - 1].setMatchAceito(true);

                // Adicione o Match aceito à lista de Matches aceitos
                listaMatchesAceitos[numMatchesAceitos] = listaMatches[numMatches - 1];
                numMatchesAceitos++;

                System.out.println("Você deu Match com o Match atual!");
            } else {
                System.out.println("Não há Match disponível para dar Match.");
            }
        } else {
            System.out.println("Nenhum Match disponível para dar Match.");
        }
    }

    public void cancelarMatch() {
        if (numMatchesAceitos == 0) {
            System.out.println("Você não possui nenhum Match aceito para cancelar.");
        } else {
            System.out.println("Lista de Matches Aceitos:");
            for (int i = 0; i < numMatchesAceitos; i++) {
                System.out.println((i + 1) + ". " + listaMatchesAceitos[i].lerDados());
            }

            System.out.print("Selecione o número do Match a ser cancelado: ");
            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();

            if (escolha >= 1 && escolha <= numMatchesAceitos) {
                int index = escolha - 1;
                listaMatchesAceitos[index].cancelarMatch();
                // remove o match cancelado do array e movee os elementos restantes para preencher o espaçoçs
                for (int i = index; i < numMatchesAceitos - 1; i++) {
                    listaMatchesAceitos[i] = listaMatchesAceitos[i + 1];
                }
                listaMatchesAceitos[numMatchesAceitos - 1] = null;
                numMatchesAceitos--;
                System.out.println("Match cancelado com sucesso.");
            } else {
                System.out.println("Escolha inválida.");
            }
        }
    }



    public void menuMatches() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        // Exibe o primeiro próximoMatch
        limparTela();
        proximoMatch();

        while (!sair) {
            System.out.println("Opções de Matches:");
            System.out.println("1. Próximo Match");
            System.out.println("2. Dar Match");
            System.out.println("3. Cancelar um Match");
            System.out.println("4. Voltar");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    limparTela();
                    proximoMatch();
                    break;
                case 2:
                    darMatch();
                    pausarAntesDeLimpar();
                    break;

                case 3:
                    cancelarMatch();
                    pausarAntesDeLimpar();
                    break;
                case 4:
                    sair = true;
                    limparTela();
                    break;

                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }


    public String verificarMatchesUsuario(){
        Match[] listamatches = dados.getMatches();
        StringBuilder resultado = new StringBuilder();

        for(int i = 0; i<10; i++){
            if (listamatches[i].matchAceito()){ //==true
                resultado.append(listamatches[i].lerDados());
                resultado.append("\n");
                limparTela();

            }
        }

        return resultado.toString();

    }

    public static void main(String[] args) {
        PaginaPrincipal pagina = new PaginaPrincipal();

        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        while (!sair) {
            System.out.println("Bem-vindo ao seu perfil de usuário!");
            System.out.println("Opções:");
            System.out.println("1. Configurações de usuário");
            System.out.println("2. Criar cartão");
            System.out.println("3. Deletar cartão");
            System.out.println("4. Matches");
            System.out.println("5. Verificar Matches do Usuario");
            System.out.println("6. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    pagina.configuracoesUsuario();
                    break;
                case 2:
                    pagina.criarCartao();
                    break;
                case 3:
                    pagina.apagarCartao();
                    break;
                case 4:
                    limparTela();
                    pagina.menuMatches();
                    break;

                case 5:
                    String matchesUsuario2 = pagina.verificarMatchesUsuario();
                    System.out.println(matchesUsuario2);
                    pausarAntesDeLimpar();
                    break;

                case 6:
                    sair = true;
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }
}
