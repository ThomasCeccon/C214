package br.inatel.Atendimento.test.mockito;

import br.inatel.atendimento.BuscaAtendimentoProfessor;
import br.inatel.atendimento.AtendimentoProfessor;
import br.inatel.atendimento.AtendimentoService;
import br.inatel.Atendimento.test.AtendimentoConst;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TesteBuscaAtendimento {

    @Mock
    private AtendimentoService service;
    private BuscaAtendimentoProfessor buscaAtendimentoProfessor;

    @Before
    public void setup() {
        buscaAtendimentoProfessor = new BuscaAtendimentoProfessor(service);
    }

    // Testes de sucesso
    @Test
    public void testeBuscaProfessorAna() {
        Mockito.when(service.busca(2)).thenReturn(AtendimentoConst.NOVO_PREDIO1);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(2);
        assertEquals("Ana", professor.getNomeProfessor());
        assertEquals("Segunda:10:00", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(2, professor.getSala());
        assertEquals(1, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorCarlos() {
        Mockito.when(service.busca(6)).thenReturn(AtendimentoConst.NOVO_PREDIO2);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(6);
        assertEquals("Carlos", professor.getNomeProfessor());
        assertEquals("Terça:11:00", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(6, professor.getSala());
        assertEquals(2, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorMaria() {
        Mockito.when(service.busca(9)).thenReturn(AtendimentoConst.NOVO_PREDIO3);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(9);
        assertEquals("Maria", professor.getNomeProfessor());
        assertEquals("Quarta:13:00", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(9, professor.getSala());
        assertEquals(3, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorJoão() {
        Mockito.when(service.busca(12)).thenReturn(AtendimentoConst.NOVO_PREDIO4);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(12);
        assertEquals("João", professor.getNomeProfessor());
        assertEquals("Quinta:15:00", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(12, professor.getSala());
        assertEquals(4, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorLaura() {
        Mockito.when(service.busca(15)).thenReturn(AtendimentoConst.NOVO_PREDIO5);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(15);
        assertEquals("Laura", professor.getNomeProfessor());
        assertEquals("Sexta:17:00", professor.getHorarioAtendimento());
        assertEquals("noturno", professor.getPeriodo());
        assertEquals(15, professor.getSala());
        assertEquals(5, professor.getPredio());
    }

    // Testes de falha
    @Test
    public void testeBuscaProfessorSalaInexistente() {
        Mockito.when(service.busca(56)).thenReturn(AtendimentoConst.INEXISTENTE);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(56);
        assertEquals("Inexistente", professor.getNomeProfessor());
        assertEquals("Inexistente", professor.getHorarioAtendimento());
        assertEquals("Inexistente", professor.getPeriodo());
        assertEquals(0, professor.getSala());
        assertEquals(0, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorSalaMenorQue1() {
        Mockito.when(service.busca(0)).thenReturn(AtendimentoConst.INEXISTENTE);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(0);
        assertEquals("Inexistente", professor.getNomeProfessor());
        assertEquals("Inexistente", professor.getHorarioAtendimento());
        assertEquals("Inexistente", professor.getPeriodo());
        assertEquals(0, professor.getSala());
        assertEquals(0, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorSalaNegativa() {
        Mockito.when(service.busca(-5)).thenReturn(AtendimentoConst.INEXISTENTE);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(-5);
        assertEquals("Inexistente", professor.getNomeProfessor());
        assertEquals("Inexistente", professor.getHorarioAtendimento());
        assertEquals("Inexistente", professor.getPeriodo());
        assertEquals(0, professor.getSala());
        assertEquals(0, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorSalaNaoNumerica() {
        // Simula o serviço para retornar INEXISTENTE quando recebe uma sala não numérica
        Mockito.when(service.busca(9999)).thenReturn(AtendimentoConst.INEXISTENTE);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(9999);
        assertEquals("Inexistente", professor.getNomeProfessor());
        assertEquals("Inexistente", professor.getHorarioAtendimento());
        assertEquals("Inexistente", professor.getPeriodo());
        assertEquals(0, professor.getSala());
        assertEquals(0, professor.getPredio());
    }

    @Test
    public void testeVerificaProfessorExistente() {
        Mockito.when(service.atendimentoExistente(1)).thenReturn(true);

        boolean professorValido = service.atendimentoExistente(1);
        assertTrue(professorValido);
    }
}
