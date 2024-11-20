// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Noah Chen (noahc20)

package prj5;

public class ProjectRunner {

    public static void main(String[] args) throws IOException {
        InputFileReader filer;
        if (args.length > 0) {
            filer = new InputFileReader(args[0]);
        } else {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }
        
        boolean showConsole = true;
        boolean showGUI = false;
        
        InfluencerList influencerList = filer.readInputFile();
        if (showConsole) {
            DLinkedList<Influencer> combinedList = influencerList.getCombinedList();
            Node<Influencer> currentNode = combinedList.getFirstNode();
            while (currentNode != null) {
                Influencer influencer = currentNode.getData();
                System.out.println(influencer.getChannelName());
                System.out.println("traditional: " + influencer.calculateTradEngagement());
                System.out.println("==========");
                currentNode = currentNode.getNext();
            }
            System.out.println("**********");
            currentNode = combinedList.getFirstNode();
            while (currentNode != null) {
                Influencer influencer = currentNode.getData();
                System.out.println(influencer.getChannelName());
                System.out.println("reach: " + influencer.calculateReachEngagement());
                System.out.println("==========");
                currentNode = currentNode.getNext();
            }
        }
        if (showGUI) {
            /*
            * TODO: For final Submission - Should have the GUI display for the input data
            */
        }
    }

}
