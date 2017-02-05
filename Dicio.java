package hashpkg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Dicio {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
//Método Através Do Console
		
		/* Scanner qp = new Scanner(System.in);
		System.out.print("Digite a quantidade de palavras que o dicionário terá: ");
		int quantPalavras = qp.nextInt();

		String[] dicionario = new String[quantPalavras];
		Scanner dicioScan = new Scanner(System.in);
		for (int i = 0; i < quantPalavras; i++) {
			System.out.print("Digite a " + (i + 1) + "ª palavra do dicionário: ");
			dicionario[i] = dicioScan.nextLine();
		}

		HashSet<String> tabelaHash = new HashSet<String>();
		for (int i = 0; i < quantPalavras; i++) {
			tabelaHash.add(dicionario[i]);
		}

		String texto;
		System.out.println("\nDigite o texto");
		Scanner scanner = new Scanner(System.in);
		texto = scanner.nextLine();

		String[] textoDiv = texto.split(" ");
		int cont = textoDiv.length - 1;

//Método Através De Arquivos NIO2
		
		Scanner scanner = new Scanner(System.in);
		String[] dicionario;
		String texto = "";
		
		Path pathDicio = Paths.get("C:\\Users\\Rodri\\workspace\\Hash\\src\\hashpkg\\TesteDePalavras.txt");
		Path pathTexto = Paths.get("C:\\Users\\Rodri\\workspace\\Hash\\src\\hashpkg\\TesteDeTexto.txt");
		byte[] bytesT = Files.readAllBytes(pathTexto);
		byte[] bytesD = Files.readAllBytes(pathDicio);
		
		String palavrasDicioTemp = "";
		for (byte b : bytesD) {
			char textoc = ((char) b);
			palavrasDicioTemp = palavrasDicioTemp + textoc;
		}
		dicionario = palavrasDicioTemp.split(" ");
		int contD = dicionario.length - 1;
		
		HashSet<String> tabelaHash = new HashSet<String>();
		for (int i = 0; i < contD; i++) {
			tabelaHash.add(dicionario[i]);
		}
		
	    for (byte b : bytesT) {
	    	//System.out.print((char) b);
	    	char textoc = ((char) b);
	    	texto = texto + textoc;
	    }
		String[] textoDiv = texto.split(" ");
		int contT = textoDiv.length - 1; */
		
//Método Através De Arquivos Java.io
		
		//ler um arquivo e imprimir na tela
		
		//InputStream lerD = new FileInputStream("C:\\Users\\Rodri\\workspace\\Hash\\src\\hashpkg\\TesteDePalavras.txt");
		//Scanner inD = new Scanner(lerD);
		//while (inD.hasNextLine()) {
			//System.out.println(inD.nextLine());
		//}
		
		Scanner scanner = new Scanner(System.in);
		BufferedReader stringD = new BufferedReader(new InputStreamReader (new FileInputStream ("C:\\Users\\Rodri\\workspace\\Hash\\src\\hashpkg\\TesteDePalavras.txt")));
		String tempD = stringD.readLine();
	    String[] dicionario = tempD.split(";");
		int contD = dicionario.length - 1;
		System.out.println("- Palavras do Dicionário:\n");
		for (int i = 0; i <= contD; i++){
			System.out.println(dicionario[i]);
		}

		HashSet<String> tabelaHash = new HashSet<String>();
		for (int i = 0; i <= contD; i++) {
			tabelaHash.add(dicionario[i]);
		}

		BufferedReader stringT = new BufferedReader(new InputStreamReader (new FileInputStream ("C:\\Users\\Rodri\\workspace\\Hash\\src\\hashpkg\\TesteDeTexto.txt")));
		String tempT = stringT.readLine();
	    String[] textoDiv = tempT.split(" ");
		int contT = textoDiv.length - 1;
		System.out.println("\n- Palavras do Texto:\n");
		for (int i = 0; i <= contT; i++){
			System.out.println(textoDiv[i]);
		}

	    //inD.close();
	    stringT.close();

// Troca de adjacentes

		for (int i = 0; i <= contT; i++) {
			char[] palavraChar = textoDiv[i].toCharArray();
			if (tabelaHash.contains(textoDiv[i]) == false) {
				if (palavraChar.length > 1) {
					for (int j = 0; j < palavraChar.length - 1; j++) {
						char temp;
						palavraChar = textoDiv[i].toCharArray();
						temp = palavraChar[j];
						palavraChar[j] = palavraChar[j + 1];
						palavraChar[j + 1] = temp;
						String palavra = String.valueOf(palavraChar);
						if (tabelaHash.contains(palavra) == true) {
							System.out.println("\nDeseja corrigir a palavra \"" + textoDiv[i] + "\" para \"" + palavra + "\"? (s / n)");
							String resposta = scanner.nextLine();
							String respUp = resposta.toUpperCase();
							if (respUp.equals("S")) {
								textoDiv[i] = palavra;
								break;
							}
						}
					}
				}
			}
		}

// Troca de letra

		char[] letras = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i <= contT; i++) {
			char[] palavraChar = textoDiv[i].toCharArray();
			if (tabelaHash.contains(textoDiv[i]) == false) {
				if (palavraChar.length > 1) {
					for (int j = 0; j < palavraChar.length; j++) {
						palavraChar = textoDiv[i].toCharArray();
						if (tabelaHash.contains(textoDiv[i]) == false) {
							for (int k = 0; k < 26; k++) {
								char[] temp = palavraChar;
								temp[j] = letras[k];
								String palavra = String.valueOf(temp);
								if (tabelaHash.contains(palavra) == true) {
									System.out.println("\nDeseja corrigir a palavra \"" + textoDiv[i] + "\" para \"" + palavra + "\"? (s / n)");
									String resposta = scanner.nextLine();
									String respUp = resposta.toUpperCase();
									if (respUp.equals("S")) {
										textoDiv[i] = palavra;
										break;
									} else {
										break;
									}
								}
							}
						}
					}
				}
			}
		}

