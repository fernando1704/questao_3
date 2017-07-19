package desafio_questao_3;

public class Questao3 {

    public static void main(String[] args) {
        Stream input = new StringStream("aAbBABacafe");
        System.out.println("Primeira vogal que safisfaça os critérios => "+ Questao3.firstChar(input));
    }

    public static char firstChar(Stream input) {

        char caractereAtual;
        char primeiroCaractere = 0;
        int indice;
        int controle = 0;
        char[] caracteresAnteriores = new char[]{' ', ' '};
        char[] vogaisEncontradas = new char[5];
        short[] quantidadeCharsRepetidos = new short[5];

        while (input.hasNext()) {
            caractereAtual = input.getNext();

            //Verifica se o caractere atual é vogal
            if (verificaVogal(caractereAtual)) {

                indice = procuraIndice(caractereAtual, vogaisEncontradas);

                if (indice >= 0) {
                    
                    quantidadeCharsRepetidos[indice]++;
                } else {
                    //Verifica se o caracter anterior é uma consoante e o anterior a ele uma vogal
                    if ((caracteresAnteriores[0] != ' ' && !verificaVogal(caracteresAnteriores[0]))
                            && (caracteresAnteriores[1] != ' ' && verificaVogal(caracteresAnteriores[1]))) {
                        vogaisEncontradas[controle] = caractereAtual;
                        
                        quantidadeCharsRepetidos[controle]++;
                        controle++;
                    }                    
                }
            }

            if (caracteresAnteriores[0] == ' ' && caracteresAnteriores[1] == ' ') {
                caracteresAnteriores[0] = caractereAtual;
            } else {
                caracteresAnteriores[1] = caracteresAnteriores[0];
                caracteresAnteriores[0] = caractereAtual;
            }
        }
        //Procura o primeiro nao repetido
        int primeiroIndice = -1;
        for (int i = 0; i < quantidadeCharsRepetidos.length; i++) {
            //System.out.println(quantidadeCharsRepetidos[i]);
            if (quantidadeCharsRepetidos[i] == 1) {
                primeiroIndice = i;
                break;
            }
        }

        if (primeiroIndice == -1) {
            System.out.println("Não existe vogal que satisfaça os criterios de busca");
            System.exit(1);
        }

        return vogaisEncontradas[primeiroIndice];
    }

    public static boolean verificaVogal(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    private static int procuraIndice(char caractereAtual, char[] vogaisEncontradas) {
        for (int i = 0; i < vogaisEncontradas.length; i++) {
            if (caractereAtual == vogaisEncontradas[i]) {
                return i;
            }
        }
        return -1;
    }

}
