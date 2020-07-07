package by.epamtc.mtv.viaryshko.secondtask;
import java.math.BigInteger;


public class StringModification {

    private String stringForModification;
    private String stringWithoutSpaces;

    public StringModification(String stringForModification) {

        this.stringForModification = stringForModification;
        stringWithoutSpaces = receiveStringWithoutSpaces();

    }

    //Четные и нечетные символы разделить по разным строкам
    public void shareByParity() {

        StringBuilder evenCharacters = new StringBuilder();
        StringBuilder oddCharacters = new StringBuilder();

        for (int i = 0; i < stringWithoutSpaces.length(); i++) {

            if (i % 2 == 0) {
                evenCharacters.append(stringWithoutSpaces.charAt(i));
            } else {
                oddCharacters.append(stringWithoutSpaces.charAt(i));
            }
        }
        System.out.println("Строка с чётными символами:" + " " + evenCharacters.toString());
        System.out.println("Строка с нечётными символами:" + " " + oddCharacters.toString());
    }

    //Процентное соотношение строчных и прописных букв
    public void receivePercentForUpperLowerCase() {

        int counterForLower = 0;
        int counterForUpper = 0;
        char[] arrayForString = stringWithoutSpaces.toCharArray();
        for (char x : arrayForString) {
            if (Character.isUpperCase(x)) {
                counterForUpper++;
            } else {
                counterForLower++;
            }
        }
        System.out.println("Процент прописных букв:" + " " + (double) counterForUpper / (counterForUpper + counterForLower) * 100);
        System.out.println("Процент строчных букв:" + " " + (double) counterForLower / (counterForUpper + counterForLower) * 100);
    }

    //Удаление одинаковых символов
    public String receiveWithoutDuplicateCharacters() {

        StringBuilder stringWithoutDuplicate = new StringBuilder();
        int index;
        for (int i = 0; i < stringForModification.length(); i++) {
            char c = stringForModification.charAt(i);
            index = stringForModification.indexOf(c, i + 1);
            if (index == -1) {
                stringWithoutDuplicate.append(c);
            }
        }
        return stringWithoutDuplicate.toString();
    }

    //Частота встречаемости символа в строке
    public int receiveCountSymbol(char symbolForFind) {

        int counter = 0;
        for (int i = 0; i < stringForModification.length(); i++) {
            if (stringForModification.charAt(i) == symbolForFind) {
                counter++;
            }
        }
        return counter;
    }

    //Переворот строки
    public String receiveReverseString() {

        StringBuilder reversedString = new StringBuilder(stringForModification);
        return reversedString.reverse().toString();

    }

    //Вставка подстроки
    public String receiveWithSubstring(int position, String substring) {

        if (position < 0 || position > stringForModification.length()) {
            return "Проверьте ввод данных!";
        } else {
            StringBuilder stringWithSubstring = new StringBuilder(stringForModification);
            stringWithSubstring.insert(position, substring);
            return stringWithSubstring.toString();
        }
    }

    //Удаление подстроки
    public String receiveWithoutSubstring(int start, int finish) {

        if (start < 0 || start > stringForModification.length() || finish < 0 || finish > stringForModification.length()) {

            return "Проверьте ввод данных!";
        } else {
            StringBuilder stringWithoutSubstring = new StringBuilder(stringForModification);
            stringWithoutSubstring.delete(start, finish);
            return stringWithoutSubstring.toString();
        }
    }

    //Копирование части строки
    public String receiveCopiedString(int start, int finish) {
        if (start < 0 || start > stringForModification.length() || finish < 0 || finish > stringForModification.length()) {

            return "Проверьте ввод данных!";
        } else {
            String copiedString = stringForModification.substring(start, finish);
            return copiedString;
        }
    }

    //Определение длины строки
    public int receiveLength() {

        return stringForModification.length();
    }

    //Количество вхождений подстроки в строку
    public int receiveAmountOFSubstring(String substring) {
        String[] splitArray = stringForModification.split(substring);
        return splitArray.length - 1;
    }


    //Вывести слова строки в обратном порядке
    public String receiveWordsInReversOrder() {

        StringBuilder wordsForReversOrder = new StringBuilder();
        String[] words = stringForModification.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            wordsForReversOrder.append(words[i] + " ");
        }

