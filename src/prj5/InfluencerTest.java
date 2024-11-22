// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Farhan Uddin (farhanuddin)

package prj5;

// -------------------------------------------------------------------------
/**
 * Test Class for the Influencer class and its methods
 * 
 * @author Farhan Uddin
 * @version Nov 21, 2024
 */
public class InfluencerTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private Influencer influencer1;
    private Influencer influencer2;
    private Influencer influencer3;
    private Influencer influencer4;
    private Influencer influencer5;
    private Influencer influencer6;
    private Influencer influencer7;
    private Influencer influencer8;
    private Influencer influencer9;
    private Influencer influencer10;


    // ~ Constructors ..........................................................
    public void setUp()
    {
        influencer1 = new Influencer(
            "January",
            "farhan",
            "farhanschannel",
            30,
            30,
            20,
            30);
        influencer2 = new Influencer(
            "February",
            "farhan",
            "farhanschannel",
            0,
            30,
            20,
            30);
        influencer3 = new Influencer(
            "January",
            "barhan",
            "farhanschannel",
            30,
            0,
            20,
            30);
        influencer4 = new Influencer(
            "January",
            "farhan",
            "garhanschannel",
            30,
            30,
            0,
            30);
        influencer5 = new Influencer(
            "January",
            "farhan",
            "farhanschannel",
            30,
            30,
            20,
            0);
        influencer6 = new Influencer(
            "January",
            "farhan",
            "farhanschannel",
            0,
            30,
            20,
            30);
        influencer7 = new Influencer(
            "January",
            "farhan",
            "farhanschannel",
            30,
            0,
            20,
            30);
        influencer8 = new Influencer(
            "January",
            "farhan",
            "farhanschannel",
            30,
            30,
            0,
            30);
        influencer9 = new Influencer(
            "January",
            "farhan",
            "farhanschannel",
            30,
            30,
            20,
            0);
        influencer10 = new Influencer(
            "January",
            "farhan",
            "farhanschannel",
            30,
            30,
            20,
            30);
        
    }
    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Tests the getMonth method
     */
    public void testGetMonth()
    {
        assertEquals(influencer1.getMonth(), "January");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getUsername method
     */
    public void testGetUsername()
    {
        assertEquals(influencer1.getUsername(), "farhan");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getChannelName method
     */
    public void testGetChannelName()
    {
        assertEquals(influencer1.getChannelName(), "farhanschannel");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getLikes method
     */
    public void testGetLikes()
    {
        assertEquals(influencer1.getLikes(), 30);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getFollowers method
     */
    public void testGetFollowers()
    {
        assertEquals(influencer1.getFollowers(), 30);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getComments method
     */
    public void testGetComments()
    {
        assertEquals(influencer1.getComments(), 20);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getViews method
     */
    public void testGetViews()
    {
        assertEquals(influencer1.getViews(), 30);
    }


    // ----------------------------------------------------------
    /**
     * Tests the calculateTradEngagement method
     */
    public void testCalculateTradEngagement()
    {
        assertEquals(
            influencer1.calculateTradEngagement(),
            166.66,
            0.01);
        assertEquals(influencer2.calculateTradEngagement(), -1.0, 0.01);
        assertEquals(influencer3.calculateTradEngagement(), -1.0, 0.01);
        assertEquals(influencer4.calculateTradEngagement(), -1.0, 0.01);

    }


    // ----------------------------------------------------------
    /**
     * Tests the calculateReachEngagement method
     */
    public void testCalculateReachEngagement()
    {
        assertEquals(
            influencer1.calculateReachEngagement(),
            166.66,
            0.01);
        assertEquals(influencer2.calculateReachEngagement(), -1.0, 0.01);
        assertEquals(influencer4.calculateReachEngagement(), -1.0, 0.01);
        assertEquals(influencer5.calculateReachEngagement(), -1.0, 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Tests the equals method
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals()
    {
        assertTrue(influencer1.equals(influencer1));
        assertFalse(influencer1.equals(null));
        
        String s = "";
        assertFalse(influencer1.equals(s));
        
        assertFalse(influencer1.equals(influencer2));
        assertFalse(influencer1.equals(influencer3));
        assertFalse(influencer1.equals(influencer4));
        assertFalse(influencer1.equals(influencer5));
        assertFalse(influencer1.equals(influencer6));
        assertFalse(influencer1.equals(influencer7));
        assertFalse(influencer1.equals(influencer8));
        assertFalse(influencer1.equals(influencer9));
        assertTrue(influencer1.equals(influencer10));


    }
}
