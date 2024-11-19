// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Noah Chen (noahc20)

package prj5;

public class DLinkedList<T> {
    
    private static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T data;
        
        
        public Node(T d, Node<T> n, Node<T> p) {
            next = n;
            prev = p;
            data = d;
        }
        
        public Node(T d2) {
            data = d2;
        }
        
        public Node<T> getNext() {
            return next;
        }
        
        public Node<T> getPrev() {
            return prev;
        }
        
        public T getData() {
            return data;
        }
        
        public void setNext(Node<T> n) {
            next = n;
        }
        
        public void setData(T d) {
            data = d;
        }
        
        public void setPrev(Node<T> p) {
            prev = p;
        }
    }
    
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int numberOfEntries;

    public DLinkedList(Node<T> f, Node<T> l) {
        firstNode = f;
        lastNode = l;
        if (firstNode != null && lastNode != null) {
            numberOfEntries = 2;
        }
        else if(firstNode == null && lastNode == null) {
            numberOfEntries = 0;
        }
        else {
            numberOfEntries = 1;
        }
    }
    
    public DLinkedList() {
        clear();
    }
    
    public boolean add(T data) {
        Node<T> newNode = new Node<T>(data);
        firstNode.setPrev(newNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }
    
    public boolean add(int index, T data) {
        Node<T> newNode = new Node<T>(data);
        Node<T> currentNode = firstNode;
        if (numberOfEntries - (index + 1) > (index + 1)) {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            currentNode = currentNode.getNext();
            currentNode = currentNode.getNext();
            currentNode.setPrev(newNode);
            numberOfEntries++;
            return true;
        }
        currentNode = lastNode;
        for (int i = numberOfEntries - 1; i > index + 1; i--) {
            currentNode = currentNode.getPrev();
        }
        currentNode.setPrev(newNode);
        currentNode = currentNode.getPrev();
        currentNode = currentNode.getPrev();
        currentNode.setNext(newNode);
        numberOfEntries++;
        return true;
    }
    
    public void clear() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }
    
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        @SuppressWarnings("unchecked")
        DLinkedList<T> o = (DLinkedList<T>)obj;
        if (numberOfEntries != o.getNumberOfEntries() || firstNode.getData() !=
            o.getFirstNode().getData() || lastNode.getData() != 
            o.getLastNode().getData()) {
            return false;
        }
        for (int i = 0; i < numberOfEntries; i++) {
            if (!(this.get(i).equals(o.get(i)))) {
                return false;
            }
        }
        return true;
    }
    
    public T get(int i) {
        if (i < 0 || i >= numberOfEntries) {
            return null;
        }
        Node<T> currNode = firstNode;
        for (int n = 0; n < i + 1; n++) {
            currNode = currNode.getNext();
        }
        return currNode.getData();
    }
    
    private Node<T> getNode(int i) {
        Node<T> currNode = firstNode;
        for (int n = 0; n < i + 1; n++) {
            currNode = currNode.getNext();
        }
        return currNode;
    }
    
    public int indexOf(T d) {
        Node<T> currNode = firstNode;
        for (int i = 0; i < numberOfEntries; i++) {
            if (currNode.getData().equals(d)) {
                return i;
            }
            currNode = currNode.getNext();
        }
        return -1;
    }
    
    public boolean remove(int i) {
        if (i == 0) {
            firstNode.setData(null);
            firstNode = firstNode.getNext();
            numberOfEntries--;
            return true;
        }
        if (i == numberOfEntries - 1) {
            lastNode.setData(null);
            lastNode = lastNode.getNext();
            numberOfEntries--;
            return true;
        }
        Node<T> curr = getNode(i);
        if (curr == null) {
            return false;
        }
        Node<T> localPrev = curr.getPrev();
        Node<T> localNext = curr.getNext();
        curr = null;
        localPrev.setNext(localNext);
        localNext.setPrev(localPrev);
        numberOfEntries--;
        return true;
    }
    
    public int getNumberOfEntries() {
        return numberOfEntries;
    }
    
    public Node<T> getFirstNode() {
        return firstNode;
    }
    
    public Node<T> getLastNode() {
        return lastNode;
    }
    
    public void addToFront(Node<T> n) {
        add(0, n.getData());
    }
    public void addToBack(Node<T> n) {
        add(numberOfEntries, n.getData());
    }
    
    public void removeFront() {
        remove(0);
    }
    
    public void removeBack() {
        remove(numberOfEntries - 1);
    }
    
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    
    public boolean contains(T d) {
        Node<T> curr = firstNode;
        for (int i = 0; i < numberOfEntries; i++) {
            if (curr.getData().equals(d)) {
                return true;
            }
        }
        return false;
    }
}

    


