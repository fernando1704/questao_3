
package desafio_questao_3;

public class StringStream implements Stream {

    private final String stream;

    private int indice = 0;

    public StringStream(String stream) {
	this.stream = stream;
    }

    public char getNext() {
	return this.stream.charAt(indice++);
    }

    public boolean hasNext() {
	return (this.stream.length() > indice);
    }

}