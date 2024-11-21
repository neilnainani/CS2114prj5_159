// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Farhan Uddin (farhanuddin)

package prj5;

import java.util.Scanner;

import student.IOHelper;

// -------------------------------------------------------------------------
/**
 * Class to read files and fill in data structures of lists with influencer data
 * 
 * @author Farhan Uddin
 * @version Nov 21, 2024
 */
public class InputFileReader
{

    private InfluencerList iList;
    private String fileName;
    /**
     * Array of month names
     */
    public final static String[] MONTHS =
        { "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December" };

    // ----------------------------------------------------------
    /**
     * Create a new InputFileReader object.
     * 
     * @param fileName
     *            name of file being read
     */
    public InputFileReader(String fileName)
    {
        this.fileName = fileName;
    }


    // ----------------------------------------------------------
    /**
     * Read the input file of the class and fill in influencerlist
     * 
     * @return influencer list with file data
     */
    public InfluencerList readInputFile()
    {
        Scanner inStream = IOHelper.createScanner(fileName);
        inStream.nextLine();

        DLinkedList<Influencer> firstList = new DLinkedList<Influencer>();
        DLinkedList<Influencer> secondList = new DLinkedList<Influencer>();
        DLinkedList<Influencer> thirdList = new DLinkedList<Influencer>();

        String[] monthLists = new String[3];
        int monthListsSize = 0;
        while (inStream.hasNextLine())
        {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            String month = values[0];
            String username = values[1];
            String channel = values[2];
            int likes = toInt(values[5]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);

            if (monthListsSize < 3)
            {
                for (int i = 0; i < MONTHS.length; i++)
                {
                    if (month.equals(MONTHS[i]))
                    {
                        monthLists[monthListsSize] = month;
                        monthListsSize++;
                    }
                }
            }
            for (int i = 0; i < monthListsSize; i++)
            {
                if (monthLists[i].equals(month))
                {
                    switch (i)
                    {
                        case 0:
                            firstList.add(
                                new Influencer(
                                    month,
                                    username,
                                    channel,
                                    likes,
                                    followers,
                                    comments,
                                    views));
                        case 1:
                            secondList.add(
                                new Influencer(
                                    month,
                                    username,
                                    channel,
                                    likes,
                                    followers,
                                    comments,
                                    views));
                        case 2:
                            thirdList.add(
                                new Influencer(
                                    month,
                                    username,
                                    channel,
                                    likes,
                                    followers,
                                    comments,
                                    views));
                    }

                }
            }

        }

        iList = new InfluencerList(firstList, secondList, thirdList);
        return iList;
    }


    private int toInt(String str)
    {

        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}
