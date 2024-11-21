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
    private DLinkedList<Influencer> JanList;
    private DLinkedList<Influencer> FebList;
    private DLinkedList<Influencer> MarchList;

    /**
     * Set up test cases
     */
    public void setUp() {
        JanList = new DLinkedList<Influencer>();
        JanList
            .add(new Influencer("January", "User 0", "Channel 0", 1, 1, 1, 1));
        FebList = new DLinkedList<Influencer>();
        FebList
            .add(new Influencer("February", "User 0", "Channel 0", 1, 1, 1, 1));
        FebList.add(
            new Influencer("February", "User 1", "Channel 1", 10, 10, 10, 10));
        MarchList = new DLinkedList<Influencer>();
        MarchList.add(
            new Influencer("March", "User 1", "Channel 1", 10, 10, 10, 10));
        MarchList.add(new Influencer("January", "User 2", "Channel 2", 100, 100,
            100, 100));
        testList = new InfluencerList(JanList, FebList, MarchList);
    }

    /**
     * Tests getOneList method
     */
    public void testGetOneList() {
        assertEquals(testList.getOneList(), JanList);
    }

    /**
     * Tests getTwoList method
     */
    public void testGetTwoList() {
        assertEquals(testList.getTwoList(), FebList);
    }

    /**
     * Tests getThreeList method
     */
    public void testGetThreeList() {
        assertEquals(testList.getThreeList(), MarchList);
    }

    /**
     * Tests getCombinedList method
     */
    public void testCombinedList() {
        DLinkedList<Influencer> comList = new DLinkedList<Influencer>();
        comList
            .add(new Influencer("Combined", "User 0", "Channel 0", 2, 2, 2, 2));
        comList.add(
            new Influencer("Combined", "User 1", "Channel 1", 20, 20, 20, 20));
        comList.add(new Influencer("Combined", "User 2", "Channel 2", 100, 100,
            100, 100));
        assertEquals(testList.getCombinedList(), comList);
    }

}
