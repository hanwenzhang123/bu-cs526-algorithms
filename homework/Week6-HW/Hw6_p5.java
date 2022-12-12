import java.io.*;
import java.util.*;

public class Hw6_p5 {
    public static void main(String[] args) {
        ArrayList<Node> adjList = new ArrayList<>(); // Store the follow relationships in an adjacency list that implemented as an ArrayList of nodes.

        // read the file and create relationship list
        File file = new File("follows_input.txt");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            // read the file line by line
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                List<String> strList = Arrays.asList(line.split(", "));

                String firstKey = strList.get(0);
                Node firstNode = getKeyNode(firstKey, adjList);
                if (firstNode == null) {        //if we have not had the key in the list yet
                    firstNode = new Node(firstKey);     //create the node and assign to firstNode variable
                }

                // create relationship node to the adjacency list with relationships by adding edges to the first node
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
            bufferedReader.close(); //close bufferedReader

            //print out all the directly follows and indirectly follows
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
    public static Node getKeyNode(String name, ArrayList<Node> adjList) {  //Find the key node
        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).name.equals(name)) {
                return adjList.get(i);
            } else {
                ArrayList<Node> subList = adjList.get(i).list;
                for (int j = 0; j < subList.size(); j++) {
                    if (subList.get(j).name.equals(name)) {
                        return subList.get(j);
                    }
                }
            }
        }
        return null;
    }
    public static void allFollows(String name, ArrayList<Node> adjList) {  //Follow the direct and indirect relationships between nodes
        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).name.equals(name)) {

                // direct follows
                HashSet<String> direct = adjList.get(i).follows();
                System.out.println(name + " directly follows " + getString(direct));

                // indirect follow
                HashSet<String> indirect = adjList.get(i).indirectFollows();
                indirect.removeAll(direct);     //remove the direct ones
                indirect.remove(name);      //remove the first node itself
                System.out.println(name + " indirectly follows " + getString(indirect));

                break;
            }
        }
    }
    public static String getString(HashSet<String> list) {
        String str = "{";
        for (String nm : list) {
            str += nm + ", ";
        }
        str = removeSuffix(str, ", ");
        str += "}";
        return str;
    }

    public static String removeSuffix(String s, String suffix) {    //Serves as a delimiter for the string set
        if (s.endsWith(suffix)) {
            return s.substring(0, s.length() - suffix.length());
        }
        return s;
    }
}