package br.inatel.atendimento;

public class AtendimentoProfessor {

    private String nomeDoProfessor;
    private String horarioDeAtendimento;
    private String periodo;
    private int sala;
    private int predio;

    public AtendimentoProfessor(String nomeDoProfessor, String horarioDeAtendimento, String periodo, int sala,int predio) {
        this.nomeDoProfessor = nomeDoProfessor;
        this.horarioDeAtendimento = horarioDeAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio=predio;
    }

    //get
    public String getNomeProfessor() {
        return nomeDoProfessor;
    }
    public String getHorarioAtendimento() {
        return horarioDeAtendimento;
    }
    public String getPeriodo() {
        return periodo;
    }
    public int getSala() {
        return sala;
    }

    public int getPredio(){
        return predio;
    }

}
