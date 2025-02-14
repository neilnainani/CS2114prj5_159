// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Chloe Walker (cwalk)

package prj5;

import java.util.Comparator;

/**
 * Provides sorting methods for a list of influencers based on engagement rates
 * and names. It includes nested comparator classes that are used to customize
 * the insertion sort method.
 * 
 * @author chloe
 * @version Nov 19, 2024
 */
public class InfluencerListCalculator
{
    private DLinkedList<Influencer> influencerList;

    /**
     * Constructor for InfluencerListCalculator. Requires a given InfluencerList
     * 
     * @param influencerData
     *            linked list of influencers that is to be sorted in this class.
     */
    public InfluencerListCalculator(DLinkedList<Influencer> influencerData)
    {
        this.influencerList = influencerData;
    }


    /**
     * Sorts the influencerList alphabetically by the channel names
     * 
     * @return Sorted list by names
     */
    public DLinkedList<Influencer> sortName()
    {
        return insertionSort(influencerList, new NameComparator());
    }


    /**
     * Sorts the influencerList highest to lowest by traditional engagement
     * rates
     * 
     * @return Sorted list by Traditional ER
     */
    public DLinkedList<Influencer> sortTradER()
    {
        return insertionSort(influencerList, new TradEngagementComparator());
    }


    /**
     * Sorts the influencerList highest to lowest by reach engagement rates
     * 
     * @return Sorted list by Reach ER
     */
    public DLinkedList<Influencer> sortReachER()
    {
        return insertionSort(influencerList, new ReachEngagementComparator());
    }


    /**
     * Insertion sort method that is customizable given a list and a specific
     * comparator
     * 
     * @param list
     *            the list to be sorted
     * @param comparator
     *            the comparator with specific criteria of how the list should
     *            be sorted
     * @return The final sorted influencerList
     */
    private DLinkedList<Influencer> insertionSort(
        DLinkedList<Influencer> list,
        Comparator<Influencer> comparator)
    {
        if (list.isEmpty() || list.getNumberOfEntries() == 1)
        {
            return influencerList;
        }

        Node<Influencer> curr = list.getFirstNode().getNext();

        while (curr != null)
        {
            Influencer temp = curr.getData();
            Node<Influencer> prev = curr.getPrev();

            while (prev != null && comparator.compare(temp, prev.getData()) < 0)
            {
                prev.getNext().setData(prev.getData());
                prev = prev.getPrev();
            }

            if (prev == null)
            {
                list.getFirstNode().setData(temp);
            }
            else
            {
                prev.getNext().setData(temp);
            }
            curr = curr.getNext();
        }
        return influencerList;
    }

    /**
     * Comparator to sort influencer objects alphabetically by their channel
     * names
     */
    private class NameComparator
        implements Comparator<Influencer>
    {
        /**
         * Compares two influencers by channel name
         * 
         * @param a
         *            the first influencer
         * @param b
         *            the second influencer
         * @return an integer: positive (a should go before b when sorted),
         *             negative (b should go before a when sorted), or zero if
         *             they are equal (no changes will be made to the order.)
         */
        @Override
        public int compare(Influencer a, Influencer b)
        {
            if (a == null && b == null)
            {
                return 0;
            }
            else if (a == null)
            {
                return -1;
            }
            else if (b == null)
            {
                return 1;
            }
            String nameA = a.getChannelName().toLowerCase();
            String nameB = b.getChannelName().toLowerCase();
            if (nameA.equals(nameB))
            {
                return 0;
            }
            int length = Math.min(nameA.length(), nameB.length());
            for (int i = 0; i < length; i++)
            {
                if (nameA.charAt(i) < nameB.charAt(i))
                {
                    return -1;
                }
                else if (nameA.charAt(i) > nameB.charAt(i))
                {
                    return 1;
                }
            }

            if (nameA.length() < nameB.length())
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
    }


    /**
     * Comparator to sort influencer objects highest to lowest based on
     * traditional engagement rate
     */
    private class TradEngagementComparator
        implements Comparator<Influencer>
    {
        /**
         * Compares two influencers by traditional engagement rate
         * 
         * @param a
         *            the first influencer
         * @param b
         *            the second influencer
         * @return an integer: positive (a should go before b when sorted),
         *             negative (b should go before a when sorted), or zero if
         *             they are equal (no changes will be made to the order.)
         */
        @Override
        public int compare(Influencer a, Influencer b)
        {
            if (a == null && b == null)
            {
                return 0;
            }
            else if (a == null)
            {
                return -1;
            }
            else if (b == null)
            {
                return 1;
            }
            if (a.calculateTradEngagement() < b.calculateTradEngagement())
            {
                return 1;
            }
            else if (a.calculateTradEngagement() > b.calculateTradEngagement())
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }


    /**
     * Comparator to sort influencer objects highest to lowest based on reach
     * engagement rate
     */
    private class ReachEngagementComparator
        implements Comparator<Influencer>
    {
        /**
         * Compares two influencers by reach engagement rate
         * 
         * @param a
         *            the first influencer
         * @param b
         *            the second influencer
         * @return an integer: positive (a should go before b when sorted),
         *             negative (b should go before a when sorted), or zero if
         *             they are equal (no changes will be made to the order.)
         */
        @Override
        public int compare(Influencer a, Influencer b)
        {
            if (a == null && b == null)
            {
                return 0;
            }
            else if (a == null)
            {
                return -1;
            }
            else if (b == null)
            {
                return 1;
            }
            if (a.calculateReachEngagement() < b.calculateReachEngagement())
            {
                return 1;
            }
            else if (a.calculateReachEngagement() > b
                .calculateReachEngagement())
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }
}
