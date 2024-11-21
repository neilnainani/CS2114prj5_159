// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Noah Chen (noahc20)

package prj5;

import java.util.Scanner;

import student.IOHelper;

public class InputFileReader {

    private InfluencerList iList;
    private String fileName;
    /**
     * Array of month names
     */
    public final static String[] MONTHS = { "January", "February", "March",
        "April", "May", "June", "July", "August", "September", "October",
        "November", "December" };

    public InputFileReader(String fileName) {
        this.fileName = fileName;
    }

    public InfluencerList readInputFile() {
        Scanner inStream = IOHelper.createScanner(fileName);
        inStream.nextLine();

        DLinkedList<Influencer> firstList = new DLinkedList<Influencer>();
        DLinkedList<Influencer> secondList = new DLinkedList<Influencer>();
        DLinkedList<Influencer> thirdList = new DLinkedList<Influencer>();

        String[] monthLists = new String[3];
        int monthListsSize = 0;
        while (inStream.hasNextLine()) {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            String month = values[0];
            String username = values[1];
            String channel = values[2];
            int likes = toInt(values[5]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);
            boolean found = false;
            for (int i = 0; i < monthListsSize; i++) {
                if (monthLists[i].equals(month)) {
                    found = true;
                    switch (i) {
                        case 0:
                            firstList.add(new Influencer(month, username,
                                channel, likes, followers, comments, views));
                            break;
                        case 1:
                            secondList.add(new Influencer(month, username,
                                channel, likes, followers, comments, views));
                            break;
                        case 2:
                            thirdList.add(new Influencer(month, username,
                                channel, likes, followers, comments, views));
                            break;
                    }

                }
            }
            if (!found && monthListsSize < InfluencerList.MONTHS) {
                for (int i = 0; i < MONTHS.length; i++) {
                    if (month.equals(MONTHS[i])) {
                        monthLists[monthListsSize] = month;
                        monthListsSize++;
                        switch (monthListsSize - 1) {
                            case 0:
                                firstList.add(
                                    new Influencer(month, username, channel,
                                        likes, followers, comments, views));
                                break;
                            case 1:
                                secondList.add(
                                    new Influencer(month, username, channel,
                                        likes, followers, comments, views));
                                break;
                            case 2:
                                thirdList.add(
                                    new Influencer(month, username, channel,
                                        likes, followers, comments, views));
                                break;
                        }
                    }
                }
            }

        }

        iList = new InfluencerList(firstList, secondList, thirdList);
        return iList;
    }

    private int toInt(String str) {

        try {
            return Integer.parseInt(str);
        }
        catch (Exception e) {
            return 0;
        }
    }
}
