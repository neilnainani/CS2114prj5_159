// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Chloe Walker (cwalk)

package prj5;

import java.io.IOException;

/**
 * Runs the program by triggering InputFileReader class which then calls other
 * functions to run the project.
 * 
 * @author chloe
 * @version Nov 19, 2024
 */
public class ProjectRunner {

    /**
     * Maine method that processes the given data through the InputFileReader.
     * It then goes on the output the processed data (either in the console or
     * in a GUI.)
     * 
     * @param args command-line arguments. If there is a non null argument, it
     *             will be an input file to be processed. Otherwise a default
     *             input file will be used.
     * @throws IOException if an error occurs in the input reading process
     */
    public static void main(String[] args) throws IOException {
        InputFileReader filer;
        if (args.length > 0) {
            filer = new InputFileReader(args[0]);
        }
        else {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }

        boolean showConsole = true;
        boolean showGUI = true;

        InfluencerList influencerList = filer.readInputFile();

        if (showConsole) {
            InfluencerListCalculator calc = new InfluencerListCalculator(
                influencerList.getCombinedList());

            DLinkedList<Influencer> combined = influencerList.getCombinedList();
            calc.sortName();
            Node<Influencer> currentNode = combined.getFirstNode();
            while (currentNode != null && currentNode.getData() != null) {
                Influencer influencer = currentNode.getData();
                System.out.println(influencer.getChannelName());
                if (influencer.calculateTradEngagement() == -1) {
                    System.out.println("traditional: N/A");
                }
                else {
                    System.out.println("traditional: " + (Math.round(
                        influencer.calculateTradEngagement() * 10.0) / 10.0));
                }
                System.out.println("==========");
                currentNode = currentNode.getNext();
            }
            System.out.println("**********");
            System.out.println("**********");
            calc.sortReachER();
            currentNode = combined.getFirstNode();

            while (currentNode != null && currentNode.getData() != null) {
                Influencer influencer = currentNode.getData();
                System.out.println(influencer.getChannelName());
                if (influencer.calculateReachEngagement() == -1) {
                    System.out.println("reach: N/A");
                }
                else {
                    System.out.println("reach: " + (Math.round(
                        influencer.calculateReachEngagement() * 10.0) / 10.0));
                }
                System.out.println("==========");
                currentNode = currentNode.getNext();
            }
        }
        if (showGUI) {
            InfluencerListCalculator calc = new InfluencerListCalculator(
                influencerList.getCombinedList());
            GUIProjectWindow window = new GUIProjectWindow(calc);
        }
    }

}
