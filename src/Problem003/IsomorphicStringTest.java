package Problem003;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsomorphicStringTest {

    @Test
    void isIsomorphicFirstsTrueTest() {

        String string1 = "add";
        String string2 = "egg";

        IsomorphicString is = new IsomorphicString();

        assertTrue(is.isIsomorphic(string1, string2));

    }

    @Test
    void isIsomorphicFirstsFalseTest() {

        String string1 = "foo";
        String string2 = "bar";

        IsomorphicString is = new IsomorphicString();

        assertFalse(is.isIsomorphic(string1, string2));

    }

    @Test
    void isIsomorphicNullArgsTest() {

        IsomorphicString is = new IsomorphicString();

        assertThrows(
                IllegalArgumentException.class,
                () -> is.isIsomorphic(null, null),
                "Strings invalidos."
        );

    }

    @Test
    void isIsomorphicDistinctLengthArgsTest () {

        String string1 = "hola";
        String string2 = "adios";

        IsomorphicString is = new IsomorphicString();

        assertFalse(is.isIsomorphic(string1, string2));

    }

}