public class CircularList {

    private Node actual;

    private Node head;

    public void addNode(Node node){
        if(head == null){
            head = node;
            head.setNext(head);
            head.setPrevious(head);
            actual = head;
            actual.addBack();
        }else{
            Node tail = head.getPrevious();
            node.setNext(head);
            head.setPrevious(node);
            tail.setNext(node);
            node.setPrevious(tail);
        }
    }

    public void print(){
        if(head == null){
            System.out.println("No hay turnos aun");
        }else{
            print(head);
        }
    }

    private void print(Node current){
        if(current == head.getPrevious()){
            System.out.println(current.getNumber());
            return;
        }
        System.out.println(current.getNumber());
        print(current.getNext());
    }


    public void delete(int number){
        if(head.getNumber() == number){
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            this.head = head.getNext();
            return;
        }
        deleteNode(head.getNext() ,number);
    }

    private void deleteNode(Node current, int number){
        if(current.equals(head)) return;
        if(current.getNumber() == number){
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        }
        deleteNode(current.getNext() ,number);
    }


    public void skipTurn(){
        if (head == null){
            System.out.println("No hay turnos aun");
        }else{
            actual = actual.getNext();
            actual.addBack();
            if(actual.getBack() == 3){
                delete(actual.getNumber());
            }
        }
    }

    private void skipTurn(Node actual){
        if(actual == head){
            System.out.println(actual.getNumber());
            return;
        }
        System.out.println(actual.getNumber());
        print(actual.getNext());
    }

    public int getActual(){
        if(head == null) return 0;
        return actual.getNumber();
    }

    public void nextTurn(){
        actual = actual.getNext();
        delete(actual.getPrevious().getNumber());
        actual.addBack();
    }
}