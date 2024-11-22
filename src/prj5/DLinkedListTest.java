// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Neil Nainani (neilnainani)
package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This class tests all the methods in DLinkedList
 * 
 * @author Neil Nainani (neilnainani)
 * @version Nov 20, 2024
 */
public class DLinkedListTest extends TestCase {
    // ~ Fields ................................................................
    /**
     * emptyA an empty DLinkedList used for testing emptyB an empty DLinkedList
     * used for testing smallA a small DLinkedList used for testing smallB a
     * small DLinkedList used for testing bigA a big DLinkedlist used for
     * testing bigB a big DLinkedList used for testing nullString a String that
     * is null that's used for testing
     */

    private DLinkedList<String> emptyA;
    private DLinkedList<String> emptyB;
    private DLinkedList<String> smallA;
    private DLinkedList<String> smallB;
    private DLinkedList<String> bigA;
    private DLinkedList<String> bigB;
    private String nullString;

    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyA = new DLinkedList<String>();
        emptyB = new DLinkedList<String>();

        smallA = new DLinkedList<String>();
        smallB = new DLinkedList<String>();

        smallA.add("soccer");
        smallA.add("swimming");
        smallA.add("gymnastics");

        smallB.add("soccer");
        smallB.add("swimming");
        smallB.add("gymnastics");

