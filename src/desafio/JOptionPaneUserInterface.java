/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author HenriqueLinhares
 */
public class JOptionPaneUserInterface {

    public static String readCSVfilePath() {

        boolean pathValido = false;
        File file;
        String extensaoCorreta = ".csv";
        String path = null;

        do {
            path = JOptionPane.showInputDialog("Entre com o caminho para o arquivo CSV (C:/User...)");
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
    
    

}
