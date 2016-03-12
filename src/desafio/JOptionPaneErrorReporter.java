
package desafio;
import javax.swing.JOptionPane;
/** Classe utilizada para reportar erros em JOptionPane
 *
 * @author HenriqueLinhares
 */
public class JOptionPaneErrorReporter {
    
    public static void reportarMatriculaInvalida(String pMatricula){
        JOptionPane.showMessageDialog(null, "Não existe aluno com a matrícula "+pMatricula, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
     public static void reportarMatriculaVazia(){
        JOptionPane.showMessageDialog(null, "Por favor digite uma matrícula", "Error", JOptionPane.ERROR_MESSAGE);
    }

    static void reportarAlunoComStatusInativo(String pMatricula) {
        JOptionPane.showMessageDialog(null, "O Aluno de matrícula "+ pMatricula+" não está ativo", "Error", JOptionPane.ERROR_MESSAGE);
    }

    static void reportarAlunoComEmailExistente(String pMatricula) {
        JOptionPane.showMessageDialog(null, "O Aluno de matrícula "+ pMatricula+" já possui um UFFMAIL", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
      static void reportarCriacaoDeEmailCancelada(String pMatricula) {
        JOptionPane.showMessageDialog(null, "Cancelado \n Não foi criado um email para o aluno de matrícula "+ pMatricula, "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
}
