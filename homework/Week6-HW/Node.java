import java.util.*;

public class Node {
    String name;
    ArrayList<Node> list;

    Node(String name) {
        this.name = name;
        list = new ArrayList<>();
    }

    void addEdge(Node node) {
        list.add(node);
    }

    public HashSet<String> follows() {  //Direct follows
        HashSet<String> setNode = new HashSet<>();

        if (list.size() == 0) {
            return setNode;
        }

        for (int i = 0; i < list.size(); i++) {
            setNode.add(list.get(i).name);
        }
        return setNode;
    }
    
    public HashSet<String> indirectFollows() {  //Indirect Follows
        HashSet<String> setNode = new HashSet<>();
        setNode.add(name);
        for (int i = 0; i < list.size(); i++) {
            setNode.addAll(list.get(i).indirectFollows());
        }
        return setNode;
    }
}