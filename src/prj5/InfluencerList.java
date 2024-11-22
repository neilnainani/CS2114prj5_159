// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Noah Chen (noahc20)

package prj5;

/**
 * Contains all the lists of influencers
 * 
 * @author Noah Chen (noahc20)
 * @version 2024.11.15
 */
public class InfluencerList {
    private DLinkedList<Influencer> oneList;
    private DLinkedList<Influencer> twoList;
    private DLinkedList<Influencer> threeList;
    private DLinkedList<Influencer> combinedList;
    /**
     * Months to be analyzed
     */
    public static final int MONTHS = 3;

    /**
     * Constructor for InfluencerList Sets Jan, Feb, and March lists and creates
     * a combined list
     * 
     * @param oList  First List
     * @param twList Second List
     * @param trList Third List
     */
    public InfluencerList(DLinkedList<Influencer> oList,
        DLinkedList<Influencer> twList, DLinkedList<Influencer> trList) {
        oneList = oList;
        twoList = twList;
        threeList = trList;
        combineMonths();
    }

    /**
     * @return a ombined list of every month
     */
    private DLinkedList<Influencer> combineMonths() {
        if (oneList == null || twoList == null || threeList == null) {
            return null;
        }
        combinedList = new DLinkedList<Influencer>();
        for (int i = 0; i < MONTHS; i++) {
            DLinkedList<Influencer> currList;
            if (i == 0) {
                currList = oneList;
            }
            else if (i == 1) {
                currList = twoList;
            }
            else {
                currList = threeList;
            }
            for (int k = 0; k < currList.getNumberOfEntries(); k++) {
                boolean found = false;
                Influencer currInfl = currList.get(k);
                for (int j = 0; j < combinedList.getNumberOfEntries(); j++) {
                    if (combinedList.get(j).getUsername()
                        .equals(currInfl.getUsername())) {
                        // Adds together different months if same Username
                        Influencer newInfl = new Influencer("Combined",
                            currInfl.getUsername(), currInfl.getChannelName(),
                            currInfl.getLikes()
                                + combinedList.get(j).getLikes(),
                            currInfl.getFollowers(),
                            currInfl.getComments()
                                + combinedList.get(j).getComments(),
                            currInfl.getViews()
                                + combinedList.get(j).getViews());
                        combinedList.add(newInfl);
                        combinedList.remove(j);
                        found = true;
                        break;
                    }
                }
                // If influencer not already in combinedList
                if (!found) {
                    Influencer newInfl = new Influencer("Combined",
                        currInfl.getUsername(), currInfl.getChannelName(),
                        currInfl.getLikes(), currInfl.getFollowers(),
                        currInfl.getComments(), currInfl.getViews());
                    combinedList.add(newInfl);
                }
            }
        }
        return combinedList;
    }

    /**
     * @return InfluencerList of the influencer stats for January
     */
    public DLinkedList<Influencer> getOneList() {
        return oneList;
    }

    /**
     * @return InfluencerList of the influencer stats for February
     */
    public DLinkedList<Influencer> getTwoList() {
        return twoList;
    }

    /**
     * @return InfluencerList of the influencer stats for March
     */
    public DLinkedList<Influencer> getThreeList() {
        return threeList;
    }

    /**
     * @return InfluencerList of the influencer stats for all 3 months
     */
    public DLinkedList<Influencer> getCombinedList() {
        return combinedList;
    }

}
