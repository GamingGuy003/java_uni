public class Main {
    public static void main(String[] args) {
        System.out.println(larger(2, 1));
        String[] names = new String[] { "name1", "name2", "name3"};
        for (int i = names.length -1; i >= 0; i--) {
            System.out.println(names[i]);
        }
    }

    public static boolean larger(double first, double second) {
        return first > second;
    }
}