package view;

import controller.decodecontrollers.*;
import model.StegoModel;

import javax.swing.*;
import java.awt.*;

public class DecodeView extends JPanel implements View {

    private StegoModel model;
    private StegoView view;

    /**
     * Decode View for StegoTool
     * @param model StegoTool model
     * @param view StegoTool view
     */
    public DecodeView(StegoModel model,StegoView view){
        this.model = model;
        this.view = view;
        buildPanel();
    }

    /**
     * builds Decode Panel
     */
    private void buildPanel(){
        JPanel mainPanel = new JPanel();
        GridLayout mainPanelLayout = new GridLayout(1,3);
        mainPanel.setLayout(mainPanelLayout);
        JPanel leftPanel = getLeftPanel();
        JPanel centerPanel = getCenterPanel();
        JPanel rightPanel = getRightPanel();
        mainPanel.add(leftPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(rightPanel);
        this.add(mainPanel);
    }

    /**
     * builds left hand side panel for the decode view
     * @return JPanel left hand side panel for decode view
     */
    private JPanel getLeftPanel(){
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(2,1));
        JButton sourceButton = new JButton("Choose Source");
        sourceButton.addActionListener(new DecodeModeSourceButtonListener(model,this));
        JButton destinationButton = new JButton("Choose Destination");
        destinationButton.addActionListener(new DecodeModeDestinationButtonListener(model,this));
        leftPanel.add(sourceButton);
        leftPanel.add(destinationButton);
        return leftPanel;
    }

    /**
     * builds center panel for the decode view
     * @return JPanel center panel for decode view
     */
    private JPanel getCenterPanel(){
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1,1));
        String[] algorithmOptions = {"LSB"};
        JComboBox algorithmBox = new JComboBox(algorithmOptions);
        algorithmBox.setSelectedIndex(0);
        algorithmBox.addItemListener(new DecodeModeAlgorithmSelectionListener(model));
        centerPanel.add(algorithmBox);
        return centerPanel;
    }

    /**
     * builds right hand side panel for decode view
     * @return JPanel right hand side panel for decode view
     */
    private JPanel getRightPanel(){
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(1,1));
        JButton goButton = new JButton("RevealPayload");
        goButton.addActionListener(new DecodeModeGoButtonListener(model));
        rightPanel.add(goButton);
        return rightPanel;
    }

    @Override
    public JMenuBar getMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("Switch to Encode Mode");
        menu.add(menuItem);
        menuItem.addActionListener(new DecodeModeMenuListener(model,view));

        return menuBar;
    }
}
