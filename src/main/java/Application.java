import view.Vue;

public class Application {
    Grille grille;
    Vue vue;

    public Application(Grille grille, Vue vue) {
        this.grille = grille;
        this.vue = vue;
    }

    public void start(){
        vue.write(grille.toString());
        vue.write(getFirstPlayer());
        vue.write("Please choose a column: ");
        int numColumn = vue.read();
        grille.putToken("X", numColumn);
        vue.write(grille.toString());
    }

    private String getFirstPlayer(){
        return "Player X starts";
    }
}
