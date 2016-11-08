package volkov.custom.linked.list;

public class Main {
    public static void main(String[] args) {

        CustomLinkedList list = new CustomLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");

        //list.introduceCycle(4);

        if (!list.hasCycle()) {
            System.out.println(list);
        } else {
            System.out.println("list has Cycle");
        }


        System.out.println(list.findElement(2));
    }
}
