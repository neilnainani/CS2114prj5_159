// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Noah Chen (noahc20)

package prj5;

public class Influencer
    implements Comparable<T>
{

    private String month;
    private String username;
    private String channelName;
    private int likes;
    private int followers;
    private int comments;
    private int views;

    public Influencer(String m, String u, String c, int l, int f, int c, int v)
    {
        month = m;
        username = u;
        channelName = c;
        likes = l;
        followers = f;
        comments = c;
        views = v;
    }
    
    public String getMonth() {
        return month;
    }

    public String getUsername() {
        return username;
    }
    
    public String getChannelName() {
        return channelName;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public int getFollowers() {
        return followers;
    }
    
    public int getComments() {
        return comments;
    }
    
    public int getViews() {
        return views;
    }
    
    public double calculateTradEngagement() {
        return ((comments + likes) / followers) * 100;
    }
    
    public double calculateReachEngagement() {
        return ((comments + likes) / views) * 100;
    }

    @Override
    public int compareTo(Influencer o, String engagementType)
    {
        // TODO Auto-generated method stub
        if (engagementType == null || o == null) {
            throw new IllegalArgumentException();
        }
        if (engagementType.equals("trad")) {
            if (calculateTradEngagement() < o.calculateTradEngagement()) {
                return -1;
            }
            else if (calculateTradEngagement() > o.calculateTradEngagement()) {
                return 1;
            }
            return 0;
        }
        if (engagementType.equals("reach")) {
            if (calculateReachEngagement() < o.calculateReachEngagement()) {
                return -1;
            }
            else if (calculateReachEngagement() > o.calculateReachEngagement()) {
                return 1;
            }
            return 0;
        }
        return null;
    }

}
