// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Chloe Walker (cwalk)

package prj5;

import java.io.IOException;
<<<<<<< Updated upstream
=======
import java.text.DecimalFormat;
>>>>>>> Stashed changes

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
        boolean showGUI = false;

        InfluencerList influencerList = filer.readInputFile();
<<<<<<< Updated upstream
        if (showConsole) {
            DLinkedList<Influencer> combinedList = influencerList
                .getCombinedList();
            InfluencerListCalculator iLC = new InfluencerListCalculator(
                combinedList);
            iLC.sortName();
=======

        DecimalFormat x = new DecimalFormat("#.#");

        if (showConsole)
        {
            InfluencerListCalculator calc =
                new InfluencerListCalculator(influencerList.getCombinedList());
            influencerList = calculator.sortName();
            DLinkedList<Influencer> combined = influencerList.getCombinedList();

>>>>>>> Stashed changes
            Node<Influencer> currentNode = combinedList.getFirstNode();
            while (currentNode != null && currentNode.getData() != null) {
                Influencer influencer = currentNode.getData();
                System.out.println(influencer.getChannelName());
                System.out.println(
                    "traditional: "
                        + x.format(influencer.calculateTradEngagement()));
                System.out.println("==========");
                currentNode = currentNode.getNext();
            }
            System.out.println("**********");
<<<<<<< Updated upstream
            iLC.sortReachER();
=======
            System.out.println("**********");
>>>>>>> Stashed changes
            currentNode = combinedList.getFirstNode();
            while (currentNode != null && currentNode.getData() != null) {
                Influencer influencer = currentNode.getData();
                System.out.println(influencer.getChannelName());
                System.out.println(
                    "reach: "
                        + x.format(influencer.calculateReachEngagement()));
                System.out.println("==========");
                currentNode = currentNode.getNext();
            }
        }
        if (showGUI) {
            /*
             * TODO: For final Submission - Should have the GUI display for the
             * input data
             */
        }
    }

}
