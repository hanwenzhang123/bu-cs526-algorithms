import java.util.*;

public class Node {
    String name;    //the name of the person
    ArrayList<Node> list;   //a reference include all people the person directly follows.

    Node(String name) {
        this.name = name;
        list = new ArrayList<>();
    }

    void addEdge(Node node) {
        list.add(node);
    }

    public HashSet<String> follows() {  //Direct follows
        HashSet<String> setNode = new HashSet<>();  //use set to keep uniqueness
        if (list.size() == 0) {
            return setNode;
        }
        for (int i = 0; i < list.size(); i++) {
            setNode.add(list.get(i).name);
        }
        return setNode;
    }

    public HashSet<String> indirectFollows() {  //Indirect Follows
        HashSet<String> setNode = new HashSet<>();  //use set to keep uniqueness
        setNode.add(name);
        for (int i = 0; i < list.size(); i++) {
            setNode.addAll(list.get(i).indirectFollows());
        }
        return setNode;
    }
}