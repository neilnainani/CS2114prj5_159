// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Noah Chen (noahc20)

package prj5;

public class InputFileReader
{

    private InfluencerList iList;
    private String fileName;

    public InputFileReader(String fileName)
    {
        this.fileName = fileName;
    }


    public InfluencerList readInputFile() {
        Scanner inStream = IOHelper.createScanner(fileName);
        inStream.nextLine();
        
        DLinkedList<Influencer> janList;
        DLinkedList<Influencer> febList;
        DLinkedList<Influencer> marchList;
        
        while (inStream.hasNextLine()) {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            String month = values[0];
            Stirng username = values[1];
            String channel = values[2];
            int likes = toInt(values[5]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);
            
            if(month.equals("January")) {
                janList.add(new Influencer(month, username, channel, likes, followers, comments, views));
            }
            if(month.equals("February")) {
                febList.add(new Influencer(month, username, channel, likes, followers, comments, views));
            }
            if(month.equals("March")) {
                marchList.add(new Influencer(month, username, channel, likes, followers, comments, views));
            }
        }
        
        iList = new InfluencerList(janList, febList, marchList);
    }


    private int toInt(String str)
    {

        try
        {
            return Integer.ParseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}
