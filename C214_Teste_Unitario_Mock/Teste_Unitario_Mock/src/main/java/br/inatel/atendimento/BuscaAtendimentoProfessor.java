package br.inatel.atendimento;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaAtendimentoProfessor {

    AtendimentoService atendimentoService;

    public BuscaAtendimentoProfessor(AtendimentoService service) {
        this.atendimentoService = service;
    }

    // Metodo para retornar as informações de atendimento
    public AtendimentoProfessor returnAtendimento(int sala) {
        // Busca atendimento como uma string JSON
        String atendimentoJson = atendimentoService.busca(sala);

        // Converte a string JSON em um objeto JsonObject usando Gson
        JsonObject jsonObject = JsonParser.parseString(atendimentoJson).getAsJsonObject();

        // objeto AtendimentoProfessor com os dados extraídos do JsonObject
        return new AtendimentoProfessor(
                jsonObject.get("nomeDoProfessor").getAsString(),
                jsonObject.get("horarioDeAtendimento").getAsString(),
                jsonObject.get("periodo").getAsString(),
                jsonObject.get("sala").getAsInt(),
                jsonObject.get("predio").getAsInt()
        );
    }

}
