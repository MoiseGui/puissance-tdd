public class Grille {
    private String[][] matrice;

    public Grille() {
        matrice = new String[6][7];
    }

    public String[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(String[][] matrice) {
        this.matrice = matrice;
    }
}
