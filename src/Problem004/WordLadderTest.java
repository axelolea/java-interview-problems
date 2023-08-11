package Problem004;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {

    @Test
    void validFirstTest () {

        String start = "hit";
        String end = "cog";
        String[] dictArr = {"hot","dot","dog","lot","log"};
        Set<String> dict = Arrays.stream(dictArr).collect(Collectors.toSet());

        WordLadder wl = new WordLadder();

        assertEquals(4, wl.solution(start, end, dict));

    }

    @Test
    void validSecondTest () {

        String start = "main";
        String end = "lips";
        String[] dictArr = {"lain","lawn","laws","laps","malo","maio","malo","nalo"};
        Set<String> dict = Arrays.stream(dictArr).collect(Collectors.toSet());

        WordLadder wl = new WordLadder();

        assertEquals(5, wl.solution(start, end, dict));

    }

}