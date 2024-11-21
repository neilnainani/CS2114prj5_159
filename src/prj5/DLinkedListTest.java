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
 *  This class tests all the methods in DLinkedList
 * 
 *  @author Neil Nainani (neilnainani)
 *  @version Nov 20, 2024
 */
public class DLinkedListTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * emptyA an empty DLinkedList used for testing
     * emptyB an empty DLinkedList used for testing
     * smallA a small DLinkedList used for testing
     * smallB a small DLinkedList used for testing
     * bigA a big DLinkedlist used for testing
     * bigB a big DLinkedList used for testing
     * nullString a String that is null that's used for testing
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
    //~ Constructors ..........................................................
    
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * This method tests the add() method
     */
    public void testAdd() {
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
        bigB.add("cool");
        bigA.add("not cool");
        assertEquals(false, bigB.equals(bigA));
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
        
    }
}
