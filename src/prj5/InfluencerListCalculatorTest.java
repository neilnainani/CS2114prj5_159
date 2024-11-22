// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Chloe Walker (cwalk)

package prj5;

/**
 * Test class for InfluencerListCalculator
 * 
 * @author chloe
 * @version Nov 19, 2024
 */
public class InfluencerListCalculatorTest extends student.TestCase {
    private InfluencerListCalculator calc;
    private InfluencerList inflList;

    /**
     * Sets up the InfluencerList and InfluencerListCalculator objects needed
     * for the test class.
     */
    public void setUp() {
        DLinkedList<Influencer> influencerList = new DLinkedList<Influencer>();
        influencerList.add(
            new Influencer("January", "UserA", "abc", 100, 2000, 300, 4000));
        // 20 10
        influencerList.add(
            new Influencer("January", "UserB", "ghi", 700, 400, 390, 5000));
        // 298 21
        influencerList.add(
            new Influencer("January", "UserC", "jki", 200, 800, 700, 90000));
        // 111 1
        influencerList.add(
            new Influencer("January", "UserD", "def", 400, 300, 500, 2000));
        // 300 45

        calc = new InfluencerListCalculator(influencerList);
        inflList = new InfluencerList(influencerList,
            new DLinkedList<Influencer>(), new DLinkedList<Influencer>());
    }

    /**
     * tests the sortName() method
     */
    public void testSortName() {
        calc.sortName();
        assertEquals("abc", inflList.getOneList().get(0).getChannelName());
        assertEquals("def", inflList.getOneList().get(1).getChannelName());
        assertEquals("ghi", inflList.getOneList().get(2).getChannelName());
        assertEquals("jki", inflList.getOneList().get(3).getChannelName());
    }

    /**
     * tests the sortTradER() method
     */
    public void testSortTradER() {
        calc.sortTradER();
        assertEquals("def", inflList.getOneList().get(0).getChannelName());
        assertEquals("ghi", inflList.getOneList().get(1).getChannelName());
        assertEquals("jki", inflList.getOneList().get(2).getChannelName());
        assertEquals("abc", inflList.getOneList().get(3).getChannelName());
    }

    /**
     * tests the sortReachER() method
     */
    public void testSortReachER() {
        calc.sortReachER();
        assertEquals("def", inflList.getOneList().get(0).getChannelName());
        assertEquals("ghi", inflList.getOneList().get(1).getChannelName());
        assertEquals("abc", inflList.getOneList().get(2).getChannelName());
        assertEquals("jki", inflList.getOneList().get(3).getChannelName());
    }
}
