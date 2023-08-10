package Problem001;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateTest {

    @Test
    void rotateTwoSteps() {

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int steps = 2;

        int[] expected = {6, 7, 1, 2, 3, 4, 5};

        assertArrayEquals(expected, Rotate.rotateArray(array, steps));

    }

    @Test
    void rotateFiveSteps() {

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int steps = 5;

        int[] expected = {3, 4, 5, 6, 7, 1, 2};

        assertArrayEquals(expected, Rotate.rotateArray(array, steps));

    }

    @Test
    void rotateEmptyArray () {

        int[] array = new int[0];
        int steps = 5;

        assertThrowsExactly(
                IllegalArgumentException.class,
                () -> Rotate.rotateArray(array, steps),
                "El parametro nSteps debe ser mayor o igual a 0"
        );

    }

    @Test
    void returnSameArrayModularSteps () {

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int steps = array.length * 15;
        assertArrayEquals(array, Rotate.rotateArray(array, steps));

    }

}