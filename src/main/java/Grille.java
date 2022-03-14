public class Grille {
    private String[][] matrice;

    public Grille() {
        matrice = new String[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                matrice[i][j] = ".";
            }
        }
    }
    public void putToken(String token, int column) {

        matrice[5][column - 1] = token;

    }

    public int getNumberOfLines() {
        return 6;
    }

    public int getNumberOfColumns() {
        return 7;
    }

    public String getTokenAt(int line, int column) {
        return matrice[line-1][column-1];
    }
}
