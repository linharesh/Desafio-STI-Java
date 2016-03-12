
package desafio;

/** Classe utilizada para representar um Aluno
 *
 * @author Linhares
 */
public class Aluno {
    
    private String nome;
    private String matricula;
    private String telefone;
    private String email;
    private String uffmail;
    private boolean statusAtivo;

    public Aluno(String nome, String matricula, String telefone, String email, String uffmail, boolean statusAtivo) {
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.email = email;
        this.uffmail = uffmail;
        this.statusAtivo = statusAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUffmail() {
        return uffmail;
    }

    public void setUffmail(String uffmail) {
        this.uffmail = uffmail;
    }

    public boolean getStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(boolean statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    /** Retorna uma string com a representação de uma instância de aluno, de acordo com o formato CSV
     *  Segue o seguinte padrão : nome,matricula,telefone,email,uffmail,status
     * 
     * Exemplo : Luiza Alves Cardoso,100142,99999-9968,email@gmail.com,,Ativo
     * 
     * @return Retorna uma string com a representação de uma instância de aluno, de acordo com o formato CSV
     */
    public String csvRepresentation() {
        
        String status;
        if (this.statusAtivo){
            status = "Ativo";
        } else {
            status = "Inativo";
        }
        
        return this.nome + "," + this.matricula + "," + this.telefone + "," + this.email + "," + this.uffmail + "," + status;
    }
    
    
    
    
}
