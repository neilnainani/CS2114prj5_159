// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Neil Nainani (neilnainani)
package prj5;


// -------------------------------------------------------------------------
/**
 *  This class creates Nodes which are used in the multiple Lists and hold data
 *  @param <T>
 * 
 *  @author Neil Nainani (neilnainani)
 *  @version Nov 20, 2024
 */
public class Node<T>
{

    /**
     * next is the next node
     * prev is the previous node
     * data is the data in the node
     */
    private Node<T> next;
    private Node<T> prev;
    private T data;
        
    /**
     * Creates a Node object while initializing the node's next and previous
     * node
     * @param d the data in the node
     * @param n the next Node
     * @param p the previous Node
     */
        
    public Node(T d, Node<T> n, Node<T> p) {
        next = n;
        prev = p;
        data = d;
    }
        
    /**
     * Creates a Node object, initializing the node's next and prev to null
     * @param d2 the data in the node
     */
    public Node(T d2) {
        data = d2;
        next = null;
        data = null;
    }
        
    /**
     * Returns the next node
     * @return Node<T> the next Node
     */
    public Node<T> getNext() {
        return next;
    }
        
    /**
     * Returns the previous node
     * @return Node<T> the previous node
     */
    public Node<T> getPrev() {
        return prev;
    }
        
    /**
     * Returns the data in the node
     * @return T the data in the node
     */
    public T getData() {
        return data;
    }
        
    /**
     * Sets the next node
     * @param n the next node
     */
    public void setNext(Node<T> n) {
        next = n;
    }
        
    /**
     * Sets the data in the node
     * @param d the data that goes into the node
     */
    public void setData(T d) {
        data = d;
    }
        
    /**
     * Sets the previous node
     * @param p the previous node
     */
    public void setPrev(Node<T> p) {
        prev = p;
    }
    }

