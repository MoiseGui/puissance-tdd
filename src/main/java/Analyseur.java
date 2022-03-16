import java.util.List;
import java.util.Optional;

public class Analyseur {
    private Analyseur() {}

    public static Optional<String> analyseGrille(Grille grille){
        List<String[]> lines = grille.getLines();

        Optional<String> result = analyseArrays(lines);

        if(result.isPresent()){
            return result;
        }

        List<String[]> columns = grille.getColumns();

        result = analyseArrays(columns);

        if(result.isPresent()){
            return result;
        }

        List<String[]> diagonals = grille.getDiagonals();

        return analyseArrays(diagonals);
    }

    private static Optional<String> analyseArrays(List<String[]> array){
        for (String[] line : array) {
            String joined = String.join("", line);
            if (joined.contains("XXXX")) {
                return Optional.of("X");
            }
            if(joined.contains("OOOO")){
                return Optional.of("O");
            }
        }
        return Optional.empty();
    }
}
