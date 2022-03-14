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

    public String[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(String[][] matrice) {
        this.matrice = matrice;
    }

    public void putToken(String token, int column) {

        matrice[5][column - 1] = token;

    }
}
