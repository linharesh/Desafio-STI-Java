package desafio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/** Classe utilizada para LER e realizar o PARSE de um arquivo CSV
 *
 * @author linhares
 */
public class CSVReader {

    private BufferedReader bufferedReader;
    
    private final String CVS_SPLIT_BY = ",";
    
    /** Método utilizado para ler um arquivo CSV com alunos.
     *  Realiza a leitura do arquivo e armazena os alunos em um ArrayList
     * 
     * @param filePath Caminho para o arquivo que será lido (ex: C:/User/Linhares/alunos.csv)
     * @return ArrayList contendo os alunos
     */
    public ArrayList<Aluno> readCVS(String filePath) {
        
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));

            //Descarta a primeira linha - só contém informações de cabeçalho
            String linha = bufferedReader.readLine();

            while ((linha = bufferedReader.readLine()) != null) {
                String[] alunoInfo = linha.split(this.CVS_SPLIT_BY);
                
                boolean estaAtivo;
                if (alunoInfo[5].equalsIgnoreCase("Ativo")){
                    estaAtivo = true;
                } else {
                    estaAtivo = false;
                }
                
                Aluno aluno = new Aluno(alunoInfo[0], alunoInfo[1], alunoInfo[2], alunoInfo[3], alunoInfo[4], estaAtivo);
                alunos.add(aluno);
            }

            
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
            }
        }

        return alunos;
    }

}

