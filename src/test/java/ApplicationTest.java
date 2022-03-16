import mock.VueMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import view.Vue;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {
    @Mock Grille grille;
    @Mock Vue vue = new VueMock();
    Application application;

    String GRID_PLACEHOLDER = "This is the placeholder for the grid";
    String FIRST_TO_PLAY = "Player X starts";
    String ASK_TO_PLAY_MESSAGE = "Please choose a column: ";

    @BeforeEach
    void init(){
        application = new Application(grille, vue);

        when(grille.toString()).thenReturn(GRID_PLACEHOLDER);
    }

    @Test
    void shouldCallPrintTheGridOnStart(){
        application.start();
        InOrder inOrder = inOrder(vue);

        inOrder.verify(vue).write(GRID_PLACEHOLDER);
    }

    @Test
    void shouldCallPrintTheFirstTourAfterGridToString(){
        application.start();

        InOrder inOrder = inOrder(vue);

        inOrder.verify(vue).write(GRID_PLACEHOLDER);
        inOrder.verify(vue).write(FIRST_TO_PLAY);
    }

    @Test
    void shouldAskTheFirstUserToChooseAColumn(){
        application.start();

        InOrder inOrder = inOrder(vue);

        inOrder.verify(vue).write(GRID_PLACEHOLDER);
        inOrder.verify(vue).write(FIRST_TO_PLAY);
        inOrder.verify(vue).write(ASK_TO_PLAY_MESSAGE);
    }

    @Test
    void shouldReadColumnAndCallGridToInsert(){
        when(vue.read()).thenReturn(3);
        application.start();

        InOrder inOrder = inOrder(vue, grille);

        inOrder.verify(vue).write(GRID_PLACEHOLDER);
        inOrder.verify(vue).write(FIRST_TO_PLAY);
        inOrder.verify(vue).write(ASK_TO_PLAY_MESSAGE);
        inOrder.verify(vue).read();
        inOrder.verify(grille).putToken("X", 3);
    }

    @Test
    void shouldPrintUpdatedGridAfterInsertion(){
        when(vue.read()).thenReturn(3);

        application.start();

        InOrder inOrder = inOrder(vue, grille);

        inOrder.verify(grille).putToken("X", 3);
        inOrder.verify(vue).write(GRID_PLACEHOLDER);
    }
}
