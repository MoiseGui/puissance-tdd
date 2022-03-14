import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrilleTest {
    @Test
    public void shouldHave6LinesAfterInitialisation(){
        Grille grille = new Grille();
        int result = grille.getMatrice().length;

        assertEquals(6, result);
    }

    @Test
    public void shouldHave7ColonesAfterInitialisation(){
        Grille grille = new Grille();
        int result = grille.getMatrice()[0].length;

        assertEquals(7, result);
    }
    @Test
    public void shouldBeFilledWithSymbolPointAfterInitialisation(){
        Grille grille = new Grille();
        for (int i =0;i<6;i++) {
            for (int j = 0; j < 7; j++) {
                String result=grille.getMatrice()[i][j];
                assertEquals(".",result);
            }
        }
    }
}
