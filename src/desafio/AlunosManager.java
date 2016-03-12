
package desafio;

import java.util.ArrayList;

/** Classe utilizada para representar e manipular o conjunto de todos os alunos
 *
 * @author Linhares
 */
public class AlunosManager {

    private static AlunosManager sharedInstance;

    static {
    }

    private ArrayList<Aluno> alunos;

    private AlunosManager() {

    }

    /** Padrão de projeto Singleton
     * 
     * @return Retorna a instância compartilhada do Singleton AlunosManager
     */
    public static AlunosManager getInstance() {
        if (sharedInstance == null) {
            inicializaInstancia();
        }
        return sharedInstance;
    }

    /** Padrão de projeto Singleton
     *  Inicializa a instância compartilhada de AlunosManager
     */
    private static synchronized void inicializaInstancia() {
        if (sharedInstance == null) {
            sharedInstance = new AlunosManager();
        }
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    /** Método utilizado para criar um novo uffmail para um aluno
     * 
     * @param pMatricula Matrícula do aluno 
     */
    public void criarNovoUffMail(String pMatricula) {
        if (alunoPodeCriarUffMail(pMatricula)) {
            EmailCreator emailCreator = new EmailCreator();
            emailCreator.criarEmail(buscaAlunoPorMatricula(pMatricula));
        }
    }

    /** Método utilizado para atribuir um novo uffmail para um aluno
     * 
     * @param pMatricula Matrícula do aluno
     * @param uffMail Uffmail do aluno
     */
    public void setUffMailForAluno(String pMatricula, String uffMail) {
        int index = buscaIndiceDeAlunoPorMatricula(pMatricula);
        Aluno aluno = alunos.remove(index);
        aluno.setUffmail(uffMail);
        alunos.add(index, aluno);
    }

    /** Busca Aluno por matrícula
     * 
     * @param pMatricula Matrícula do aluno que será buscado
     * @return Indice do aluno no ArrayList alunos
     */
    private int buscaIndiceDeAlunoPorMatricula(String pMatricula) {
        for (int k = 0; k < alunos.size(); k++) {
            Aluno aluno = alunos.get(k);
            if (aluno.getMatricula().equals(pMatricula)) {
                return k;
            }
        }
        return -1;
    }

    /** Verifica se o aluno pode criar um UFFMAIL
     *  Um aluno só poderá criar um UFFMAIL caso ele esteja ativo, 
     *  e não possua um UFFMAIL.
     * 
     * @param pMatricula Matrícula do aluno que será verificado
     * @return True se pode criar um UFFMAIL, false se não pode.
     */
    private boolean alunoPodeCriarUffMail(String pMatricula) {
        Aluno aluno = buscaAlunoPorMatricula(pMatricula);
        if (aluno != null) {
            if (aluno.getStatusAtivo()) {
                if (!aluno.getUffmail().contains(EmailCreator.SUFIXOUFFMAIL)) {
                    return true;
                } else {
                    JOptionPaneErrorReporter.reportarAlunoComEmailExistente(pMatricula);
                }
            } else {
                JOptionPaneErrorReporter.reportarAlunoComStatusInativo(pMatricula);
            }
        } else {
            JOptionPaneErrorReporter.reportarMatriculaInvalida(pMatricula);
        }
        return false;
    }

    /** Busca um aluno por sua matrícula
     * 
     * @param pMatricula Matrícula do aluno que será buscado
     * @return Uma instância do aluno, ou NULL caso o aluno não seja encontrado.
     */
    private Aluno buscaAlunoPorMatricula(String pMatricula) {
        for (Aluno aluno : this.alunos) {
            if (aluno.getMatricula().equals(pMatricula)) {
                return aluno;
            }
        }
        return null;
    }

}
