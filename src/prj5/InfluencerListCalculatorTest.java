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
            new Influencer("January", "UserA", "abc", 100, 2000, 300, 4000));

        influencerList.add(
            new Influencer("January", "UserB", "ghi", 700, 400, 390, 5000));

        influencerList.add(
            new Influencer("January", "UserC", "jki", 200, 800, 700, 90000));

        influencerList.add(
            new Influencer("January", "UserD", "def", 400, 300, 500, 2000));

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
            new Influencer("January", "UserE", "klm", 400, 300, 500, 2000));
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted = calc.sortReachER();
        assertEquals("klm", sorted.get(1).getChannelName());
        assertEquals("def", sorted.get(0).getChannelName());
        assertEquals("ghi", sorted.get(2).getChannelName());

    }


    /**
     * Tests sorting influencers with the same traditional engagement rate.
     */
    public void testSameTrad()
    {
        influencerList.add(
            new Influencer("January", "UserE", "klm", 700, 400, 390, 5000));
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted = calc.sortTradER();
        assertEquals("ghi", sorted.get(1).getChannelName());
        assertEquals("klm", sorted.get(2).getChannelName());
        assertEquals("jki", sorted.get(3).getChannelName());
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
        influencerList
            .add(new Influencer("January", "UserE", "gh", 700, 400, 390, 5000));
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted = calc.sortName();
        assertEquals("gh", sorted.get(2).getChannelName());
        assertEquals("ghi", sorted.get(3).getChannelName());
        assertEquals("ghiA", sorted.get(4).getChannelName());
    }


    // ----------------------------------------------------------
    /**
     * tests how the sortName() method handles null entries.
     */
    public void testNullName()
    {
        influencerList.add(null);
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted = calc.sortName();
        assertEquals("abc", sorted.get(0).getChannelName());
        assertNull(sorted.get(4));
        influencerList.add(null);
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted2 = calc.sortName();
        assertNull(sorted2.get(4));
        assertNull(sorted2.get(5));
    }


    // ----------------------------------------------------------
    /**
     * tests how the sortTradER() method handles null entries.
     */
    public void testNullTrad()
    {
        influencerList.add(null);
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted = calc.sortTradER();
        assertEquals("def", sorted.get(0).getChannelName());
        assertNull(sorted.get(4));
        influencerList.add(null);
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted2 = calc.sortTradER();
        assertNull(sorted2.get(4));
        assertNull(sorted2.get(5));
    }


    // ----------------------------------------------------------
    /**
     * tests how the sortReachER() method handles null entries.
     */
    public void testNullReach()
    {
        influencerList.add(null);
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted = calc.sortReachER();
        assertEquals("def", sorted.get(0).getChannelName());
        assertNull(sorted.get(4));
        influencerList.add(null);
        calc = new InfluencerListCalculator(influencerList);
        DLinkedList<Influencer> sorted2 = calc.sortReachER();
        assertNull(sorted2.get(4));
        assertNull(sorted2.get(5));
    }
}
