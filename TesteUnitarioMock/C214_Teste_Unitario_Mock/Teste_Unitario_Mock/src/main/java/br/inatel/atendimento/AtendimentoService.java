package br.inatel.atendimento;

//atendimento a partir da sala
public interface AtendimentoService {
  public String busca(int sala);
  public boolean atendimentoExistente(int sala);
}
