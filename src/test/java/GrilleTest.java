import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrilleTest {
    @Test
    public void shouldHave6LinesAfterInitialisation(){
        Grille grille = new Grille();
        int result = grille.getMatrice().length;

        assertEquals(6, result);
    }
}
