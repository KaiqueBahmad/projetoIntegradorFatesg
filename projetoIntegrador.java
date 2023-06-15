package projetointegrador;
import java.util.Arrays;
import java.util.Scanner;

public class ProjetoIntegrador {
   
    //Dentro de uma sessão
    // 0 : Não Alocado;
    // 1 : Disponível;
    // 2 : Ocupada;
    public static void main(String[] args) {
        int cinema[][][][] = new int[32][16][64][64];
        String sessões[][] = new String[32][16];
        String ingressos[][] = new String[32*16][3];
        String filmes[] = new String[128];
        // Ingresso = ["123909321", "meia"/"inteira", "2.3", "A13"]
        Scanner leitor = new Scanner(System.in);
        for (int i = 0; i < 64; i++) {
            System.out.println(Arrays.toString(cinema[0][0][i]));
        }
        boolean admin = false;
        while (true) {
            String opção = leitor.nextLine();
            if (!admin) {
                System.out.println("");
                System.out.println("ESCOLHA UMA OPÇÂO: ");
                System.out.println("1 - COMPRAR UM INGRESSO");
                System.out.println("2 - IMPRIMIR INGRESSO");
                System.out.println("");
            }
            if ("1".equals(opção) && !admin) {
                newRoom(cinema, leitor);
            }
            if ("2".equals(opção) && !admin) {
               
            }
            
            if (admin) {
                System.out.println("");
                System.out.println("ESCOLHA UMA OPÇÂO: ");
                System.out.println("1 - CADASTRAR FILME");
                System.out.println("2 - CADASTRAR SALA");
                System.out.println("3 - SELECIONAR SALA");
                System.out.println("0 - VOLTAR AO MODO PARA CLIENTES");
            }
            
            if ("1".equals(opção) && admin) {
                System.out.println("Insira o nome do filme: ");
                String filmeNome = leitor.nextLine();
                boolean alreadyThere = false;
                for (int i = 0; i < filmes.length; i++) {
                    if (filmes[i].equals(filmeNome)) {
                        alreadyThere = true;
                    }
                }
                if (alreadyThere) {
                    filmeNome = "";
                }
                for (int i = 0; i < filmes.length; i++) {
                    if (filmes[i].equals("")) {
                        filmes[i] = filmeNome;
                    }
                }
                
            }
            
            if ("2".equals(opção) && admin) {
                newRoom(cinema, leitor);
            }
            
            if ("3".equals(opção) && admin) {
                System.out.println("Selecione uma Sala (-1 para voltar)");
                listRooms(cinema);
            }
            if ("0".equals(opção) && admin) {
                admin = false;
            }
            
            if ("admin".equalsIgnoreCase(opção) && !admin) {
                System.out.println("Insira a senha: ");
                String pass = leitor.nextLine();
                if ("admin".equals(pass)) {
                    
                }
            }
        }
    }
   
    public static void listRooms(int[][][][] cinema) {
    }
   
    public static void newRoom(int[][][][] cinema, Scanner leitor) {
        System.out.println("Insira a quantidade de Fileiras na Sala: ");
        int heigth = Integer.parseInt(leitor.nextLine());
        System.out.println("Insira a quantidade de Assentos por Fileira: ");
        int width = Integer.parseInt(leitor.nextLine());
        for (int i = 0; i < cinema.length; i++) {
            if (roomIsUnused(cinema, i)) {
                System.out.println(i);
                for (int j = 0; j < cinema[i].length; j++) {
                    for (int h = 0; h < heigth; h++) {
                        for (int w = 0; w < width; w++) {
                            cinema[i][j][h][w] = 1;
                        }
                    }
                }
                break;
            }
        }
    }
   
    public static boolean roomIsUnused(int cinema[][][][], int index) {
        boolean isEmpty = true;
        for (int i = 0; i < cinema[index].length; i++) {
            for (int j = 0; j < cinema[index][i].length; j++) {
                for (int k = 0; k < cinema[index][i][j].length; k++) {
                    if (cinema[index][i][j][k] != 0) {
                        isEmpty = false;
                    }
                }
            }
        }
        return isEmpty;
    }

}
        /*
    public static void selectRoom() {
   
    }
    public static void deleteSelectedRoom() {
   
    }*/

   
	