// Inserindo letras

		for (int i = 0; i <= contT; i++) {
			for (int separador = 0; separador <= textoDiv[i].length(); separador++) {
				if (tabelaHash.contains(textoDiv[i]) == false) {
					String palavra;
					for (char alfabeto = 'a'; alfabeto <= 'z'; alfabeto++) {
						palavra = "";
						palavra = textoDiv[i].substring(0, separador) + alfabeto + textoDiv[i].substring(separador);
						if (tabelaHash.contains(palavra) == true) {
							System.out.println("\nDeseja corrigir a palavra \"" + textoDiv[i] + "\" para \"" + palavra + "\"? (s / n)");
							String resposta = scanner.nextLine();
							String respUp = resposta.toUpperCase();
							if (respUp.equals("S")) {
								textoDiv[i] = palavra;
								break;
							}
						}
					}
				}
			}
		}

// Excluindo letras

		for (int i = 0; i <= contT; i++) {
			char[] palavraChar = textoDiv[i].toCharArray();
			if (tabelaHash.contains(textoDiv[i]) == false) {
				if (palavraChar.length > 1) {
					for (int j = 0; j < palavraChar.length; j++) {
						palavraChar = textoDiv[i].toCharArray();
						palavraChar[j] = ' ';
						String palavra = String.valueOf(palavraChar);
						palavra = palavra.replaceAll(" ", "");
						if (tabelaHash.contains(palavra) == true) {
							System.out.println("\nDeseja corrigir a palavra \"" + textoDiv[i] + "\" para \"" + palavra + "\"? (s / n)");
							String resposta = scanner.nextLine();
							String respUp = resposta.toUpperCase();
							if (respUp.equals("S")) {
								textoDiv[i] = palavra;
								break;
							}
						}
					}
				}
			}
		}

		String novoTexto = Arrays.toString(textoDiv);
		novoTexto = novoTexto.substring(1, novoTexto.length() - 1);
		novoTexto = novoTexto.replaceAll(",", "");

		System.out.println("\nTexto corrigido:\n\n" + novoTexto);
	}
}