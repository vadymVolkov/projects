package volkov.custom.linked.list;

public class CustomLinkedList {
    private Node firstNode;
    private Node lastNode;

    private class Node {
        String value;
        Node next;
    }

    public void add(String element) {
        Node node = new Node();
        node.value = element;

        if (firstNode == null) {
            firstNode = node;
            lastNode = node;
        } else {
            lastNode.next = node;
            lastNode = node;
        }
    }

    public void introduceCycle(int index) {
        Node current = firstNode;
        int currentIndex = 0;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        lastNode.next = current;
    }
    public int size (){
        int counter=0;
        Node current = firstNode;
        if (current!=null) {
            counter++;
        }
        while (current!=lastNode){
            counter++;
            current=current.next;
        }
        return counter;
    }
    public String findElement(int index){
        if (size()<index) {
            return "wrong index";
        }
        int size = size();
        int counter = size-index;
        Node current = firstNode;
        for (int i = 0; i < counter; i++) {
            current=current.next;
        }
        return current.value;
    }

    public boolean hasCycle() {
        Node turtle = firstNode;
        Node rabbit = firstNode.next.next;
        while (turtle != rabbit) {
            turtle = turtle.next;
            if (rabbit.next == null || rabbit.next.next == null) {
                return false;
            } else {
                rabbit = rabbit.next.next;
            }
            if (turtle == rabbit) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        String result = "[";
        Node current = firstNode;
        while (current != null) {
            if (result.equals("["))
                result += current.value;
            else
                result += ", " + current.value;
            current = current.next;
        }
        result += "]";
        return result;
    }

}
