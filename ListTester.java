package winter352_Assignment2;
//NAME : ALI SHER 
//STUDENT ID : 40255236

//NAME : Olgerta Gjyriqi
//student id : 40251045




import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListTester {

    static class ListTimes {
        long insertStartMicro, insertEndMilli, insertRandomMicro;
        long removeStartMicro, removeEndMilli, removeRandomMicro, removeByValueMilli;
    }

    private static final int[] N_VALUES = {10, 100, 1000, 10000, 100000, 1000000};

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("testrun.txt")) {
            writer.write("Performance Results:\n\n");

            for (int N : N_VALUES) {
                if (N > 1000000) break; 

                long before = System.currentTimeMillis(); 

                ListTimes myArrayTimes = new ListTimes();
                ListTimes myLinkedTimes = new ListTimes();
                ListTimes arrayListTimes = new ListTimes();
                ListTimes linkedListTimes = new ListTimes();

                testMyArrayList(new MyArrayList<>(), myArrayTimes, N);
                testMyLinkedList(new MyLinkedList<>(), myLinkedTimes, N);
                testJavaList(new ArrayList<>(), arrayListTimes, N);
                testJavaList(new LinkedList<>(), linkedListTimes, N);

                long after = System.currentTimeMillis(); 

                if (after - before > 50000) { 
                    writer.write("Execution for N = " + N + " took too long. Skipping...\n");
                    break;
                }

                writer.write("N = " + N + " Insert Table:\n");
                writer.write("--------------------------------------------------------\n");
                writer.write(String.format("%-12s %-18s %-18s %-18s%n",
                        "", "Insert@start(ms)", "Insert@end(ms)", "Insert@random(ms)"));
                writer.write("--------------------------------------------------------\n");
                printInsertRow(writer, "MyArrayList", myArrayTimes);
                printInsertRow(writer, "ArrayList", arrayListTimes);
                printInsertRow(writer, "MyLinkedList", myLinkedTimes);
                printInsertRow(writer, "LinkedList", linkedListTimes);

                writer.write("\n");

                writer.write("N = " + N + " Remove Table:\n");
                writer.write("-----------------------------------------------------------------------------------------\n");
                writer.write(String.format("%-12s %-18s %-18s %-18s %-18s%n",
                        "", "Remove@start(ms)", "Remove@end(ms)", "Remove@random(ms)", "Remove by Value(ms)"));
                writer.write("-----------------------------------------------------------------------------------------\n");
                printRemoveRow(writer, "MyArrayList", myArrayTimes);
                printRemoveRow(writer, "ArrayList", arrayListTimes);
                printRemoveRow(writer, "MyLinkedList", myLinkedTimes);
                printRemoveRow(writer, "LinkedList", linkedListTimes);

                writer.write("\n\n");
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void printInsertRow(FileWriter writer, String listName, ListTimes times) throws IOException {
        writer.write(String.format("%-12s %-18d %-18d %-18d%n",
                listName, times.insertStartMicro, times.insertEndMilli, times.insertRandomMicro));
    }

    private static void printRemoveRow(FileWriter writer, String listName, ListTimes times) throws IOException {
        writer.write(String.format("%-12s %-18d %-18d %-18d %-18d%n",
                listName, times.removeStartMicro, times.removeEndMilli, times.removeRandomMicro, times.removeByValueMilli));
    }

    private static void testMyArrayList(MyArrayList<Integer> list, ListTimes times, int N) {
        runTests(list, times, N);
    }

    private static void testMyLinkedList(MyLinkedList<Integer> list, ListTimes times, int N) {
        runTests(list, times, N);
    }

    private static void testJavaList(List<Integer> list, ListTimes times, int N) {
        runTests(list, times, N);
    }

    private static void runTests(List<Integer> list, ListTimes times, int N) {
        Random rand = new Random();

        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(0, rand.nextInt(2 * N));
        }
        long end = System.nanoTime();
        times.insertStartMicro = (end - start) / 1_000_000; 
        list.clear();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(rand.nextInt(2 * N));
        }
        end = System.nanoTime();
        times.insertEndMilli = (end - start) / 1_000_000; 

        list.clear();
        start = System.nanoTime();
        for (int i = 0; i < N; i++){
            int index = (list.size() == 0) ? 0 : rand.nextInt(list.size());
            list.add(index, rand.nextInt(2 * N));
        }
        end = System.nanoTime();
        times.insertRandomMicro = (end - start) / 1_000_000; 

        list.clear();
        for (int i = 0; i < N; i++){
            list.add(rand.nextInt(2 * N));
        }
        start = System.nanoTime();
        for (int i = 0; i < N; i++){
            if (!list.isEmpty()) {
                list.remove(0);
            }
        }
        end = System.nanoTime();
        times.removeStartMicro = (end - start) / 1_000_000; 

        list.clear();
        for (int i = 0; i < N; i++){
            list.add(rand.nextInt(2 * N));
        }
        start = System.nanoTime();
        for (int i = 0; i < N; i++){
            if (!list.isEmpty()) {
                list.remove(list.size() - 1);
            }
        }
        end = System.nanoTime();
        times.removeEndMilli = (end - start) / 1_000_000; 

        list.clear();
        for (int i = 0; i < N; i++){
            list.add(rand.nextInt(2 * N));
        }
        start = System.nanoTime();
        for (int i = 0; i < N; i++){
            if (!list.isEmpty()) {
                int idx = rand.nextInt(list.size());
                list.remove(idx);
            }
        }
        end = System.nanoTime();
        times.removeRandomMicro = (end - start) / 1_000_000; 

        list.clear();
        for (int i = 0; i < N; i++){
            list.add(rand.nextInt(2 * N));
        }
        start = System.nanoTime();
        for (int i = 0; i < N; i++){
            list.remove(Integer.valueOf(rand.nextInt(2 * N)));
        }
        end = System.nanoTime();
        times.removeByValueMilli = (end - start) / 1_000_000; 
    }
}
