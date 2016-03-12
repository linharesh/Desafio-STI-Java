
package desafio;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Classe utilizada para GRAVAR os alunos que estão em memória em um arquivo .CSV
 *
 * @author Linhares
 */
public class CSVWriter {
    
    private BufferedWriter bufferedWriter;
    
    /** Método utilizado para gravar os alunos em um arquivo .CSV 
     * 
     * @param filePath caminho para o arquivo que será gravado (ex: C:/User/Linhares/alunos.csv)
     */
    public void salvarArquivoCSV(String filePath){
        
        if (filePath == null){
            return;
        }
        
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write("nome,matricula,telefone,email,uffmail,status");
            
            ArrayList<Aluno> alunos = AlunosManager.getInstance().getAlunos();
            
            for (Aluno aluno : alunos) {
                bufferedWriter.newLine();
                bufferedWriter.write(aluno.csvRepresentation());
                System.out.println(aluno.csvRepresentation());
            }
            
            bufferedWriter.close();
            
        } catch (IOException ex) {
            Logger.getLogger(CSVWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
