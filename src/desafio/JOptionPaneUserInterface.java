package desafio;

import java.io.File;
import javax.swing.JOptionPane;

/** Classe utilizada para realizar as interações com o usuário em JOptionPane
 *
 * @author HenriqueLinhares
 */
public class JOptionPaneUserInterface {

    /** Realiza a leitura de um caminho para um arquivo CSV que será lido
     * 
     * @return caminho para um arquivo CSV
     */
    public static String readCSVfilePath() {

        boolean pathValido = false;
        File file;
        String extensaoCorreta = ".csv";
        String path = null;

        do {
            path = JOptionPane.showInputDialog("Entre com o caminho para o arquivo CSV (C:/User...)");

            // Caso o usuário aperte CANCELAR, o path será null e o sistema encerra
            if (path == null) {
                System.exit(0);
            }

            if (path != null && path.endsWith(extensaoCorreta)) {
                file = new File(path);
                if (file.exists() && !file.isDirectory()) {
                    pathValido = true;
                }
            }

            if (!pathValido) {
                JOptionPane.showMessageDialog(null, "Erro : Arquivo não encontrado.");
            }

        } while (!pathValido);

        return path;
    }

    /** Realiza a leitura de um caminho para um arquivo CSV que será gravado
     * 
     * @return caminho para o arquivo CSV que será gravado
     */
    public static String writeCSVfilePath() {

        boolean pathValido = false;
        File file;
        String extensaoCorreta = ".csv";
        String path = null;

        do {
            path = JOptionPane.showInputDialog("Entre com o caminho que deseja salvar");

            // Caso o usuário aperte CANCELAR, o path será null e o arquivo não será salvo
            if (path == null) {
                return null;
            }

            if (path.endsWith(extensaoCorreta)) {
                file = new File(path);
                if (!file.isDirectory()) {
                    pathValido = true;
                }
            }

            if (!pathValido) {
                JOptionPane.showMessageDialog(null, "Erro : Caminho inválido");
            }

        } while (!pathValido);

        return path;
    }

    
    
    /** Permite ao usuário escolher uma entre duas opções de UFFMAIL
     * 
     * @param primeiraOpcao primeira opção de uffmail
     * @param segundaOpcao segunda opção de uffmail
     * @return email escolhido, ou NULL caso o usuário tenha cancelado
     */
    public static String escolherEmail(String primeiraOpcao, String segundaOpcao) {
        String[] buttons = {"Cancelar", "Opção 2", "Opção 1"};

        int resposta = JOptionPane.showOptionDialog(null, "Escolha uma opção de UFFMAIL\n" + "1 - "+primeiraOpcao+  "\n"+ "2 - "+segundaOpcao, "Escolha o UFFMAIL",
                JOptionPane.UNDEFINED_CONDITION, 0, null, buttons, null);
        System.out.println(resposta);
        
        if (resposta == 1){
            return segundaOpcao;
        } else if (resposta == 2){
            return primeiraOpcao;
        }
        return null;
    }

    /** Informa ao usuário que o uffmail foi criado com sucesso
     * 
     * @param aluno aluno que criou o uffmail
     */
    public static void informarCriacaoDeEmailComSucesso(Aluno aluno) {
        String mensagem = "A criação de seu e-mail ("+aluno.getUffmail()+") será feita nos próximos minutos.\n" +
        "Um SMS foi enviado para "+aluno.getTelefone()+" com a sua senha de acesso.";
        JOptionPane.showMessageDialog(null, mensagem);
    }

}
