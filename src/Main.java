public class Main {

    static final int ARRAY_SIZE = 50_000;

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Searchers Benchmark ########################################");

        new searchers.Benchmark()
                .setup(ARRAY_SIZE)
                .executeSearchers();

        System.out.println();
        System.out.println("Sorters Benchmark ##########################################");

        new sorters.Benchmark()
                .setup(ARRAY_SIZE)
                .executeSorters();
    }
}
