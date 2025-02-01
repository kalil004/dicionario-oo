import java.util.Map;
import java.util.TreeMap;

public class Dicionario {
    private Map<String, String> dicionarioPortugues;
    private Map<String, String> dicionarioIngles;

    public Dicionario() {
        dicionarioPortugues = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        dicionarioIngles = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario) {
        if (dicionario == TipoDicionario.PORTUGUES) {
            dicionarioPortugues.put(palavra, traducao);
        } else if (dicionario == TipoDicionario.INGLES) {
            dicionarioIngles.put(palavra, traducao);
        } else {
            throw new IllegalArgumentException("Tipo de dicionário inválido.");
        }
    }

    public String traduzir(String palavra, TipoDicionario dicionarioDeBusca) {
        String traducao;
        if (dicionarioDeBusca == TipoDicionario.PORTUGUES) {
            traducao = dicionarioPortugues.get(palavra);
        } else if (dicionarioDeBusca == TipoDicionario.INGLES) {
            traducao = dicionarioIngles.get(palavra);
        } else {
            throw new IllegalArgumentException("Tipo de dicionário inválido.");
        }

        if (traducao == null) {
            throw new PalavraNaoEncontrada("Palavra não encontrada no dicionário: " + palavra);
        }

        return traducao;
    }
}
