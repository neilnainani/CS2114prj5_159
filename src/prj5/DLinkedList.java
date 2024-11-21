// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Neil Nainani (neilnainani)

package prj5;

// -------------------------------------------------------------------------
/**
 * This class implements a Doubly Linked List
 * 
 * @param <T>
 * 
 * @author Neil Nainani (neilnainani)
 * @version Nov 19, 2024
 */
public class DLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int numberOfEntries;

    /**
     * Creates a DLinkedList object while initializing a first and last Node
     * 
     * @param f the front Node that gets initialized
     * @param l the last Node that gets initialized
     */
    public DLinkedList(Node<T> f, Node<T> l) {
        firstNode = f;
        lastNode = l;
        if (f == null) {
            Node<T> f1 = new Node<T>(null);
            firstNode = f1;
        }
        if (l == null) {
            Node<T> l1 = new Node<T>(null);
            lastNode = l1;
        }
        if (firstNode.getData() != null && lastNode.getData() != null) {
            numberOfEntries = 2;
        }
        else if (firstNode.getData() == null && lastNode.getData() == null) {
            numberOfEntries = 0;
        }
        else {
            numberOfEntries = 1;
        }
    }

    // ----------------------------------------------------------
    /**
     * Creates a DLinkedList object initializing the first and last Node to null
     */
    public DLinkedList() {
        clear();
    }

    // ----------------------------------------------------------

    /**
     * Adds a new Node to the top of the list
     * 
     * @param data the data in the node to be added to the list
     * @return boolean returns true if data is not null, false otherwise
     */
    public boolean add(T data) {
        if (data == null) {
            return false;
        }
        Node<T> newNode = new Node<T>(data, null, null);
        if (numberOfEntries == 0) {
            firstNode = newNode;
        }
        else {
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
        }
        lastNode = newNode;
        numberOfEntries++;
        return true;
    }

    /**
     * Adds a new Node to a specific index in the list
     * 
     * @param index the index where the Node will be added
     * @param data  the data in the Node to be added
     * @return boolean returns true at all times due to no restrictions on size
     */
    public boolean add(int index, T data) {
        if (index > numberOfEntries || index < 0) {
            return false;
        }
        if (numberOfEntries == 0 || index == numberOfEntries) {
            return add(data);
        }

        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        Node<T> n = new Node<T>(data, currentNode, currentNode.getPrev());
        if (index != 0) {
            currentNode.getPrev().setNext(n);
            currentNode.setPrev(n);
        }
        else {
            return addToFront(n);
        }

        numberOfEntries++;
        return true;
    }

    /**
     * Clears the list of everything, acts a constructor with no parameters
     */

    public void clear() {
        firstNode = new Node<T>(null);
        lastNode = new Node<T>(null);
        numberOfEntries = 0;
    }

    /**
     * Checks if another object is equal to this one
     * 
     * @param obj the object this is compared to
     * @return boolean true if they equal each other, false otherwise
     */

    public boolean equals(Object obj) {
        if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        @SuppressWarnings("unchecked")
        DLinkedList<T> o = (DLinkedList<T>) obj;
        if (numberOfEntries != o.getNumberOfEntries()
            || !firstNode.getData().equals(o.getFirstNode().getData())
            || !lastNode.getData().equals(o.getLastNode().getData())) {
            return false;
        }
        for (int i = 0; i < numberOfEntries; i++) {
            T tData = this.get(i);
            T oData = o.get(i);
            if (!(tData.equals(oData))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the data in a node at a specific index
     * 
     * @param i the index the node is retrieved from
     * @return T the data retrieved, returns null if index isn't in range
     */
    public T get(int i) {
        if (i < 0 || i >= numberOfEntries) {
            return null;
        }
        Node<T> currNode = firstNode;

        for (int n = 0; n < i; n++) {
            currNode = currNode.getNext();
        }
        return currNode.getData();
    }

    /**
     * This is a helper method used to get a Node at a specific index
     * 
     * @param i the specific index
     * @return Node<T> the node at the specified index
     * 
     */
    private Node<T> getNode(int i) {
        if (i < 0 || i >= numberOfEntries) {
            return null;
        }
        Node<T> currNode = firstNode;
        for (int n = 0; n < i; n++) {
            currNode = currNode.getNext();
        }
        return currNode;
    }

    /**
     * This method finds the index of a Node with the parameter's data in it
     * 
     * @param d the data in which we find the index of
     * @return int the index where the node with the paramater's data is at.
     */
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

    /**
     * This method removes a node at a specified index
     * 
     * @param i the specified index
     * @return boolean returns true if successful, false otherwise
     */
    public boolean remove(int i) {
        if (numberOfEntries == 0) {
            return false;
        }
        if (i == 0) {
            firstNode.setData(null);
            firstNode = firstNode.getNext();
            numberOfEntries--;
            return true;
        }
        if (i == numberOfEntries - 1) {
            lastNode.setData(null);
            lastNode = lastNode.getPrev();
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

    /**
     * Returns the number of entries in the list
     * 
     * @return int the number of entries in the list
     */
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    /**
     * Returns the first Node
     * 
     * @return Node<T> the top Node
     */
    public Node<T> getFirstNode() {
        return firstNode;
    }

    /**
     * Returns the last Node
     * 
     * @return Node<T> the last Node
     */
    public Node<T> getLastNode() {
        return lastNode;
    }

    /**
     * Adds a node to the front or top of the list
     * 
     * @param n the node to be added
     * @return boolean true if the add was successful, false otherwise
     */
    public boolean addToFront(Node<T> n) {
        if (n.getData() == null) {
            return false;
        }
        if (numberOfEntries == 0) {
            firstNode = n;
            lastNode = firstNode;
        }
        if (firstNode != null && firstNode.getData() != null) {
            firstNode.setPrev(n);
            n.setNext(firstNode);
        }
        firstNode = n;
        numberOfEntries++;
        return true;
    }

    /**
     * Adds a node to the back or bottom of the list
     * 
     * @param n the node to be added
     */
    public void addToBack(Node<T> n) {
        add(n.getData());
    }

    /**
     * Removes the top or front Node
     */
    public void removeFront() {
        remove(0);
    }

    /**
     * Removes the back or bottom Node
     */
    public void removeBack() {
        remove(numberOfEntries - 1);
    }

    /**
     * Checks if the list is empty or not
     * 
     * @return boolean true if empty, false otherwise
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    // ----------------------------------------------------------
    /**
     * Checks if the list contains a certain data
     * 
     * @param d the data being check if in the list or not
     * @return boolean true if data is in list, false otherwise
     */

    public boolean contains(T d) {
        if (isEmpty()) {
            return false;
        }
        Node<T> curr = firstNode;
        for (int i = 0; i < numberOfEntries; i++) {
            if (curr.getData().equals(d)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }
}
