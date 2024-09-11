package br.inatel.atendimento;

public class AtendimentoProfessor {

    public String nomeprofessor;
    public String horarioatendimento;
    public String periodo;
    public int sala;
    public int predio;

    public AtendimentoProfessor(String nomeprofessor,String horarioatendimento, String periodo,int sala,int predio ){
    this.nomeprofessor=nomeprofessor;
    this.horarioatendimento=horarioatendimento;
    this.periodo=periodo;
    this.sala=sala;
    this.predio=predio;
    }

    public String getNomeprofessor(){
        return nomeprofessor;
    }

    public String getHorarioatendimento(){
        return horarioatendimento;
    }

    public String getPeriodo(){
        return periodo;
    }

    public int getSala(){
        return sala;
    }

    public int getPredio(){
        return predio;
    }

}
