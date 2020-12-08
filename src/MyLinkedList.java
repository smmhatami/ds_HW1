public class MyLinkedList {
    private final Node head;
    private Node current;

    public MyLinkedList() {
        this.head = new Node('\0', null, null);
        this.current = this.head;
    }

    public void insert(char ch) {
        Node newNode = new Node(ch, current.getNext(), current);
        if (current.hasNext())
            current.getNext().setLast(newNode);
        current.setNext(newNode);
        current = newNode;
    }

    public void erase() {
        if (current.hasNext())
            current.getNext().setLast(current.getLast());
        if (current.hasLast())
            current.getLast().setNext(current.getNext());
        goLeft();

    }

    public void goRight() {
        if (current.hasNext())
            current = current.getNext();
    }

    public void goLeft() {

        if (current.hasLast())
            current = current.getLast();
    }

    public String print() {
        Node node = head.getNext();
        StringBuilder output = new StringBuilder();
        while (node != null) {
            output.append(node.getChar());
            node = node.getNext();
        }
        return output.toString();
    }
}

class Node {
    private final char ch;
    private boolean isNull;
    private Node next;
    private Node last;

    public Node(char ch, Node next, Node last) {
        this.ch = ch;
        if (ch == '\0')
            isNull = true;
        this.next = next;
        this.last = last;
    }

    public char getChar() {
        return ch;
    }

    public Node getNext() {
        return next;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasLast() {
        return last != null;
    }
}