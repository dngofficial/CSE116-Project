package ratings.datastructures;

public class LinkedListNode<T> {

    private T value;
    private LinkedListNode<T> next;

    public LinkedListNode(T val, LinkedListNode<T> next) {
        this.value = val;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public int size() {
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.size();
        }
    }

    public String toString() {
        String out = "";
        out += this.value;
        if (this.next != null) {
            out += this.next.toString() + " ";
        }
        return out;
    }

    public LinkedListNode<T> getElement(T value) {
        if (this.value.equals(value)) {
            return this;
        } else if (this.next == null) {
            return null;
        } else {
            return this.next.getElement(value);
        }
    }

    public void append(T value) {
        if (this.next == null) {
            this.next = new LinkedListNode<>(value, null);
        } else {
            this.next.append(value);
        }
    }

    public void insert(T value, int loc) {
        if (loc == 0) {
            this.next = new LinkedListNode<>(this.value, this.next);
            this.value = value;
        } else {
            this.next.insert(value, loc - 1);
        }
    }

    public void delete(int loc)
    {
        loc = loc - 1;
        if (loc == -1) {
            this.value = this.next.value; //the first node is deleted
            this.next = this.next.next; //so set the next node to be the head node
        }
        else if (loc == 0)
        {
            if (this.next.next == null) //case to handle if the last node is the one being deleted
            {
                this.next = null;
            }
            else {
                this.next = this.next.next; //normal delete case
            }
        }
        else
        {
            this.next.delete(loc); //recursion
        }
    }
}
