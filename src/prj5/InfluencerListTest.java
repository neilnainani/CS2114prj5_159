// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Noah Chen (noahc20)

package prj5;

/**
 * InfluencerList Test class
 * 
 * @author Noah Chen (noahc20)
 * @version 2024.11.15
 */
public class InfluencerListTest extends student.TestCase {
    private InfluencerList testList;
    private DLinkedList<Influencer> janList;
    private DLinkedList<Influencer> febList;
    private DLinkedList<Influencer> marchList;

    /**
     * Set up test cases
     */
    public void setUp() {
        janList = new DLinkedList<Influencer>();
        janList
            .add(new Influencer("January", "User 0", "Channel 0", 1, 1, 1, 1));
        febList = new DLinkedList<Influencer>();
        febList
            .add(new Influencer("February", "User 0", "Channel 0", 1, 1, 1, 1));
        febList.add(
            new Influencer("February", "User 1", "Channel 1", 10, 10, 10, 10));
        marchList = new DLinkedList<Influencer>();
        marchList.add(
            new Influencer("March", "User 1", "Channel 1", 10, 10, 10, 10));
        marchList.add(new Influencer("January", "User 2", "Channel 2", 100, 100,
            100, 100));
        testList = new InfluencerList(janList, febList, marchList);
    }

    /**
     * Tests getOneList method
     */
    public void testGetOneList() {
        assertEquals(testList.getOneList(), janList);
    }

    /**
     * Tests getTwoList method
     */
    public void testGetTwoList() {
        assertEquals(testList.getTwoList(), febList);
    }

    /**
     * Tests getThreeList method
     */
    public void testGetThreeList() {
        assertEquals(testList.getThreeList(), marchList);
    }

    /**
     * Tests getCombinedList method
     */
    public void testCombinedList() {
        DLinkedList<Influencer> comList = new DLinkedList<Influencer>();
        comList
            .add(new Influencer("Combined", "User 0", "Channel 0", 2, 1, 2, 2));
        comList.add(
            new Influencer("Combined", "User 1", "Channel 1", 20, 10, 20, 20));
        comList.add(new Influencer("Combined", "User 2", "Channel 2", 100, 100,
            100, 100));
        assertEquals(testList.getCombinedList(), comList);
        InfluencerList nullListA = new InfluencerList(null, null, null);
        assertEquals(null, nullListA.getCombinedList());
        InfluencerList nullListB = new InfluencerList(comList, null, comList);
        assertEquals(null, nullListB.getCombinedList());
        InfluencerList nullListC = new InfluencerList(comList, comList, null);
        assertEquals(null, nullListC.getCombinedList());
    }

}
