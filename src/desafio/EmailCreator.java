package desafio;

import java.util.ArrayList;
import java.util.Random;

/** Classe responsável por criar um novo email para um aluno
 *
 * @author Linhares
 */
public class EmailCreator {

    public static String SUFIXOUFFMAIL = "@id.uff.br";
    
    private final Random randomGenerator = new Random();

    
    /** Método utilizado para criar um UFFmail para um aluno
     * 
     * @param aluno Aluno que terá um UFFmail criado
     */
    public void criarEmail(Aluno aluno) {
        String primeiraOpcao = gerarPrimeiraOpcaoDeEmail(aluno.getNome());
        String segundaOpcao = gerarSegundaOpcaoDeEmail(aluno.getNome());
        
        String emailEscolhido = JOptionPaneUserInterface.escolherEmail(primeiraOpcao, segundaOpcao);
        
        if (emailEscolhido == null){
            JOptionPaneErrorReporter.reportarCriacaoDeEmailCancelada(aluno.getMatricula());
        } else {
            AlunosManager.getInstance().setUffMailForAluno(aluno.getMatricula(), emailEscolhido);
            JOptionPaneUserInterface.informarCriacaoDeEmailComSucesso(aluno);
            //enviar SMS
        }

    }
    
    /** Gera a primeira opção de UFFMAIL
     *  A primeira opção será gerada pela concatenação do primeiro 
     *  nome com o último nome do aluno, e após será concatenado 
     *  um número aleatório de 0 até 999.
     * 
     *  Todo uffmail terá o sufixo definido pela constante SUFIXOUFFMAIL
     * 
     * @param nome Nome do aluno
     * @return Primeira opção de email gerada
     */
    private String gerarPrimeiraOpcaoDeEmail(String nome) {
        String email = "";
        String[] nomesplit = nome.split(" ");
        email = email.concat(nomesplit[0]);
        email = email.concat(nomesplit[nomesplit.length-1]);
        
        do {
        String random = Integer.toString(randomGenerator.nextInt(999));
        email = email.concat("_"+random);
        } while (!emailEstaDisponivel(email));
        
        email = email.toLowerCase();
        
        email = email.concat(SUFIXOUFFMAIL);
       
        return email;
    }

    
     /** Gera a primeira opção de UFFMAIL
     *  A primeira opção será gerada pela concatenação do ultimo nome 
     *  com o primeiro nome do aluno, e após será concatenado 
     *  um número aleatório de 0 até 999.
     *  Todo uffmail terá o sufixo definido pela constante SUFIXOUFFMAIL
     * 
     * @param nome Nome do aluno
     * @return Primeira opção de email gerada
     */
    private String gerarSegundaOpcaoDeEmail(String nome) {
        String email = "";
        String[] nomesplit = nome.split(" ");
        email = email.concat(nomesplit[nomesplit.length - 1]);
        email = email.concat(nomesplit[0]);
        
        do {
        String random = Integer.toString(randomGenerator.nextInt(999));
        email = email.concat("_"+random);
        } while (!emailEstaDisponivel(email));
       
        email = email.toLowerCase();
        
        email = email.concat(SUFIXOUFFMAIL);
        
        return email;
    }

    /** Verifica se um email está disponível para ser utilizado como UFFMAIL
     *  Um email só estará indisponível se algum aluno já tiver cadastrado o endereço
     *  
     * @param pEmail o uffmail que será verificado
     * @return TRUE = Disponível ; FALSE = indisponível
     */
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
