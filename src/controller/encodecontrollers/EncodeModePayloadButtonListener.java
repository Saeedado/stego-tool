package controller.encodecontrollers;

import model.StegoModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EncodeModePayloadButtonListener implements ActionListener {
    private StegoModel model;
    private JPanel panel;

    public EncodeModePayloadButtonListener(StegoModel model, JPanel panel){
        this.model = model;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(panel);
            File file = chooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            model.setPayload(filePath);
            System.out.println(model.getPayload());
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
