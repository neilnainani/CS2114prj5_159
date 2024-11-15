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
    private DLinkedList<Influencer> JanList;
    private DLinkedList<Influencer> FebList;
    private DLinkedList<Influencer> MarchList;
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
    public InfluencerList(DLinkedList<Influencer> JList,
        DLinkedList<Influencer> FList, DLinkedList<Influencer> MList) {
        JanList = JList;
        FebList = FList;
        MarchList = MList;
        combineMonths();
    }

    /**
     * Creates a ombined list of every month
     */
    private DLinkedList<Influencer> combineMonths() {
        CombinedList = new DLinkedList<Influencer>();
        if (JanList == null || FebList == null || MarchList == null) {
            return null;
        }
        for (int i = 0; i < MONTHS; i++) {
            DLinkedList<Influencer> currList;
            if (i == 0) {
                currList = JanList;
            } 
            else if (i == 1) {
                currList = FebList;
            }
            else {
                currList = MarchList;
            }
            for (int k = 0; k < currList.getNumberOfEntries(); k++) {
                boolean found = false;
                Influencer currInfl = currList.get(k);
                for (int j = 0; j < CombinedList.getNumberOfEntries(); j++) {
                    if (CombinedList.get(j).getUsername().equals(currInfl.getUsername()) {
                        //Adds together different months if same Username
                        Influencer newInfl = new Influencer("Combined", currList.getUsername(), currList.getChannelName(),
                            currInfl.getLikes() + CombinedList.get(j).getLikes(), 
                            currInfl.getFollowers() + CombinedList.get(j).getFollowers(),
                            currInfl.getComments() + CombinedList.get(j).getComments(), 
                            currInfl.getViews() + CombinedList.get(j).getViews());
                        CombinedList.add(newInfl);
                        found = true;
                        break;
                    }
                    //If influencer not already in CombinedList
                    if (!found) {
                        Influencer newInfl = new Influencer("Combined",
                            currInfl.getUsername(), currInfl.getChannelName(),
                            currInfl.getLikes(), currInfl.getFollowers(),
                            currInfl.getComments(), currInfl.getViews());
                        CombinedList.add(newInfl);
                    }
                } 
            }
        }
    }

}
