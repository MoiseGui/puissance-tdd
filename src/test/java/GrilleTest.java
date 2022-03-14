import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrilleTest {
    @Test
    public void shouldHave6LinesAfterInitialisation() {
        Grille grille = new Grille();
        int result = grille.getNumberOfLines();

        assertEquals(6, result);
    }

    @Test
    public void shouldHave7ColonesAfterInitialisation() {
        Grille grille = new Grille();
        int result = grille.getNumberOfColumns();

        assertEquals(7, result);
    }

    @Test
    public void shouldBeFilledWithSymbolPointAfterInitialisation() {
        Grille grille = new Grille();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                String result = grille.getTokenAt(i + 1, j + 1);
                assertEquals(".", result);
            }
        }
    }

    @Test
    public void shouldPutTokenOnTheLastLineOfEmptyColumn1() {
        Grille grille = new Grille();
        String[][] expectedMatrice = {
                {".", ".", ".", ".", ".", ".","."},
                {".", ".", ".", ".", ".", ".","."},
                {".", ".", ".", ".", ".", ".","."},
                {".", ".", ".", ".", ".", ".","."},
                {".", ".", ".", ".", ".", ".","."},
                {"X", ".", ".", ".", ".", ".","."},
        };

        grille.putToken("X", 1);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                String result = grille.getTokenAt(i + 1, j + 1);
                assertEquals(expectedMatrice[i][j], result);
            }
        }
    }
}
