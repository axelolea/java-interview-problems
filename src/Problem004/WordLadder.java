package Problem004;

import java.util.*;

public class WordLadder {

    public int solution (String startWord, String endWord, Set<String> dict) {

        LinkedList<WordNode> queueWords = new LinkedList<>();
        queueWords.add(new WordNode(startWord, 1));

        while (!queueWords.isEmpty()) {

            WordNode currentWordNode = queueWords.remove();
            String currentWord = currentWordNode.getWord();

            if(validChangeOneLetter(currentWord, endWord)) {
                return currentWordNode.getSteps();
            }

            Set<String> validWords = getValidWords(dict, currentWord);

            for (String word : validWords) {
                queueWords.add(new WordNode(word, currentWordNode.getSteps() + 1));
                dict.remove(word);
            }

        }

        return 0;
    }

    private static Set<String> getValidWords(Set<String> dict, String currentWord) {

        Set<String> validWords = new HashSet<>();

        for (String word : dict) {
            if (validChangeOneLetter(currentWord, word)) {
                validWords.add(word);
            }
        }

        return validWords;
    }

    private static boolean validChangeOneLetter(String word, String wordCompare) {

        boolean isValid = true;
        boolean isAvailableChange = true;

        char[] charArr = wordCompare.toCharArray();

        for (int i = 0; i < charArr.length; i++) {

            if(charArr[i] != word.charAt(i)){

                if (isAvailableChange) {
                    isAvailableChange = false;
                } else {
                    isValid = false;
                    break;
                }

            }
        }

        return isValid;
    }


    private static class WordNode {

        private final String word;
        private final int steps;

        WordNode (String word, int steps) {
            this.word = word;
            this.steps = steps;
        }

        public String getWord() {
            return word;
        }

        public int getSteps() {
            return steps;
        }

    }

}
