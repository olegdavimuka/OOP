import java.util.*;

class UndirectedGraph {

    static int count = 0;
    private HashMap<String, List<String>> nodeMap = new HashMap<>();
    private HashMap<Integer, String> countMap = new HashMap<>();
    private HashMap<String, Integer> nameMap = new HashMap<>();

     void addNode(String name) {
        if (!hasNode(name)) {
            nodeMap.put(name, new ArrayList<>());
            countMap.put(++count, name);
            nameMap.put(name,count);
        }
    }

    void addConnection(String node1, String node2) {
        if (!hasNode(node1)) addNode(node1);
        if (!hasNode(node2)) addNode(node2);
        List<String> connections1 = nodeMap.get(node1);
        List<String> connections2 = nodeMap.get(node2);
        if (!connections1.contains(node2)) connections1.add(node2);
        if (!connections2.contains(node1)) connections2.add(node1);
        Collections.sort(connections1);
        Collections.sort(connections2);
    }

     boolean hasNode(String nodeName) {
        return nodeMap.containsKey(nodeName);
    }

    boolean hasConnection(String node1, String node2) {
        if (!hasNode(node1)) return false;
        List<String> connections = nodeMap.get(node1);
        return Collections.binarySearch(connections, node2) != -1;
    }

    List<String> getConnections(String name) {
        if (nodeMap.get(name) != null) {
            return nodeMap.get(name);
        } else {
            List<String> list = new LinkedList<>();
            list.add("No connections");
            return list;
        }
    }

    Map<String, List<String>> getNodeMap() {
        return nodeMap;
    }

    String getId(int id) {
        if (countMap.get(id) != null) {
            return countMap.get(id);
        } else {
            return "No node with such Id.";

        }
    }

    int getName(String name) {
        if (nameMap.get(name) != null) {
            return nameMap.get(name);
        } else {
            return -1;
        }
    }
}