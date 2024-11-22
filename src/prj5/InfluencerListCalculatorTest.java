package prj5;

/**
 * Test class for InfluencerListCalculator
 * 
 * @author Chloe
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
        influencerList = new DLinkedList<>();
        influencerList.add(
            new Influencer("January", "UserA", "abc", 100, 2000, 300, 4000)); // 20
                                                                              // 10
        influencerList.add(
            new Influencer("January", "UserB", "ghi", 700, 400, 390, 5000)); // 298
                                                                             // 21
        influencerList.add(
            new Influencer("January", "UserC", "jki", 200, 800, 700, 90000)); // 111
                                                                              // 1
        influencerList.add(
            new Influencer("January", "UserD", "def", 400, 300, 500, 2000)); // 300
                                                                             // 45

        calc = new InfluencerListCalculator(influencerList);
    }


    /**
     * Tests the sortName() method.
     */
    public void testSortName()
    {
        DLinkedList<Influencer> sorted = calc.sortName();
        assertEquals("abc", sorted.get(0).getChannelName());
        assertEquals("def", sorted.get(1).getChannelName());
        assertEquals("ghi", sorted.get(2).getChannelName());
        assertEquals("jki", sorted.get(3).getChannelName());
    }


    /**
     * Tests the sortTradER() method.
     */
    public void testSortTradER()
    {
        DLinkedList<Influencer> sorted = calc.sortTradER();
        assertEquals("def", sorted.get(0).getChannelName());
        assertEquals("ghi", sorted.get(1).getChannelName());
        assertEquals("jki", sorted.get(2).getChannelName());
        assertEquals("abc", sorted.get(3).getChannelName());
    }


    /**
     * Tests the sortReachER() method.
     */
    public void testSortReachER()
    {
        DLinkedList<Influencer> sorted = calc.sortReachER();
        assertEquals("def", sorted.get(0).getChannelName());
        assertEquals("ghi", sorted.get(1).getChannelName());
        assertEquals("abc", sorted.get(2).getChannelName());
        assertEquals("jki", sorted.get(3).getChannelName());
    }


    /**
     * Tests sorting an empty list.
     */
    public void testSortEmptyList()
    {
        DLinkedList<Influencer> emptyList = new DLinkedList<>();
        calc = new InfluencerListCalculator(emptyList);
        DLinkedList<Influencer> sortedList = calc.sortName();
        assertTrue(sortedList.isEmpty());
    }


    /**
     * Tests sorting a list with only one entry
     */
    public void testSortSingleEntryList()
    {
        DLinkedList<Influencer> singleList = new DLinkedList<>();
        singleList.add(
            new Influencer("January", "UserA", "abc", 100, 2000, 300, 4000));
        calc = new InfluencerListCalculator(singleList);
        DLinkedList<Influencer> sorted = calc.sortName();
        assertEquals(1, sorted.getNumberOfEntries());
        assertEquals("abc", sorted.get(0).getChannelName());
    }


    /**
     * Tests sorting influencers with the same reach engagement rate.
     */
    public void testSameReach()
    {
        influencerList.add(
            new Influencer("January", "UserE", "klm", 500, 400, 500, 2000));
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted = calc.sortReachER();
        assertEquals("klm", sorted.get(0).getChannelName());
        assertEquals("def", sorted.get(1).getChannelName());
    }


    /**
     * Tests sorting influencers with the same traditional engagement rate.
     */
    public void testSameTrad()
    {
        influencerList.add(
            new Influencer("January", "UserE", "klm", 200, 300, 500, 2000));
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted = calc.sortTradER();
        assertEquals("def", sorted.get(0).getChannelName());
        assertEquals("klm", sorted.get(2).getChannelName());
    }


    /**
     * Tests influencers with the same channel name.
     */
    public void testSameName()
    {
        influencerList.add(
            new Influencer("January", "UserE", "ghi", 700, 400, 390, 5000));
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted = calc.sortName();
        assertEquals("ghi", sorted.get(2).getChannelName());
        assertEquals("ghi", sorted.get(3).getChannelName());
    }


    /**
     * Tests influencers with similar channel names.
     */
    public void testSimilarName()
    {
        influencerList.add(
            new Influencer("January", "UserE", "ghiA", 700, 400, 390, 5000));
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted = calc.sortName();
        assertEquals("ghi", sorted.get(2).getChannelName());
        assertEquals("ghiA", sorted.get(3).getChannelName());
    }
}
