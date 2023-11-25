import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameGenerator {
    public String generateName() {
        int length = new Random().nextInt(2, 12);
        // counts consecutive consonants
        int consonantCount = 0;
        String name = "";

        // vowels
        List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

        // alphabet is all letters + special letters
        List<Character> alphabet = new ArrayList<>(List.of('å', 'æ', 'ø'));
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }

        // consonants are alphabet - vowels
        List<Character> consonants = new ArrayList<>(alphabet);
        consonants.removeAll(vowels);

        for (int i = 0; i < length;) {
            Character letter = alphabet.get(new Random().nextInt(0, alphabet.size() - 1));
            // increment consecutive consonants or reset of letter was not a consonant
            if (consonants.contains(letter)) {
                consonantCount++;
            } else {
                consonantCount = 0;
            }

            // unless this is the 4th consonant in a row, add to name
            if (consonantCount <= 3) {
                name = name + letter;
                i++;
            }
        }
        return name;
    }
}
