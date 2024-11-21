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
    private DLinkedList<Influencer> OneList;
    private DLinkedList<Influencer> TwoList;
    private DLinkedList<Influencer> ThreeList;
    private DLinkedList<Influencer> CombinedList;
    private static final int MONTHS = 3;

    /**
     * Constructor for InfluencerList Sets Jan, Feb, and March lists and creates
     * a combined list
     * 
     * @param JList January List
     * @param FList February List
     * @param MList March List
     */
    public InfluencerList(DLinkedList<Influencer> OList,
        DLinkedList<Influencer> TwList, DLinkedList<Influencer> TrList) {
        OneList = OList;
        TwoList = TwList;
        ThreeList = TrList;
        combineMonths();
    }

    /**
     * Creates a ombined list of every month
     */
    private DLinkedList<Influencer> combineMonths() {
        CombinedList = new DLinkedList<Influencer>();
        if (OneList == null || TwoList == null || ThreeList == null) {
            return null;
        }
        for (int i = 0; i < MONTHS; i++) {
            DLinkedList<Influencer> currList;
            if (i == 0) {
                currList = OneList;
            }
            else if (i == 1) {
                currList = TwoList;
            }
            else {
                currList = ThreeList;
            }
            for (int k = 0; k < currList.getNumberOfEntries(); k++) {
                boolean found = false;
                Influencer currInfl = currList.get(k);
                for (int j = 0; j < CombinedList.getNumberOfEntries(); j++) {
                    if (CombinedList.get(j).getUsername()
                        .equals(currInfl.getUsername())) {
                        // Adds together different months if same Username
                        Influencer newInfl = new Influencer("Combined",
                            currInfl.getUsername(), currInfl.getChannelName(),
                            currInfl.getLikes()
                                + CombinedList.get(j).getLikes(),
                            currInfl.getFollowers()
                                + CombinedList.get(j).getFollowers(),
                            currInfl.getComments()
                                + CombinedList.get(j).getComments(),
                            currInfl.getViews()
                                + CombinedList.get(j).getViews());
                        CombinedList.add(newInfl);
                        CombinedList.remove(j);
                        found = true;
                        break;
                    }
                }
                // If influencer not already in CombinedList
                if (!found) {
                    Influencer newInfl = new Influencer("Combined",
                        currInfl.getUsername(), currInfl.getChannelName(),
                        currInfl.getLikes(), currInfl.getFollowers(),
                        currInfl.getComments(), currInfl.getViews());
                    CombinedList.add(newInfl);
                }
            }
        }
        return CombinedList;

    }

    /**
     * @return InfluencerList of the influencer stats for January
     */
    public DLinkedList<Influencer> getOneList() {
        return OneList;
    }

    /**
     * @return InfluencerList of the influencer stats for February
     */
    public DLinkedList<Influencer> getTwoList() {
        return TwoList;
    }

    /**
     * @return InfluencerList of the influencer stats for March
     */
    public DLinkedList<Influencer> getThreeList() {
        return ThreeList;
    }

    /**
     * @return InfluencerList of the influencer stats for all 3 months
     */
    public DLinkedList<Influencer> getCombinedList() {
        return CombinedList;
    }

}
