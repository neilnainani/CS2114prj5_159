// Virginia Tech Honor Code Pledge = new
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Noah Chen (noahc20)

package prj5;

import java.awt.Color;

import cs2.*;

/**
 * Displays the window
 * 
 * @author Noah Chen (noahc20)
 * @version 2024.12.03
 */
public class GUIProjectWindow
{
    private InfluencerList influencerList;
    private InfluencerListCalculator influencerRankings;
    private Window window;
    private Shape[] graphShapes;
    private static Color[] graphColors = new Color[8];

    private static final double DISPLAY_FACTOR = 1.5;
    private int graph_x;
    private int graph_y;
    private static final int BAR_WIDTH = 30;

    private Button sortByChannel;
    private Button sortByEngagement;
    private Button quit;
    private Button tradEngagement;
    private Button reachEngagement;
    private Button january;
    private Button february;
    private Button march;
    private Button firstQuarter;

    /**
     * Constructor that creates the window and buttons
     * 
     * @param iFL
     *            an InfluencerList that contains 3 different months of
     *            influencers
     */
    public GUIProjectWindow(InfluencerList iFL)
    {
        window = new Window("Social Media Vis");
        window
            .setSize((int)(700 * DISPLAY_FACTOR), (int)(500 * DISPLAY_FACTOR));

        influencerList = iFL;
        influencerRankings = new InfluencerListCalculator(iFL.getCombinedList());
        sortByChannel = new Button("Sort by Channel Name");
        window.addButton(sortByChannel, WindowSide.NORTH);
        sortByChannel.onClick(this, "clickedSortChannel");

        sortByEngagement = new Button("Sort by Engagement Rate");
        window.addButton(sortByEngagement, WindowSide.NORTH);
        sortByEngagement.onClick(this, "clickedSortEngage");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");

        tradEngagement = new Button("Traditional Engagement Rate");
        window.addButton(tradEngagement, WindowSide.WEST);
        tradEngagement.onClick(this, "clickedTradEngagement");

        reachEngagement = new Button("Reach Engagement Rate");
        window.addButton(reachEngagement, WindowSide.WEST);
        reachEngagement.onClick(this, "clickedReachEngagement");

        january = new Button("January");
        window.addButton(january, WindowSide.SOUTH);
        january.onClick(this, "clickedJanuary");

        february = new Button("February");
        window.addButton(february, WindowSide.SOUTH);
        february.onClick(this, "clickedFebruary");

        march = new Button("March");
        window.addButton(march, WindowSide.SOUTH);
        march.onClick(this, "clickedMarch");

        firstQuarter = new Button("First Quarter (Jan - March");
        window.addButton(firstQuarter, WindowSide.SOUTH);
        firstQuarter.onClick(this, "clickedFirstQuarter");

        graphColors[0] = new Color(51, 92, 103); // blue
        graphColors[1] = new Color(224, 159, 62); // yellow
        graphColors[2] = new Color(158, 42, 43); // red
        graphColors[3] = new Color(17, 17, 17); // black
        graphColors[4] = new Color(38, 68, 77); // dark blue
        graphColors[5] = new Color(97, 69, 27); // dark yellow
        graphColors[6] = new Color(71, 19, 19); // dark red
        graphColors[7] = new Color(255, 255, 255); // white

        updateText();
        updateGraph();
        drawShapes();
    }


    public void drawShapes()
    {
        // TODO Auto-generated method stub

    }


    public void updateGraph()
    {
        // TODO Auto-generated method stub

    }


    public void updateText()
    {
        // TODO Auto-generated method stub

    }


    public void clickedSortChannel()
    {
        influencerRankings.sortName();
        updateGraph();
        drawShapes();
        updateText();
    }


    public void clickedSortEngage()
    {
        influencerRankings.sortTradER();
        updateGraph();
        drawShapes();
        updateText();
    }


    // ----------------------------------------------------------
    /**
     * This method is what occurs when the "Quit" button is pressed, the program
     * stops running.
     * 
     * @param button
     *            is usually the quit button.
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    public void clickedTradEngagement()
    {
        influencerRankings.sortTradER();
        updateGraph();
        drawShapes();
        updateText();

    }


    public void clickedReachEngagement()
    {
        influencerRankings.sortReachER();
        updateGraph();
        drawShapes();
        updateText();

    }


    public void clickedJanuary()
    {
        influencerList.getOneList();
        influencerRankings =
            new InfluencerListCalculator(influencerList.getOneList());
        updateGraph();
        drawShapes();
        updateText();

    }


    public void clickedFebruary()
    {
        influencerList.getTwoList();
        influencerRankings =
            new InfluencerListCalculator(influencerList.getTwoList());
        updateGraph();
        drawShapes();
        updateText();
    }


    public void clickedMarch()
    {
        influencerList.getThreeList();
        influencerRankings =
            new InfluencerListCalculator(influencerList.getThreeList());
        updateGraph();
        drawShapes();
        updateText();
    }


    public void clickedFirstQuarter()
    {
        influencerList.getCombinedList();
        influencerRankings =
            new InfluencerListCalculator(influencerList.getCombinedList());
        updateGraph();
        drawShapes();
        updateText();
    }

}
