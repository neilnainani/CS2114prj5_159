// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Noah Chen (noahc20)

package prj5;

import java.util.Comparator;

public class InfluencerListCalculator<T> {
    private InfluencerList influencerList;

    public InfluencerListCalculator(DLinkedList<Influencer> influencerData) {
        this.influencerList = new InfluencerList(influencerData);
    }
    
    public InfluencerList sortName() {
        return insertionSort(influencerList, new NameComparator());
        
    }
    
    public InfluencerList sortTradER() {
        return insertionSort(influencerList, new TradEngagementComparator());
    }
    
    public InfluencerList sortReachER() {
        return insertionSort(influencerList, new ReachEngagementComparator());
    }
    
    private void intertionSort(DLinkedList<Influencer> list, Comparator<Influencer> comparator) {
        if (list.isEmpty() || list.getNumberOfEntries() == 1) {
            return;
        }
        
        Node<Influencer> curr = list.getFirstNode().getNext();
        
        while (curr != null) {
            Influencer temp = curr.getData();
            Node<Influencer> prev = curr.getPrev();
            
            while (prev != null && comparator.compare(temp, prev.getData() < 0)) {
                prev.getNext().setData(prev.getData());
                prev = prev.getPrev();
            }
            
            if (prev == null) {
                list.getFirstNode().setData(temp);
            } else {
                prev.getNext().setData(temp);
            }
            curr = curr.getNext();
        }
        
    }

    private class NameComparator implements Comparator<Influencer> {
        @Override
        public int compare(Influencer a, Influencer b) {
            String nameA = a.getChannelName();
            String nameB = b.getChannelName();
            if (nameA == null && nameB == null) {
                return 0;
            }
            if (nameB == null) {
                return 1;
            }
            if (nameA == null) {
                return -1;
            }
            
            nameA = nameA.toLowerCase();
            nameB = nameB.toLowerCase();
            
            if (nameA.equals(nameB)) {
                return 0;
            }
            if (nameA < nameB) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    
    private class TradEngagementComparator implements Comparator<Influencer> {
        @Override
        public int compare(Influencer a, Influencer b) {
            if (a.calculateTradEngagement() < b.calculateTradEngagment()) {
                return 1;
            } else if (a.calculateTradEngagement() > b.calculateTradEngagement()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    private class ReachEngagementComparator implements Comparator<Influencer> {
        @Override
        public int compare(Influencer a, Influencer b) {
            if (a.calculateReachEngagement() < b.calculateReachEngagment()) {
                return 1;
            } else if (a.calculateReachEngagement() > b.calculateReachEngagement()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
