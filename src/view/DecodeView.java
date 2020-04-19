package view;

import model.StegoModel;

import javax.swing.*;
import java.awt.*;

public class DecodeView extends JPanel implements View {

    private StegoModel model;

    /**
     * Decode View for StegoTool
     * @param model StegoTool model
     */
    public DecodeView(StegoModel model){
        this.model = model;
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
        JButton destinationButton = new JButton("Choose Destination");
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
        String[] algorithmOptions = {"LSB","BPCS"};
        JComboBox algorithmBox = new JComboBox(algorithmOptions);
        algorithmBox.setSelectedIndex(0);
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
        JButton goButton = new JButton("Go");
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
        return menuBar;
    }
}