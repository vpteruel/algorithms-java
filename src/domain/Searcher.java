package linear.search;

public class Searcher {
    public static int linearSearch(int[] data, int targetElement) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == targetElement) {
                return i;
            }
        }
        return -1;
    }
}
