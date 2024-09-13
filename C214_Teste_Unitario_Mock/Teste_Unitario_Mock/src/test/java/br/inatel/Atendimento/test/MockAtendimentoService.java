package br.inatel.Atendimento.test;

import br.inatel.atendimento.AtendimentoService;
import java.util.ArrayList;

public class MockAtendimentoService implements AtendimentoService {

    @Override
    public String busca(int sala) {
        // Determina o predio com base no intervalo da sala
        if (sala >= 1 && sala <= 5) {
            return AtendimentoConst.PREDIO1;
        } else if (sala >= 6 && sala <= 10) {
            return AtendimentoConst.PREDIO2;
        } else if (sala >= 11 && sala <= 15) {
            return AtendimentoConst.PREDIO3;
        } else if (sala >= 16 && sala <= 20) {
            return AtendimentoConst.PREDIO4;
        } else if (sala >= 21 && sala <= 25) {
            return AtendimentoConst.PREDIO6;
        } else {
            return AtendimentoConst.INEXISTENTE; // Retorna INEXISTENTE para salas fora dos intervalos definidos
        }
    }

    @Override
    public boolean atendimentoExistente(int sala) {
        ArrayList<Integer> salasExistentes = new ArrayList<Integer>();
        salasExistentes.add(1);  // Prédio 1
        salasExistentes.add(8);  // Prédio 2
        salasExistentes.add(13); // Prédio 3
        salasExistentes.add(18); // Prédio 4
        salasExistentes.add(22); // Prédio 6

        for (int i=0; i < salasExistentes.size(); i++){
            if (salasExistentes.get(i).equals(sala) || salasExistentes.get(i).equals(sala)){
                return true;
            }else{
                return false;
            }
        }

        return false;
    }
}
