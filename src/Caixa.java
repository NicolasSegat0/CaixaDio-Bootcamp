import java.util.ArrayList;
import java.util.Collections;

public class Caixa {
    private int quantSaque;
    private float valorSaque;
    ArrayList quantNotas;

    public Caixa() {
        quantNotas = new ArrayList<>();
    }

    public boolean sacar(float quantia) {
        if ((quantia <= 0 || quantia < consultaSaldo())) {
            return false;
        } else if (quantia % 5 != 0) {
            return false;
        }
        else {
            ArrayList notas = new ArrayList();
            float sobra = quantia;
            float valor = 0;
            Collections.sort(quantNotas);

            while (sobra > 0) {
                valor = sobra - ((Integer) quantNotas.get(quantNotas.size() - 1)).intValue();

                if (valor < 0) {
                    notas.add(quantNotas.get(quantNotas.size()- 1));
                    quantNotas.remove(quantNotas.size()- 1);
                    Collections.sort(quantNotas);
                } else {
                    quantNotas.remove(quantNotas.size() - 1);
                    sobra = valor;
                }
            }

            for (int i = 0; i < notas.size(); i++ ) {
                quantNotas.add(notas.get(i));
            }
            quantSaque = (int) (quantSaque + quantia);
            valorSaque = valorSaque + 1;

            return true;
        }
    }

    public void repor(int nota, int quantNotas) {
        for (int i = 0; i < quantNotas; i++) {
            quantNotas.add(nota);
        }
    }

    public float consultaSaldo() {
        float somaNOtas = 0;

        if (!quantNotas.isEmpty()) {
            for (int i = 0; i < quantNotas.size(); i++) {
                somaNOtas = somaNOtas + ((Integer) quantNotas.get(i)).intValue();
            }
        }
        return somaNOtas;
    }

    public  int mostrarQtdtipoNotas(int nota) {
        int quantNotas = 0;
        for (int i = 0; i < quantNotas.size(); i++) {
            if (quantNotas.get(i).equals(nota)) {
                quantNotas = quantNotas + 1;
            }
        }
        return  quantNotas;
    }

    public float getValorSaque() {
        return valorSaque;
    }

    public void setValorSaque(float valorSaque) {
        this.valorSaque = valorSaque;
    }


    public int getQuantSaque() {
        return quantSaque;
    }

    public void setQuantSaque(int quantSaque) {
        this.quantSaque = quantSaque;
    }
}
