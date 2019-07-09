package Lista;

import javax.swing.JOptionPane;

/**
 *
 * @author Taffarel Xavier
 */
public class ImplementandoLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Criação da Lista
         */
        Lista f = new Lista();

        int opcao = 0;

        /*
        Uso o laço do-while par 
        */
        do {

            /*Uso tray aqui para tratar erros inerentes
            à má digitação, isto é, de uma entrada que não
            seja um número.*/
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "+-----Sistema-----+\nMenu\n"
                        + "1 - Inserir Novo Aluno\n" //Okay
                        + "2 - Buscar Aluno\n" //Okay
                        + "3 - Excluir Aluno\n"
                        + "4 - Retornar Tamanho\n" //Okay
                        + "5 - Mostrar Lista\n" //Okay
                        + "6 - Sair, ou clique em 'Cancelar', ou pressione ESC.", "Tela Inicial", JOptionPane.INFORMATION_MESSAGE)//Okay
                );
            } catch (Exception e) {
                if (e.getMessage().length() == 4) { //Null, caso o usuário clique em 'Cancelar'
                    JOptionPane.showMessageDialog(null, "Programa Encerrado.", "Atenção", 1);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um número entre 1 a 6.", "Atenção", 1);
                }
            }

            switch (opcao) {
                case 1: //Adicionar

                    String nome;

                    nome = JOptionPane.showInputDialog(null,
                            "Incluir Aluno\n\nDigite o nome do aluno:");

                    while (nome.trim().length() == 0) {

                        nome = JOptionPane.showInputDialog(null,
                                "Incluir Aluno\n\nDigite um nome válido, o nome não pode estar vazio.", "Atenção", JOptionPane.ERROR_MESSAGE);

                    }
                    //Pega o tamanho temporário
                    int tamTmp = f.tamanho();

                    f.insere(nome);

                    //Verifica se o tamanho da lista é maior que o tamanho armazenado na variável temporária.
                    if (tamTmp < f.tamanho()) {
                        JOptionPane.showMessageDialog(null,
                                "Aluno cadastrado com sucesso!\n"
                                + "A posição desse aluno é: " + (f.tamanho()), "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                        opcao = 0;
                    }

                    break;
                case 2: //Buscar aluno
                    if (f.tamanho() != 0) {//Verificar se a lista não está vazia.

                        String nomeDoAluno = JOptionPane.showInputDialog(null,
                                "Buscar Aluno\n\nDigite o nome do aluno:");

                        if (f.contem(nomeDoAluno)) {
                            JOptionPane.showMessageDialog(null,
                                    "Aluno encontrado: " + nomeDoAluno + ".", "Atenção", 1);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Aluno não encontrado.", "Atenção", 1);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista Vazia.", "Atenção", 2);
                    }
                    break;
                case 3: //Excluir aluno
                    if (f.tamanho() != 0) {//Verificar se a lista não está vazia.
                        try {
                            int posicaoAluno = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Buscar Aluno\n\nDigite a posição do aluno:"));

                            System.out.println("Posição: " + posicaoAluno);

                            if (f.posicaoValida(posicaoAluno - 1)) {

                                int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este aluno?", "Atebção", 0);

                                if (confirm == 0) {

                                    f.remove(posicaoAluno);

                                    JOptionPane.showMessageDialog(null,
                                            "Aluno encontrado: " + f.mostrarItem(posicaoAluno) + ".", "Atenção", 1);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Aluno não encontrado.", "Atenção", 1);
                            }
                        } catch (Exception ex) {
                            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Atenção", 1);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Lista Vazia.", "Atenção", 2);
                    }
                    break;
                case 4:
                    if (f.tamanho() != 0) {//Verificar se a lista não está vazia.
                        JOptionPane.showMessageDialog(null,
                                "Retornar Tamanho\n\nTotal de Alunos: "
                                + f.tamanho() + ".", "Atenção", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista Vazia.", "Atenção", 2);
                    }
                    break;
                case 5: //Mostrar tudo
                    if (f.tamanho() != 0) {
                        f.imprime();
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista Vazia.", "Atenção", 2);
                    }
                    break;
                case 6:

                    JOptionPane.showMessageDialog(null, "Programa Encerrado.", "Atenção", 1);

                    break;
            }
        } while (opcao != 6);

    }

}
