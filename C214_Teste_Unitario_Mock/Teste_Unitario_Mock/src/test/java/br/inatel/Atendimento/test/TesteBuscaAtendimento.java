package br.inatel.Atendimento.test;

import br.inatel.atendimento.BuscaAtendimentoProfessor;
import br.inatel.atendimento.AtendimentoProfessor;
import br.inatel.atendimento.AtendimentoService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteBuscaAtendimento {

    AtendimentoService service;
    BuscaAtendimentoProfessor buscaAtendimentoProfessor;

    @Before
    public void setup() {
        // Criando o contexto do meu teste com o Mock (serviço mock)
        service = new MockAtendimentoService();
        buscaAtendimentoProfessor = new BuscaAtendimentoProfessor(service);
    }

    // Testes de Sucesso
    @Test
    public void testeBuscaProfessorChris() {
        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(1);
        assertEquals("Chris", professor.getNomeProfessor());
        assertEquals("Segunda:17:30", professor.getHorarioAtendimento());
        assertEquals("noturno", professor.getPeriodo());
        assertEquals(1, professor.getSala());
        assertEquals(1, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorRenzo() {
        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(8);
        assertEquals("Renzo", professor.getNomeProfessor());
        assertEquals("Terça:17:30", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(8, professor.getSala());
        assertEquals(2, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorBreno() {
        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(13);
        assertEquals("Breno Monteiro", professor.getNomeProfessor());
        assertEquals("Quinta:16:00", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(13, professor.getSala());
        assertEquals(3, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorBruno() {
        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(18);
        assertEquals("Bruno", professor.getNomeProfessor());
        assertEquals("Terça:15:30", professor.getHorarioAtendimento());
        assertEquals("integral", professor.getPeriodo());
        assertEquals(18, professor.getSala());
        assertEquals(4, professor.getPredio());
    }

    @Test
    public void testeBuscaProfessorSamuel() {
        AtendimentoProfessor professor = buscaAtendimentoProfessor.buscaAtendimentoProfessor(22);
        assertEquals("Samuel", professor.getNomeProfessor());
        assertEquals("Quarta:19:30", professor.getHorarioAtendimento());
        assertEquals("noturno", professor.getPeriodo());
        assertEquals(22, professor.getSala());
        assertEquals(6, professor.getPredio());
    }

    @Test
    public void testeBuscaSalaNaoCadastrada() {
        boolean atendimentoValido = buscaAtendimentoProfessor.verificaArrayListExistente(30);
        assertFalse(atendimentoValido);
    }

    @Test
    public void testeBuscaSalaInexistente5() {
        boolean atendimentoValido = buscaAtendimentoProfessor.verificaArrayListExistente(50);
        assertFalse(atendimentoValido);
    }

    @Test
    public void testeBuscaSalaInexistente6() {
        boolean atendimentoValido = buscaAtendimentoProfessor.verificaArrayListExistente(100);
        assertFalse(atendimentoValido);
    }

    @Test
    public void testeBuscaSalaInexistente7() {
        boolean atendimentoValido = buscaAtendimentoProfessor.verificaArrayListExistente(-20);
        assertFalse(atendimentoValido);
    }

    @Test
    public void testeBuscaSalaInexistente8() {
        boolean atendimentoValido = buscaAtendimentoProfessor.verificaArrayListExistente(-3);
        assertFalse(atendimentoValido);
    }

    @Test
    public void testeBuscaSalaInexistente9() {
        boolean atendimentoValido = buscaAtendimentoProfessor.verificaArrayListExistente(-5);
        assertFalse(atendimentoValido);
    }
}
