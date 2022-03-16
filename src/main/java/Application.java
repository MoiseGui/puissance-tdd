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
    }

    private String getFirstPlayer(){
        return "Player X starts";
    }
}
