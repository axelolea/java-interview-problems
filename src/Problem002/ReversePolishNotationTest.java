package Problem002;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    @Test
    void evaluateFirstArray() {

        String[] array = {"2", "1", "+", "3", "*"};

        assertEquals(9, ReversePolishNotation.evaluate(array));

    }

    @Test
    void evaluateSecondArray () {

        String[] array = {"4", "13", "5", "/", "+"};

        assertEquals(6, ReversePolishNotation.evaluate(array));

    }

    @Test
    void evaluateArrayWithOnlyNumbers () {

        String[] array = {"1", "3", "4", "5", "4"};

        assertThrowsExactly(
                RuntimeException.class,
                () -> ReversePolishNotation.evaluate(array),
                "Sobran elementos en la pila de numeros"
        );

    }

    @Test
    void evaluateArrayWithOnlyOperators () {

        String[] array = {"*", "-", "/", "+"};

        assertThrowsExactly(
                RuntimeException.class,
                () -> ReversePolishNotation.evaluate(array),
                "Faltan valores numericos"
        );

    }

    @Test
    void evaluateArrayWithInvalidValueInArray () {

        String invalidValue = "4e";
        String[] array = {"3", "4", "*", invalidValue};

        assertThrowsExactly(
                IllegalArgumentException.class,
                () -> ReversePolishNotation.evaluate(array),
                "El array contiene un valor invalido: [" + invalidValue + "]"
        );

    }

}