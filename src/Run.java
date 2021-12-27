import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int id;
        MapHash mapa = new MapHash();
        int tamanho = 15;
        String ArqCaminho = "C:\\Users\\Regiana\\IdeaProjects\\ATV4_TabelaHash\\src\\dados.txt";
        String conteudo = read(ArqCaminho);
        String[] dados = new String[tamanho];
        for(int i = 0; i < tamanho;  i++){
                dados[i] = conteudo.split(";") [i];
        }

        Registro r;
        int indDados = 0;
        do {
            id = Integer.parseInt(conteudo.split(";") [indDados]);
            r = new Registro(id, dados[indDados+1], dados[indDados+2]);
            mapa.put(r);
            indDados = indDados + 3;
        }while(indDados < 15);
        int menu = 0;
        System.out.println("=== MENU ===");
        System.out.println("(1) Consultar ID.\n(2) Consultar informações do usuário.\nEntrada: ");
        menu = teclado.nextInt();
        switch (menu){
            case 1:
                System.out.println("\n");
                do {
                    System.out.println("===== CONSULTAR INFORMAÇÕES DO USUÁRIO =====");
                    System.out.print("Digite uma chave: ");
                    id = Integer.parseInt(teclado.next());
                    r = mapa.get(id);
                    if (id != -1) {
                        if (r != null) {
                            System.out.println("===== INFORMAÇÕES DO USUÁRIO =====");
                            System.out.println("ID = " + r.getKey());
                            System.out.println("Nome = " + r.getNome());
                            System.out.println("E-mail = " + r.getEmail()+"\n\n");
                        } else {
                            System.out.println("Não existe informações para esse ID.");
                        }
                    }
                }while (id != -1);
                break;
            case 2:

                System.out.println("\n");
                System.out.println("===== CONSULTAR ID =====");
                String ArqConsulta = "C:\\Users\\Regiana\\IdeaProjects\\ATV4_TabelaHash\\src\\consulta.txt";
                String conteudoConsulta = read(ArqConsulta);
                String dadoConsulta = conteudoConsulta.split(";") [1];
                id = Integer.parseInt(dadoConsulta);

        }

    }
    public static String read(String caminho){
        String conteudo = "";
        int contador = 0;
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }
}
