package view;

import java.io.IOException;
import util.Helper;
import view.screens.*;

public class Menu extends Helper {

    // Concistência do tipo de interface: Baixa, há formas melhores de se fazer.
    // Se tiver uma forma melhor crie uma branch, faça e então dê Merge Request.

    // Métodos ajudantes -->

    protected static void titulo() {

        // Apaga o console:
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        // Apresenta título:
        println("----- PokePedia -----\n\n");
    }

    protected static int lerOpcao() {

        // !Este método só pode ser usado para pegar uma opção de menu do usuário!

        // Pega um número do usuário:
        print("Digite uma opção: ");
        int aux = nextInt();

        // Limpa o Flush:
        nextLine();

        return aux;
    }

    // <-- Métodos ajudantes

    // Métodos de tela -->

    // Primeira tela:
    public static void home() {

        do {
            titulo();
            println("1. Login   ||   2. Cadastrar   ||   0. Sair");
            int opcao = lerOpcao();

            switch (opcao) {
            case 1:
                login();
                return;
            case 2:
                cadastrar();
                return;
            case 0:
                return;
            default:
                break;
            }
        } while (true);
    }

    // Tela de login:
    private static void login() {
        titulo();

        print("Nome de usuário: ");
        String nome = nextLine();

        {
            // Verifica se o nome existe no BD;
        }

        print("Senha: ");
        String senha = nextLine();

        {
            // Verifica se a senha está certa;
        }

        {
            // Se usuário:
            //homeUsuario();

            // Se admin:
            homeAdmin();
        }
    }

    // Tela de cadastro:
    private static void cadastrar() {

        titulo();

        print("Nome de usuário: ");
        String nome = nextLine();

        {
            // Verifica se o nome já existe no BD;
        }

        print("Senha: ");
        String senha = nextLine();

        {
            // Adiciona o usuário no banco;
        }

        homeUsuario();
    }

    // Primeira tela do usuário comum após login ou cadasto:
    protected static void homeUsuario() {

        do {
            titulo();
            println("1. Listar   ||   2. Pesquisar   ||   0. Voltar");
            int opcao = lerOpcao();

            switch (opcao) {
            case 1:
                Listar.home("usuario");
                return;
            case 2:
                Pesquisar.home("usuario");
                return;
            case 0:
                home();
                return;
            default:
                break;
            }
        } while (true);
    }

    // Primeira tela do usuário administrador após login:
    protected static void homeAdmin() {

        // Não está pronto ainda...

        do {
            titulo();
            println("1. Listar   ||   2. Pesquisar   ||   3. Adicionar   ||   4. Remover   ||   5. Atualizar   ||   6. Cadastrar   ||   0. Voltar");
            int opcao = lerOpcao();

            switch (opcao) {
            case 1:
                Listar.home("admin");
                return;
            case 2:
                Pesquisar.home("admin");
                return;
            case 3:
                Adicionar.home();
                return;
            case 4:
                return;
            case 5:
                return;
            case 6:
                return;
            case 0:
                home();
                return;
            default:
                break;
            }
        } while (true);
    }
    // <-- Métodos de tela
}