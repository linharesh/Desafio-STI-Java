package desafio;

import java.util.ArrayList;

/**
 *
 * @author HenriqueLinhares
 */
public class EmailCreator {

    public static String sufixoUffMail = "@id.uff.br";

    public void criarEmail(Aluno aluno){
    
    }
    
    private void gerarOpcoesDeEmail(String nome) {

    }

    private boolean emailEstaDisponivel(String pEmail) {
        ArrayList<Aluno> alunos = AlunosManager.getInstance().getAlunos();
        for (Aluno aluno : alunos) {
            if (aluno.getUffmail().equals(pEmail)) {
                return false;
            }
        }
        return true;
    }
}


