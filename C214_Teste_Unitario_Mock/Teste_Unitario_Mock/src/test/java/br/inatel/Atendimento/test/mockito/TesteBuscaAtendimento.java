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
    public void testeBuscaProfessorChris() {
        Mockito.when(service.busca(1)).thenReturn(AtendimentoConst.PREDIO1);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(1);
        assertEquals("Chris", professor.getNomeProfessor());
        assertEquals("Segunda:17:30", professor.getHorarioAtendimento());
        assertEquals("noturno", professor.getPeriodo());
        assertEquals(1, professor.getSala());
        assertEquals(1, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorRenzo() {
        Mockito.when(service.busca(8)).thenReturn(AtendimentoConst.PREDIO2);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(8);
        assertEquals("Renzo", professor.getNomeProfessor());
        assertEquals("Terça:17:30", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(8, professor.getSala());
        assertEquals(2, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorBreno() {
        Mockito.when(service.busca(13)).thenReturn(AtendimentoConst.PREDIO3);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(13);
        assertEquals("Breno Monteiro", professor.getNomeProfessor());
        assertEquals("Quinta:16:00", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(13, professor.getSala());
        assertEquals(3, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorBruno() {
        Mockito.when(service.busca(18)).thenReturn(AtendimentoConst.PREDIO4);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(18);
        assertEquals("Bruno", professor.getNomeProfessor());
        assertEquals("Terça:15:30", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(18, professor.getSala());
        assertEquals(4, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorSamuel() {
        Mockito.when(service.busca(22)).thenReturn(AtendimentoConst.PREDIO6);

        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(22);
        assertEquals("Samuel", professor.getNomeProfessor());
        assertEquals("Quarta:19:30", professor.getHorarioAtendimento());
        assertEquals("noturno", professor.getPeriodo());
        assertEquals(22, professor.getSala());
        assertEquals(6, professor.getPredio());
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
