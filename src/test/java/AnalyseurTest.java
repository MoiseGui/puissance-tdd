import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnalyseurTest {
    @Mock
    Grille grille;

    @Test
    public void shouldReturnXWhenGivenFourHorizontalXsOnLine() {
        List<String[]> lines = List.of(
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", "O", "O", "O", ".", ".", "."},
                new String[]{".", "X", "X", "X", "X", ".", "."}
        );
        when(grille.getLines()).thenReturn(lines);

        Optional<String> result = Analyseur.analyseGrille(grille);

        assertEquals("X", result.get());
    }

    @Test
    void shouldReturnOWhenGivenFourHorizontalOsOnLine() {
        List<String[]> lines = List.of(
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", "O", "O", "O", "O", ".", "."},
                new String[]{".", "X", "X", "X", "O", ".", "."}
        );
        when(grille.getLines()).thenReturn(lines);

        Optional<String> result = Analyseur.analyseGrille(grille);

        assertEquals("O", result.get());
    }

    @Test
    void shouldReturnXWhenGivenFourVerticalXsOnLine() {
        List<String[]> columns = List.of(
                new String[]{".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", "."},
                new String[]{".", "O", "O", "O", ".", "."},
                new String[]{".", "X", "X", "X", "X", "."}
        );
        when(grille.getColumns()).thenReturn(columns);

        Optional<String> result = Analyseur.analyseGrille(grille);

        assertEquals("X", result.get());
    }

    @Test
    void shouldReturnXWhenGivenFourDiagonalX() {
        List<String[]> diagonals = List.of(
                new String[]{"."},
                new String[]{".", "X"},
                new String[]{".", "O", "O"},
                new String[]{".", ".", "X", "X"},
                new String[]{".", ".", ".", "O", "X"},
                new String[]{".", ".", ".", "X", "O", "."},
                new String[]{".", ".", ".", ".", "0", "."},
                new String[]{".", ".", ".", "X", "."},
                new String[]{".", ".", ".", "."},
                new String[]{".", ".", "."},
                new String[]{".", "."},
                new String[]{"."},
                new String[]{"."},
                new String[]{"X", "X", "X", "X", "."}
                );

        when(grille.getDiagonals()).thenReturn(diagonals);

        Optional<String> result = Analyseur.analyseGrille(grille);

        assertEquals("X", result.get());
    }

    @Test
    void shouldReturnEmptyWhenGivenNoWinner() {
        List<String[]> lines = List.of(
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", ".", ".", ".", ".", ".", "."},
                new String[]{".", "O", "O", "O", ".", ".", "."},
                new String[]{".", "X", "X", "X", ".", ".", "."}
        );
        when(grille.getLines()).thenReturn(lines);
        when(grille.getColumns()).thenReturn(lines);
        when(grille.getDiagonals()).thenReturn(lines);

        Optional<String> result = Analyseur.analyseGrille(grille);

        assertFalse(result.isPresent());
    }
}
