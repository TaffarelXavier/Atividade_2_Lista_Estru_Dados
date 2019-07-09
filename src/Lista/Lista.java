package Lista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Lista {

    private List<Object> fila;

    /**
     *
     */
    public Lista() {
        this.fila = new ArrayList<>();
    }

    public String mostrarItem(int pos) {
        return this.fila.get(pos).toString();
    }

    /**
     *
     * @param obj
     */
    public void insere(Object obj) {
        this.fila.add(obj);
    }

    /**
     *
     * @param posicao
     * @return
     */
    public Object remove(int posicao) {
        return this.fila.remove(posicao - 1);
    }

    /**
     *
     * @param posicao
     * @return
     */
    boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < this.tamanho();
    }

    /**
     *
     * @return
     */
    public boolean vazia() {
        return this.fila.isEmpty();
    }

    /**
     *
     * @return
     */
    public int tamanho() {
        return this.fila.size();
    }

    /**
     *
     */
    public void imprime() {
        try {
            String al = "";

            for (int k = 0; k < this.tamanho(); k++) {
                al += (k + 1) + "--" + this.fila.get(k) + "\n";
            }
            if (al.length() == 0) {
                JOptionPane.showMessageDialog(null, "Não há alunos cadastrados.\n", "Atenção", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Lista de Alunos:\n" + al, "Atenção", 1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Atenção", 1);
        }

    }

    /**
     *
     * @param nome
     * @return
     */
    boolean contem(String nome) {
        try {
            for (int i = 0; i < this.tamanho(); i++) {
                System.out.println(this.fila.get(i).toString().toUpperCase());
                if (this.fila.get(i).toString().toUpperCase().equals(nome.toUpperCase())) {
                    return true;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Atenção", 1);
        }

        return false;
    }

}
