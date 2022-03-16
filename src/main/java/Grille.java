import exception.ColumnFullException;

import java.util.ArrayList;
import java.util.List;

public class Grille {
    private final String[][] matrice;

    public Grille() {
        matrice = new String[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                matrice[i][j] = ".";
            }
        }
    }

    private int getLastEmptyCellInColumn(int column) {

        for (int i = 5; i >= 0; i--) {
            if (matrice[i][column].equals(".")) {
                return i;
            }
        }
        return -1;

    }

    public void putToken(String token, int column) throws ColumnFullException {
        if (column > 7) throw new IllegalArgumentException("column should be less than 8");
        if (column < 1) throw new IllegalArgumentException("column should be greater than 0");

        int lastEmptyCell = getLastEmptyCellInColumn(column - 1);

        if(lastEmptyCell == -1) throw new ColumnFullException();

        matrice[lastEmptyCell][column - 1] = token;
    }

    public int getNumberOfLines() {
        return 6;
    }

    public int getNumberOfColumns() {
        return 7;
    }

    public String getTokenAt(int line, int column) {
        return matrice[line - 1][column - 1];
    }

    public List<String[]> getColumns(){
        return null;
    }

    public List<String[]> getLines(){
        return null;
    }

    public List<String[]> getDiagonals(){
        return null;
    }

    @Override
    public String toString() {
        List<String> tempo = new ArrayList<>();
        for (String[] line : matrice) {
            tempo.add(String.join("", line));
        }
        return String.join("\n", tempo);
    }
}
