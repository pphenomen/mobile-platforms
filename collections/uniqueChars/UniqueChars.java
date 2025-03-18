import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UniqueChars {

    private Map<Character, Integer> charCountMap = new HashMap<>();
    private Map<String, Integer> wordCountMap = new HashMap<>();
    private Map<Character, Integer> digitCountMap = new HashMap<>();
    private Map<Character, Integer> upperCaseLetterCountMap = new HashMap<>();
    private Map<Character, Integer> lowerCaseLetterCountMap = new HashMap<>();
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // Задание 1: Подсчет букв
    public void calculateLetterCount() {
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }
    }

    // Задание 2: Подсчет слов
    public void calculateWordCount() {
        String[] words = text.split("\\s+"); // Разделяем текст на слова по пробелам
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
    }

    // Задание 3: Подсчет символов
    public void calculateSymbolCount() {
        for (char c : text.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
    }

    // Задание 4: Подсчет букв только в указанном регистре (верхнем, нижнем)
    public void calculateCaseSensitiveLetterCount() {
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCaseLetterCountMap.put(c, upperCaseLetterCountMap.getOrDefault(c, 0) + 1);
            } else if (Character.isLowerCase(c)) {
                lowerCaseLetterCountMap.put(c, lowerCaseLetterCountMap.getOrDefault(c, 0) + 1);
            }
        }
    }

    // Задание 5: Подсчет цифр
    public void calculateDigitCount() {
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCountMap.put(c, digitCountMap.getOrDefault(c, 0) + 1);
            }
        }
    }

    // Метод для вывода результатов подсчета букв
    public String getLetterCountResult() {
        StringBuilder result = new StringBuilder("Letter Count:\n");
        for (Entry<Character, Integer> entry : charCountMap.entrySet()) {
            result.append("char: ").append(entry.getKey()).append(", count: ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

    // Метод для вывода результатов подсчета слов
    public String getWordCountResult() {
        StringBuilder result = new StringBuilder("Word Count:\n");
        for (Entry<String, Integer> entry : wordCountMap.entrySet()) {
            result.append("word: ").append(entry.getKey()).append(", count: ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

    // Метод для вывода результатов подсчета символов
    public String getSymbolCountResult() {
        StringBuilder result = new StringBuilder("Symbol Count:\n");
        for (Entry<Character, Integer> entry : charCountMap.entrySet()) {
            result.append("symbol: ").append(entry.getKey()).append(", count: ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

    public String getUpperCaseLetterCountResult() {
        StringBuilder result = new StringBuilder("Upper Case Letter Count:\n");
        for (Entry<Character, Integer> entry : upperCaseLetterCountMap.entrySet()) {
            result.append("char: ").append(entry.getKey()).append(", count: ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

    public String getLowerCaseLetterCountResult() {
        StringBuilder result = new StringBuilder("Lower Case Letter Count:\n");
        for (Entry<Character, Integer> entry : lowerCaseLetterCountMap.entrySet()) {
            result.append("char: ").append(entry.getKey()).append(", count: ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

    public String getDigitCountResult() {
        StringBuilder result = new StringBuilder("Digit Count:\n");
        for (Entry<Character, Integer> entry : digitCountMap.entrySet()) {
            result.append("digit: ").append(entry.getKey()).append(", count: ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        UniqueChars uniqueChars = new UniqueChars();
        uniqueChars.setText("Hello, World! 12345.");

        uniqueChars.calculateLetterCount();
        uniqueChars.calculateWordCount();
        uniqueChars.calculateSymbolCount();
        uniqueChars.calculateCaseSensitiveLetterCount();
        uniqueChars.calculateDigitCount();

        System.out.println(uniqueChars.getLetterCountResult());
        System.out.println(uniqueChars.getWordCountResult());
        System.out.println(uniqueChars.getSymbolCountResult());
        System.out.println(uniqueChars.getUpperCaseLetterCountResult());
        System.out.println(uniqueChars.getLowerCaseLetterCountResult());
        System.out.println(uniqueChars.getDigitCountResult());
    }
}