        return wordsForReversOrder.toString();
    }

    //Заменить пробел и группы пробелов символом "*"
    public String receiveWithChangeSpacesOnStar() {
        return stringForModification.replaceAll("\\s+", "*");

    }

    //Заменить в самом длинном слове строки буквы 'a' на 'b'
    public void changeAOnBInLongerWord() {

        System.out.print("Слова(о) максимальной длины с заменой a на b:" + " ");
        String[] words = stringForModification.split("\\s+");
        int maxLength = words[0].length();
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        for (String word : words) {
            if (word.length() == maxLength) {
                System.out.print(word.replaceAll("a", "b") + " ");
            }
        }
        System.out.println();
    }

    //Определить длину самого короткого слова в строке
    public int receiveMinWordLength() {

        String[] words = stringForModification.split("\\s+");
        int minLength = words[0].length();
        for (String word : words) {
            if (word.length() < minLength) {
                minLength = word.length();
            }
        }
        return minLength;
    }

    //Подсчет количества слов в строке
    public int receiveCountQuantityOfWords() {
        String[] words = stringForModification.split("\\s+");
        return words.length;
    }

    //Поменять слова местами
    public String receiveWithSwap(int replaceableIndex, int replacementIndex) {

        String[] words = stringForModification.split("\\s+");
        if (words.length == 1) {
            return words[0];
        } else if (replacementIndex < 0 || replacementIndex > words.length || replaceableIndex < 0 || replaceableIndex > words.length) {
            return "Проверьте ввод данных!";
        } else {
            StringBuilder stringWithSwap = new StringBuilder();
            String stringForChange = words[replaceableIndex];
            words[replaceableIndex] = words[replacementIndex];
            words[replacementIndex] = stringForChange;

            for (String word : words) {
                stringWithSwap.append(word + " ");
            }
            return stringWithSwap.toString();
        }
    }

    //Удаление последнего слова в строке
    public String receiveWithoutLastWord() {

        StringBuilder stringWithoutLastWord = new StringBuilder();
        String[] words = stringForModification.split("\\s+");
        for (int i = 0; i < words.length - 1; i++) {
            stringWithoutLastWord.append(words[i] + " ");
        }
        return stringWithoutLastWord.toString();
    }

    // Добавление пробелов в строку
    public String receiveWithAddedSpace(int position) {
        String space = " ";
        if (position < 0 || position > stringForModification.length()) {

            return "Проверьте ввод данных!";
        } else {
            StringBuilder stringWithSubstring = new StringBuilder(stringForModification);
            stringWithSubstring.insert(position, space);
            return stringWithSubstring.toString();
        }
    }

    //Является ли строка палиндром?
    public boolean receiveResultForPalindrom() {

        int counter = 0;
        char[] arrayForString = stringForModification.toCharArray();
        for (int i = 0; i < arrayForString.length / 2; i++) {
            if (arrayForString[i] != arrayForString[arrayForString.length - i - 1]) {
                counter++;
            }
        }
        return counter <= 0;
    }

    //замена  подстроки в строке
    public String receiveReplacedSubstringInString(String regex, String substring) {
        return stringForModification.replaceAll(regex, substring);
    }

    //Сложение очень длинных целых чисел
    public BigInteger receiveAdditionedBigNumber(String firstNumber, String secondNumber) {
        BigInteger firstValue = new BigInteger(firstNumber);
        BigInteger secondValue = new BigInteger(secondNumber);
        return firstValue.add(secondValue);

    }

    //Удаление из строки слов заданной длины
    public String receiveWithoutDeleteWordsForLength(int length) {

        StringBuilder stringWithoutDeleted = new StringBuilder();
        String[] words = stringForModification.split("\\s+");
        for (String word : words) {
            if (word.length() != length) {
                stringWithoutDeleted.append(word);
            }
        }
        return stringWithoutDeleted.toString();
    }

    //Удаление лишних пробелов
    public String receiveWithoutExcessSpaces() {
        return stringForModification.replaceAll("\\s+", " ");
    }

    //Выделение слов из строки
    public void receiveSelection(String delimiter) {
        receiveWithoutExcessSpaces();
        String[] words = stringForModification.split(delimiter);
        for (String word : words) {
            System.out.println(word);
        }
    }

    //получение строки без пробелов
    public String receiveStringWithoutSpaces() {
        return stringForModification.replaceAll(" ", "");
    }
}