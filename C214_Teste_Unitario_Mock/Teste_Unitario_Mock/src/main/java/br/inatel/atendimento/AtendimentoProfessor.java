package br.inatel.atendimento;

public class AtendimentoProfessor {

    private String nomeDoProfessor;
    private String horarioDeAtendimento;
    private String periodo;
    private int sala;

    public AtendimentoProfessor(String nomeDoProfessor, String horarioDeAtendimento, String periodo, int sala) {
        this.nomeDoProfessor = nomeDoProfessor;
        this.horarioDeAtendimento = horarioDeAtendimento;
        this.periodo = periodo;
        this.sala = sala;
    }

    // Método para obter o número do prédio com base na sala
    public int obterPredio() {
        if (sala >= 1 && sala <= 5) {
            return 1;
        } else if (sala >= 6 && sala <= 10) {
            return 2;

        } else if (sala >= 11 && sala <= 15) {
            return 3;

        } else if (sala >= 16 && sala <= 20) {
            return 4;

        } else if (sala >= 21 && sala <= 25) {
            return 6;

        } else {
            throw new IllegalArgumentException("Sala inválida");
        }
    }

    // Método para formatar as informações de horário de atendimento
    public String popularHorario() {
        int predio = obterPredio();
        return String.format("Nome: %s, Horário: %s, Período: %s, Sala: %d, Prédio: %d",
                nomeDoProfessor,
                horarioDeAtendimento,
                periodo,
                sala
                );
    }
}