        bigA = new DLinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigA.add("sport" + i);
        }

        bigB = new DLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigB.add("sport" + (99 - i));
        }

        // to be explicit
        nullString = null;
    }

    // ----------------------------------------------------------
    /**
     * This method tests one of the constructors of the DLinkedList class
     */
    public void testDLinkedList() {
        Node<String> n1 = new Node<String>("front", null, null);
        Node<String> n2 = new Node<String>("back", null, null);
        DLinkedList<String> testA = new DLinkedList<String>(n1, n2);
        assertEquals(2, testA.getNumberOfEntries());
        DLinkedList<String> testB = new DLinkedList<String>(n1, null);
        assertEquals(1, testB.getNumberOfEntries());
        DLinkedList<String> testD = new DLinkedList<String>(null, n2);
        assertEquals(1, testD.getNumberOfEntries());
        DLinkedList<String> testC = new DLinkedList<String>(null, null);
        assertEquals(0, testC.getNumberOfEntries());
    }

    // ----------------------------------------------------------
    /**
     * This method tests the add() method
     */
    public void testAdd() {
        assertEquals(false, emptyA.add(null));
        emptyA.add("q");
        assertEquals(emptyA.getFirstNode().getData(), "q");
        assertEquals(emptyA.getLastNode().getData(), "q");
        assertEquals(emptyA.getNumberOfEntries(), 1);
        emptyA.add("w");
        emptyA.add(1, "e");
        assertEquals(emptyA.getLastNode().getData(), "w");
        assertEquals(emptyA.getFirstNode().getData(), "q");
        assertEquals(emptyA.getNumberOfEntries(), 3);
        assertEquals(emptyA.getFirstNode().getNext().getData(), "e");
        assertEquals(emptyA.add(5, "false"), false);
        assertEquals(emptyA.add(-1, "false"), false);
        emptyB.add(0, "data");
        assertEquals(emptyB.getFirstNode().getData(), "data");
        assertEquals(true, bigA.add(100, "data"));
        assertEquals(true, bigA.add(0, "The Beginning"));
        emptyB.add(0, "data1");
        assertEquals(emptyB.getFirstNode().getData(), "data");
    }

    // ----------------------------------------------------------
    /**
     * This method tests the clear() method
     */
    public void testClear() {
        bigB.clear();
        assertEquals(0, bigB.getNumberOfEntries());
        assertEquals(null, bigB.getFirstNode().getData());
        assertEquals(null, bigB.getLastNode().getData());
    }

    // ----------------------------------------------------------
    /**
     * This method tests the equals() method
     */
    public void testEquals() {
        assertEquals(true, smallA.equals(smallB));
        assertEquals(false, smallA.equals(nullString));
        int i = 0;
        assertEquals(false, smallA.equals(i));
        assertEquals(true, smallB.equals(smallB));
        smallA.add("a");
        smallB.add("b");
        smallA.add("c");
        smallB.add("c");
        assertEquals(false, smallA.equals(smallB));
        smallB.removeBack();
        smallA.removeBack();
        bigB.add("cool");
        bigA.add("not cool");
        assertEquals(false, bigB.equals(bigA));
        smallA.add("cool?");
        assertEquals(false, smallA.equals(smallB));
        smallB.add("not cool");
        assertEquals(false, smallA.equals(smallB));
        bigA.removeBack();
        bigA.add(63, ".");
        assertEquals(false, bigA.equals(bigB));
        DLinkedList<String> listA = new DLinkedList<String>();
        listA.add("0");
        listA.add("1");
        listA.add("2");
        DLinkedList<String> listB = new DLinkedList<String>();
        listB.add("0");
        listB.add("1");
        listB.add("2");
        assertFalse(listA.equals(listB));
    }

    // ----------------------------------------------------------
    /**
     * This method tests the get() method
     */
    public void testGet() {
        assertEquals("gymnastics", smallA.get(2));
        assertEquals("sport56", bigA.get(56));
        assertEquals(null, bigA.get(-1));
        assertEquals(null, smallA.get(5));
    }

    // ----------------------------------------------------------
    /**
     * This method tests the indexOf() method
     */
    public void testIndexOf() {
        assertEquals(bigA.indexOf("sport56"), 56);
        assertEquals(smallA.indexOf("swimming"), 1);
        assertEquals(bigB.indexOf("not in the list"), -1);
    }

    /**
     * This method tests the remove() method
     */
    public void testRemove() {
        assertEquals(false, smallA.remove(-1));
        assertEquals(false, bigA.remove(200));
        assertEquals(true, bigA.remove(0));
        assertEquals("sport1", bigA.getFirstNode().getData());
        assertEquals(true, smallB.remove(2));
        assertEquals("swimming", smallB.getLastNode().getData());
        assertEquals(false, smallA.remove(10));
        smallA.add("3");
        assertEquals(true, smallA.remove(1));
        assertEquals("gymnastics", smallA.get(1));
    }

    // ----------------------------------------------------------
    /**
     * This method tests the getNumberOfEntries()
     */
    public void testGetNumberOfEntries() {
        assertEquals(0, emptyA.getNumberOfEntries());
        assertEquals(100, bigA.getNumberOfEntries());
        assertEquals(3, smallB.getNumberOfEntries());
    }

    // ----------------------------------------------------------
    /**
     * This method tests the getFirstNode() method
     */
    public void testGetFirstNode() {
        assertEquals(smallA.getFirstNode().getData(), "soccer");
        assertEquals(null, emptyA.getFirstNode().getData());
    }

    // ----------------------------------------------------------
    /**
     * This method tests the getLastNode() method
     */
    public void testGetLastNode() {
        assertEquals(smallA.getLastNode().getData(), "gymnastics");
        assertEquals(null, emptyB.getLastNode().getData());
        emptyA.add("one");
        assertEquals(emptyA.getLastNode(), emptyA.getLastNode());
    }

    // ----------------------------------------------------------
    /**
     * This method tests the addToFront() method
     */
    public void testAddToFront() {
        Node<String> n = new Node<String>("front", null, null);
        Node<String> n1 = new Node<String>(null, null, null);
        Node<String> n2 = new Node<String>(null, n, n1);
        assertEquals(false, emptyA.addToFront(n1));
        Node<String> n3 = smallA.getFirstNode();
        assertEquals(true, smallA.addToFront(n));
        assertEquals(n3, smallA.getFirstNode().getNext());
        assertEquals(true, bigA.addToFront(n));
        assertEquals(bigA.getFirstNode().getData(), "front");
        assertEquals(101, bigA.getNumberOfEntries());
        assertEquals(true, emptyA.addToFront(n));
        assertEquals(emptyA.getFirstNode(), emptyA.getLastNode());
        assertEquals(1, emptyA.getNumberOfEntries());
        assertTrue(emptyB.addToFront(n2));
    }

    // ----------------------------------------------------------
    /**
     * This method tests the addToBack() method
     */
    public void testAddToBack() {
        Node<String> n = new Node<String>("back", null, null);
        bigA.addToBack(n);
        assertEquals(bigA.getLastNode().getData(), "back");
        assertEquals(101, bigA.getNumberOfEntries());
        emptyA.addToBack(n);
        assertEquals(emptyA.getFirstNode(), emptyA.getLastNode());
        assertEquals(1, emptyA.getNumberOfEntries());
    }

    // ----------------------------------------------------------
    /**
     * This method tests the removeFront() method
     */
    public void testRemoveFront() {
        bigA.removeFront();
        assertEquals(bigA.getFirstNode().getData(), "sport1");
        assertEquals(99, bigA.getNumberOfEntries());
        emptyA.removeFront();
        assertEquals(0, emptyA.getNumberOfEntries());
    }

    /**
     * This method tests the removeBack() method
     */
    public void testRemoveBack() {
        bigA.removeBack();
        assertEquals(bigA.getLastNode().getData(), "sport98");
        assertEquals(99, bigA.getNumberOfEntries());
        emptyA.removeBack();
        assertEquals(0, emptyA.getNumberOfEntries());
    }

    /**
     * This method tests the isEmpty() method
     */
    public void testIsEmpty() {
        assertEquals(true, emptyA.isEmpty());
        assertEquals(false, bigB.isEmpty());
    }

    /**
     * This method tests the contains() method
     */
    public void testContains() {
        assertEquals(true, bigB.contains("sport56"));
        assertEquals(false, bigA.contains("false"));
        assertEquals(false, emptyA.contains(null));
        assertEquals(true, smallB.contains("swimming"));
        assertEquals(false, smallA.contains("sports"));

    }
}
