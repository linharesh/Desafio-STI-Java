/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;
import javax.swing.JOptionPane;
/**
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
    
}
