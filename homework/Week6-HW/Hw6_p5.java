import java.io.*;
import java.util.*;

public class Hw6_p5 {
    public static void main(String[] args) {
        ArrayList<Node> adjList = new ArrayList<>();

        // read the file and create relationship list
        File file = new File("follows_input.txt");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            // read the file line by line
            String line;
            while ((line = br.readLine()) != null) {

                List<String> strList = Arrays.asList(line.split(", "));

                String firstKey = strList.get(0);
                Node firstNode = getKeyNode(firstKey, adjList);
                if (firstNode == null) {
                    firstNode = new Node(firstKey);
                }

                // create relationship node to the adjacency list with relationships
                for (int i = 1; i < strList.size(); i++) {
                    String key = strList.get(i);
                    Node keyNode = getKeyNode(key, adjList);
                    if (keyNode == null) {
                        keyNode = new Node(key);
                    }
                    firstNode.addEdge(keyNode);
                }

                // add relationship node to adjacency list
                adjList.add(firstNode);
            }
            br.close();

            allFollows("A", adjList);
            allFollows("B", adjList);
            allFollows("C", adjList);
            allFollows("D", adjList);
            allFollows("E", adjList);
            allFollows("F", adjList);
            allFollows("G", adjList);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String removeSuffix(String s, String suffix) {    //Serves as a delimiter for the string set
        if (s.endsWith(suffix)) {
            return s.substring(0, s.length() - suffix.length());
        }
        return s;
    }

    static String getSetString(HashSet<String> list) {
        String str = "{";
        for (String nm : list) {
            str += nm + ", ";
        }
        str = removeSuffix(str, ", ");
        str += "}";
        return str;
    }
    static void allFollows(String name, ArrayList<Node> adjList) {  //Follow the direct and indirect relationships between nodes
        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).name.equals(name)) {

                // direct follows
                HashSet<String> direct = adjList.get(i).follows();
                System.out.println(name + " directly follows " + getSetString(direct));

                // indirect follow
                HashSet<String> indirect = adjList.get(i).indirectFollows();
                indirect.removeAll(direct);
                indirect.remove(name);
                System.out.println(name + " indirectly follows " + getSetString(indirect));

                break;
            }
        }
    }
    static Node getKeyNode(String name, ArrayList<Node> adjList) {  //Find the key node
        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).name.equals(name)) {
                return adjList.get(i);
            } else {
                ArrayList<Node> sublist = adjList.get(i).list;
                for (int j = 0; j < sublist.size(); j++) {
                    if (sublist.get(j).name.equals(name)) {
                        return sublist.get(j);
                    }
                }
            }
        }
        return null;
    }
}