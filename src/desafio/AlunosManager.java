/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

import java.util.ArrayList;

/**
 *
 * @author linhares
 */
public class AlunosManager {
    
    private static AlunosManager sharedInstance;
    
    static {}
    
    private ArrayList<Aluno> alunos;

    private AlunosManager(){
    
    }
   
    
    public static AlunosManager getInstance(){
        if (sharedInstance == null){
            inicializaInstancia();
        }
        return sharedInstance;
    }
    
    private static synchronized void inicializaInstancia(){
        if (sharedInstance == null){
            sharedInstance = new AlunosManager();
        }
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    
    public void criarNovoUffMail(String pMatricula){
        if (existeAlunoComMatricula(pMatricula)){
            Aluno aluno = buscaAlunoPorMatricula(pMatricula);
            if (aluno.getStatusAtivo()){
                
            } else {
            JOptionPaneErrorReporter.reportarAlunoComStatusInativo(pMatricula);
            }
        } else {
        JOptionPaneErrorReporter.reportarMatriculaInvalida(pMatricula);
        }
        
    }
    
    private boolean existeAlunoComMatricula(String pMatricula){
        for (Aluno aluno : this.alunos){
            if (aluno.getMatricula().equals(pMatricula)){
                return true;
            }
        }
        return false;
    
    }
    
    private Aluno buscaAlunoPorMatricula(String pMatricula){
        for (Aluno aluno : this.alunos){
            if (aluno.getMatricula().equals(pMatricula)){
                return aluno;
            }
        }
        return null;
    }
    
}
