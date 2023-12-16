import java.util.Scanner;

class Sentence {

    public static void main(String[] args) {
        System.out.print("Input sentence: ");
        Sentence s = new Sentence(new Scanner(System.in).nextLine());
        s.determineLongest();
        s.determineDuplicates();
        s.invertWords();
        s.invertLetters();
    }
    private String[] words = {};

    Sentence(String sentence) {
        this.words = sentence.split(" ");
    }

    public void determineLongest() {
        String longest = "";
        for (String word: this.words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        System.out.println("Longest word was: " + longest + ", with a length of: " + longest.length());
    }

    public void determineDuplicates() {
        String dupes = "";
        for (String word: this.words) {
            if (dupes.contains(word)) {
                System.out.println("Duplicated entry: " + word);
            }
            dupes += word + " ";
        }
    }

    public void invertWords() {
        for (int i = this.words.length -1; i >= 0; i--) {
            System.out.print(this.words[i] + " ");
        }
        System.out.println();
    }

    public void invertLetters() {
        for (int i = this.words.length -1; i >= 0; i--) {
            for (int j = this.words[i].length() -1; j >= 0; j--) {
                System.out.print(this.words[i].charAt(j));
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
