// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Farhan Uddin (farhanuddin)

package prj5;

// -------------------------------------------------------------------------
/**
 * Class representing a singular Influencer and its stats
 * 
 * @author Farhan Uddin
 * @version Nov 21, 2024
 */
public class Influencer
/* implements Comparable<Influencer> */ {

    private String month;
    private String username;
    private String channelName;
    private int likes;
    private int followers;
    private int comments;
    private int views;

    // ----------------------------------------------------------
    /**
     * Create a new Influencer object.
     * 
     * @param m
     *            month
     * @param u
     *            username
     * @param c
     *            channel name
     * @param l
     *            likes
     * @param f
     *            followers
     * @param cM
     *            comments
     * @param v
     *            views
     */
    public Influencer(String m, String u, String c, int l, int f, int cM, int v)
    {
        month = m;
        username = u;
        channelName = c;
        likes = l;
        followers = f;
        comments = cM;
        views = v;
    }


    // ----------------------------------------------------------
    /**
     * Gets the month of the stats
     * 
     * @return month
     */
    public String getMonth()
    {
        return month;
    }


    // ----------------------------------------------------------
    /**
     * Gets the username of the influencer
     * 
     * @return username
     */
    public String getUsername()
    {
        return username;
    }


    // ----------------------------------------------------------
    /**
     * Gets the channel name of the influencer
     * 
     * @return channel names
     */
    public String getChannelName()
    {
        return channelName;
    }


    // ----------------------------------------------------------
    /**
     * Gets number of likes influencer has received
     * 
     * @return likes
     */
    public int getLikes()
    {
        return likes;
    }


    // ----------------------------------------------------------
    /**
     * Gets the number of followers influencer has
     * 
     * @return followers
     */
    public int getFollowers()
    {
        return followers;
    }


    // ----------------------------------------------------------
    /**
     * Gets the number of comments influencer has received
     * 
     * @return comments
     */
    public int getComments()
    {
        return comments;
    }


    // ----------------------------------------------------------
    /**
     * Gets the number of views influencer has received
     * 
     * @return views
     */
    public int getViews()
    {
        return views;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the traditional engagement based on comments, likes and
     * followers
     * 
     * @return traditional engagement
     */
    public double calculateTradEngagement()
    {
        if (comments == 0 || likes == 0 || followers == 0)
        {
            return -1;
        }
        @SuppressWarnings("cast")
        double result =
            (((((double)comments) + ((double)likes)) / ((double)followers))
                * (double)100);
        return result;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the reach engagement based on likes, comments and views
     * 
     * @return reach engagement
     */
    public double calculateReachEngagement()
    {
        if (comments == 0 || likes == 0 || views == 0)
        {
            return -1;
        }
        @SuppressWarnings("cast")
        double result =
            (((((double)comments) + ((double)likes)) / ((double)views))
                * ((double)100));
        return result;
    }

    // ----------------------------------------------------------
    /**
     * Compares this infleuncer to another influencer on engagement
     * 
     * @param o
     *            other influencer
     * @param engagementType
     *            reach or traditional engagement
     * @return -1 if less than other, 1 if greater than other, 0 if equal to
     *             other influencer
     */
// @SuppressWarnings({ "null", "cast" })
// public int compareTo(Influencer o, String engagementType) {
// if (engagementType == null || o == null) {
// throw new IllegalArgumentException();
// }
// if (engagementType.equals("trad")) {
// if (calculateTradEngagement() < o.calculateTradEngagement()) {
// return -1;
// }
// else if (calculateTradEngagement() > o.calculateTradEngagement()) {
// return 1;
// }
// return 0;
// }
// if (engagementType.equals("reach")) {
// if (calculateReachEngagement() < o.calculateReachEngagement()) {
// return -1;
// }
// else if (calculateReachEngagement() > o
// .calculateReachEngagement()) {
// return 1;
// }
// return 0;
// }
// return (Integer) null;
// }

// @Override
// public int compareTo(Influencer o) {
// return compareTo(o, "trad");
// }


    // ----------------------------------------------------------
    /**
     * Checks if influencer is equal to object passed in
     * 
     * @param other
     *            object being compared
     * @return if influencers are equal
     */
    @Override
    public boolean equals(Object other)
    {
        if ((other == null) || other.getClass() != this.getClass())
        {
            return false;
        }
        if (other == this)
        {
            return true;
        }
        return !(!getChannelName().equals(((Influencer)other).getChannelName())
            || !getMonth().equals(((Influencer)other).getMonth())
            || !getUsername().equals(((Influencer)other).getUsername())
            || getLikes() != ((Influencer)other).getLikes()
            || getFollowers() != ((Influencer)other).getFollowers()
            || getComments() != ((Influencer)other).getComments()
            || getViews() != ((Influencer)other).getViews());
    }

}
