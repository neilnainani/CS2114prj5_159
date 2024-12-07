// Virginia Tech Honor Code Pledge = new
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Noah Chen (noahc20)

package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
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

    private String month;
    private TextShape textMonth;
    private TextShape textER;
    private TextShape sortER;
    private String er;
    private String sortERString;

    private static final String PATTERN = "#.#";
    private static final DecimalFormat dc = new DecimalFormat(PATTERN);

    /**
     * Constructor that creates the window and buttons
     * 
     * @param iFL
     *            an InfluencerList that contains 3 different months of
     *            influencers
     */
    public GUIProjectWindow(InfluencerList iFL)
    {
        window = new Window("neilnainani noahc20 farhanuddin cwalk");
        window
            .setSize((int)(700 * DISPLAY_FACTOR), (int)(500 * DISPLAY_FACTOR));

        influencerList = iFL;
        influencerRankings =
            new InfluencerListCalculator(iFL.getCombinedList());
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

        textMonth = new TextShape(10, 10, "");

        textER = new TextShape(10, 30, "");

        sortER = new TextShape(10, 50, "");

        graphColors[0] = new Color(51, 92, 103); // blue
        graphColors[1] = new Color(224, 159, 62); // yellow
        graphColors[2] = new Color(158, 42, 43); // red
        graphColors[3] = new Color(17, 17, 17); // black
        graphColors[4] = new Color(38, 68, 77); // dark blue
        graphColors[5] = new Color(97, 69, 27); // dark yellow
        graphColors[6] = new Color(71, 19, 19); // dark red
        graphColors[7] = new Color(255, 255, 255); // white

        month = "a";
        sortERString = "0";
        er = "0";


        updateText();
        drawShapes();
    }


    // ----------------------------------------------------------
    /**
     * This method draws the shapes in the GUI
     */
    public void drawShapes()
    {
        DLinkedList<Influencer> influencers = influencerList.getCombinedList();
        graphShapes = new Shape[influencers.getNumberOfEntries()];
        graph_x = 50;

        if (month.equals("j"))
        {
            influencers = influencerList.getOneList();
        }
        else if (month.equals("f"))
        {
            influencers = influencerList.getTwoList();
        }
        else if (month.equals("m"))
        {
            influencers = influencerList.getThreeList();
        }

        for (int i = 0; i < influencers.getNumberOfEntries(); i++)
        {
            Influencer influencer = influencers.get(i);
            double engagementRate;
            if (er.equals("1"))
            {
                engagementRate = influencer.calculateReachEngagement();
            }
            else
            {
                engagementRate = influencer.calculateTradEngagement();
            }

            int height = (int)(engagementRate * 0.14);
            if (er.equals("1")) {
                height = (int)(engagementRate * 2);
            }
            Color shapeColor = graphColors[i % graphColors.length];

            Shape shape = new Shape(graph_x, 550 - height, BAR_WIDTH, height, shapeColor);
            //shape.setColor(shapeColor);
            graphShapes[i] = shape;

            String formattedRate = dc.format(engagementRate);
            String labelText =
                influencer.getChannelName();
            String rateText = formattedRate;
            TextShape label = new TextShape(graph_x, 570, labelText);
            TextShape label2 = new TextShape(graph_x, 590, rateText);

            window.addShape(label);
            window.addShape(label2);

            graph_x += BAR_WIDTH + 100;
        }

        for (Shape shape : graphShapes)
        {
            window.addShape(shape);
        }

    }


    // ----------------------------------------------------------
    /**
     * This method updates the graph in the GUI
     */
    public void updateGraph()
    {
        window.removeAllShapes();
        drawShapes();
    }


    // ----------------------------------------------------------
    /**
     * This method updates the text in the GUI
     */
    public void updateText()
    {
        if (month != null)
        {
            if (month.equals("j"))
            {
                textMonth.setText("January");
            }
            else if (month.equals("f"))
            {
                textMonth.setText("February");
            }
            else if (month.equals("m"))
            {
                textMonth.setText("March");
            }
            else if (month.equals("a"))
            {
                textMonth.setText("First Quarter (Jan - March)");
            }
        }

        if (sortERString != null)
        {
            if (sortERString.equals("0"))
            {
                sortER.setText("Sorting by Channel Name");
            }
            else if (sortERString.equals("1"))
            {
                sortER.setText("Sorting by Engagement Rate");
            }
        }

        if (er != null)
        {

            if (er.equals("0"))
            {
                textER.setText("Traditional Engagement Rate");
            }
            else if (er.equals("1"))
            {
                textER.setText("Reach Engagement Rate");
            }
        }

        window.addShape(textMonth);
        window.addShape(sortER);
        window.addShape(textER);
    }


    // ----------------------------------------------------------
    /**
     * This method is what is executed when the Sort  by Channel Name
     *  button is clicked
     * @param button the Sort Channel button
     */
    public void clickedSortChannel(Button button)
    {
        sortERString = "0";
        influencerRankings.sortName();
        updateGraph();
        drawShapes();
        updateText();
    }


    // ----------------------------------------------------------
    /**
     * This method is what is executed when the Sort by Engagement Rate
     *  button is clicked
     * @param button the Sort by Engagement Rate button
     */
    public void clickedSortEngage(Button button)
    {
        sortERString = "1";
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

    
    // ----------------------------------------------------------
    /**
     * This method is what is executed when the Traditional Engagement Rate
     * button is clicked
     * @param button the Traditional Engagement Rate button
     */
    public void clickedTradEngagement(Button button)
    {
        er = "0";
        influencerRankings.sortTradER();
        updateGraph();
        drawShapes();
        updateText();

    }


    // ----------------------------------------------------------
    /**
     * This method is what is executed when the Reach Engagement Rate button is
     * clicked
     * @param button the Reach Engagement Rate button
     */
    public void clickedReachEngagement(Button button)
    {
        er = "1";
        influencerRankings.sortReachER();
        updateGraph();
        drawShapes();
        updateText();

    }


    // ----------------------------------------------------------
    /**
     * This method is what is executed when the January button is clicked
     * @param button the January button
     */
    public void clickedJanuary(Button button)
    {
        month = "j";
        influencerList.getOneList();
        influencerRankings =
            new InfluencerListCalculator(influencerList.getOneList());
        updateGraph();
        drawShapes();
        updateText();

    }


    // ----------------------------------------------------------
    /**
     * This method is what is executed when the February button is clicked
     * @param button the February button
     */
    public void clickedFebruary(Button button)
    {
        month = "f";
        influencerList.getTwoList();
        influencerRankings =
            new InfluencerListCalculator(influencerList.getTwoList());
        updateGraph();
        drawShapes();
        updateText();
    }


    // ----------------------------------------------------------
    /**
     * This method is what is executed when the March button is clicked
     * @param button the March button
     */
    public void clickedMarch(Button button)
    {
        month = "m";
        influencerList.getThreeList();
        influencerRankings =
            new InfluencerListCalculator(influencerList.getThreeList());
        updateGraph();
        drawShapes();
        updateText();
    }


    // ----------------------------------------------------------
    /**
     * This button is what is executed when the First Quarter button is clicked
     * @param button the First Quarter button
     */
    public void clickedFirstQuarter(Button button)
    {
        month = "a";
        influencerList.getCombinedList();
        influencerRankings =
            new InfluencerListCalculator(influencerList.getCombinedList());
        updateGraph();
        drawShapes();
        updateText();
    }

}
