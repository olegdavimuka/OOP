import java.util.*;

public class Test {

    private static UndirectedGraph graph;
//    private static List<String> visited = new LinkedList<>();
//    private static List<String> visited1 = new LinkedList<>();
//    private static JQueue queue = new JQueue(100);
//    private static int length, count = 0;


//    private static void dfs(String start) {
//        if (visited.contains(start)) return;
//        visited.add(start);
//
//        Map<String, List<String>> map = graph.getNodeMap();
//        List<String> adjacentNodes = map.get(start);
//
//        for (String string : adjacentNodes) {
//            if (visited.contains(string)) continue;
//        }
//    }

//    private static void bfs(String begin, String end) {
//        visited1.add(begin);
//
//        queue.insert(begin);
//
//        Map<String, List<String>> map = graph.getNodeMap();
//
//        while (!queue.isEmpty()) {
//            String current = queue.pop();
//            List<String> adjacentNodes = map.get(current);
//            for (String string : adjacentNodes) {
//                if (visited1.contains(string)) continue;
//                visited1.add(string);
//                queue.insert(string);
//                if (string.equals(end)) return;
//            }
//        }
//    }

    public static void main(String[] args) {
        graph = new UndirectedGraph();
        Scanner sc = new Scanner(System.in);
        String node, connection1, connection2, input;
        int id;

        while (true) {
            System.out.println("Possible input: \n1. Add node \n2. Add connection \n3. Print map \n" +
                    "4. Get id of name. \n5. Get name of id \n6. Get node`s count \n7. Print connections" +
                    "\n8. Node exists? \n9. Connection exists? "/*\nIf you want to stop print stop"*/);

            while (true) {
                input = sc.nextLine();
                if ((input.equals("1")) || (input.equals("2")) || (input.equals("3")) || (input.equals("4"))
                        || (input.equals("5")) || (input.equals("6")) || (input.equals("7")) || (input.equals("8"))
                        || (input.equals("9"))) break;
                System.out.println("Wrong input. Type 1-9.");
            }

            graph.addConnection("A", "B");
            graph.addConnection("A", "E");
            graph.addConnection("B", "C");
            graph.addConnection("B", "E");
            graph.addConnection("C", "F");
            graph.addConnection("E", "F");
            graph.addConnection("F", "I");
            graph.addConnection("D", "G");
            graph.addConnection("D", "H");
            graph.addConnection("G", "H");

            switch (input) {
                case "1":
                    System.out.println("Input name");
                    node = sc.nextLine();
                    graph.addNode(node);
                    System.out.println("The node has been added.");
                    break;
                case "2":
                    System.out.println("Node 1:");
                    connection1 = sc.nextLine();
                    System.out.println("Node 2:");
                    connection2 = sc.nextLine();
                    graph.addConnection(connection1.toUpperCase(), connection2.toUpperCase());
                    System.out.println("Connection has been added.");
                    break;
                case "3":
                    System.out.println(graph.getNodeMap());
                    break;
                case "4":
                    System.out.println("Input name:");
                    node = sc.nextLine();
                    System.out.println(graph.getName(node));
                    break;
                case "5":
                    System.out.println("Input id:");
                    id = sc.nextInt();
                    System.out.println(graph.getId(id));
                    break;
                case "6":
                    System.out.println(UndirectedGraph.count);
                    break;
                case "7":
                    System.out.println("Input node:");
                    node = sc.nextLine();
                    System.out.println(graph.getConnections(node));
                    break;
                case "8":
                    System.out.println("Input node:");
                    node = sc.nextLine();
                    System.out.println(graph.hasNode(node));
                    break;
                case "9":
                    System.out.println("Node 1:");
                    connection1 = sc.nextLine();
                    System.out.println("Node 2:");
                    connection2 = sc.nextLine();
                    System.out.println(graph.hasConnection(connection1.toUpperCase(), connection2.toUpperCase()));
                    break;

            }
//            System.out.println("Do you want to continue?");
//            if (sc.nextLine().equals("stop")) break;

//            bfs("A","E");
//            System.out.println("breadth-first search");
//            for (String string : visited1) {
//                System.out.print(string + " ");
//            }
//            System.out.println(length);
        }
    }
}