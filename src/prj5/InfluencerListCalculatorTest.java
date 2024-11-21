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
public class InfluencerListCalculatorTest
    extends student.TestCase
{
    private InfluencerListCalculator calc;
    private DLinkedList<Influencer> influencerList;

    /**
     * Sets up the InfluencerList and InfluencerListCalculator objects needed
     * for the test class.
     */
    public void setUp()
    {
        influencerList = new DLinkedList<Influencer>();
        influencerList.add(
            new Influencer("January", "UserA", "abc", 100, 2000, 300, 4000));
        influencerList.add(
            new Influencer("January", "UserB", "ghi", 700, 400, 390, 5000));
        influencerList.add(
            new Influencer("January", "UserC", "jki", 200, 800, 700, 9000));
        influencerList.add(
            new Influencer("January", "UserD", "def", 400, 300, 500, 2000));

        calc = new InfluencerListCalculator(influencerList);
    }

    /**
     * tests the sortName() method
     */
    public void testSortName()
    {
        InfluencerList sorted = calc.sortName();
        assertEquals("abc", sorted.getCombinedList().get(0).getChannelName());
        assertEquals("def", sorted.getCombinedList().get(1).getChannelName());
        assertEquals("ghi", sorted.getCombinedList().get(2).getChannelName());
        assertEquals("jki", sorted.getCombinedList().get(3).getChannelName());
    }

    
    /**
     * tests the sortTradER() method
     */
    public void testSortTradER()
    {
        InfluencerList sorted = calc.sortTradER();
        assertEquals("def", sorted.getCombinedList().get(0).getChannelName());
        assertEquals("ghi", sorted.getCombinedList().get(1).getChannelName());
        assertEquals("jki", sorted.getCombinedList().get(2).getChannelName());
        assertEquals("abc", sorted.getCombinedList().get(3).getChannelName());
    }


    /**
     * tests the sortReachER() method
     */
    public void testSortReachER()
    {
        InfluencerList sorted = calc.sortReachER();
        assertEquals("jki", sorted.getCombinedList().get(0).getChannelName());
        assertEquals("def", sorted.getCombinedList().get(1).getChannelName());
        assertEquals("ghi", sorted.getCombinedList().get(2).getChannelName());
        assertEquals("abc", sorted.getCombinedList().get(3).getChannelName());
    }
}
