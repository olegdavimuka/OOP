import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 class results {
     static Map<String, Integer> scoreBoard = new HashMap<>();

     static void modifyResults() {
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\XO\\Results.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            for (Map.Entry entry : scoreBoard.entrySet()) {
                fw.write(entry.getKey() + "\n" + entry.getValue());
                fw.write("\n");
            }
        } catch (IOException exception) {
            System.out.println( "IOException handled");
        } finally {
            try {
                fw.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
    static void getResults() {
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\XO\\Results.txt");
        scoreBoard.clear();
        try {
            Scanner sc = new Scanner(new FileReader(file));
            while (sc.hasNextLine()) {
                scoreBoard.put(sc.nextLine(),Integer.parseInt(sc.nextLine()));
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
    }
    static void printResults() {
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\XO\\Results.txt");
        try {
            Scanner sc = new Scanner(new FileReader(file));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
    }
    static void clearResults() {
        scoreBoard.clear();
        modifyResults();
    }
    static void champSearch() {
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : scoreBoard.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        System.out.println(maxEntry);
    }
}
