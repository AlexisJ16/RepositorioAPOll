public class Node {

    private int number;

    private int back;
    private Node next;
    private Node previous;

    public Node(int number) {
        this.number = number;
        this.back = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }


    public int getBack() {
        return back;
    }

    public void addBack() {
        this.back += 1;
    }
}