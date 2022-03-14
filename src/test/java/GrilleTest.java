import exception.ColumnFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GrilleTest {
    Grille grille;

    @BeforeEach
    public void setUp(){
        grille = new Grille();
    }

    @Test
    public void shouldHave6LinesAfterInitialisation() {
        int result = grille.getNumberOfLines();

        assertEquals(6, result);
    }

    @Test
    public void shouldHave7ColonesAfterInitialisation() {
        int result = grille.getNumberOfColumns();

        assertEquals(7, result);
    }

    @Test
    public void shouldBeFilledWithSymbolPointAfterInitialisation() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                String result = grille.getTokenAt(i + 1, j + 1);
                assertEquals(".", result);
            }
        }
    }

    @Test
    public void shouldPutTokenOnTheLastLineOfEmptyColumn1() {
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

    @Test()
    public void shouldThrowExceptionWhenTryingToAddTokenOnColumnGreaterThen7(){
        assertThrows(IllegalArgumentException.class, () -> grille.putToken("X", 9));
    }

    @Test()
    public void shouldThrowExceptionWhenTryingToAddTokenOnColumnLesserThen1(){
        assertThrows(IllegalArgumentException.class, () -> grille.putToken("X", 0));
    }

    @Test
    public void shouldAddTokenOnTopOfExistingTokensInColumn(){

        String[][] expectedMatrice = {
                {".", ".", ".", ".", ".", ".","."},
                {".", ".", ".", ".", ".", ".","."},
                {".", ".", ".", ".", ".", ".","."},
                {".", ".", ".", ".", ".", ".","."},
                {"X", ".", ".", ".", ".", ".","."},
                {"X", ".", ".", ".", ".", ".","."},
        };

        grille.putToken("X", 1);
        grille.putToken("X", 1);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                String result = grille.getTokenAt(i + 1, j + 1);
                assertEquals(expectedMatrice[i][j], result);
            }
        }


    }

    @Test
    public void shouldThrowExceptionWhenTryingToAddTokenOnFullColumn(){
        grille.putToken("X", 1);
        grille.putToken("X", 1);
        grille.putToken("X", 1);
        grille.putToken("X", 1);
        grille.putToken("X", 1);
        grille.putToken("X", 1);
        assertThrows(ColumnFullException.class, () -> grille.putToken("X", 1));
    }

}
