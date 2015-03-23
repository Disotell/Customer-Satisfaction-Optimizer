package edu.fgcu.cso;

import javax.swing.*;
import java.awt.*;

/**
 * Created by William on 3/11/2015.
 */
public class GUI {

    protected GUI(){

    }

    public void buildGUI(int[][] matrix, int[] solution){
        if(matrix == null || solution == null){
            showError("IllegalState");
        }
        else if(matrix.length == 0 || solution.length == 0){
            showError("IllegalState2");
        }
        else{
            createUIComponents(matrix, solution);
        }
    }

    /**
     * Shows the error message specified by the constructor
     */
    public void showError(String error){
        //new DialogMessage(error) or something
    }

    private void createUIComponents(int[][] matrix, int[] solution) {
        JFrame frame = buildMainFrame();

        JPanel matrixPanel = buildMatixPanel();

        JTable table = createMatrix(matrix,solution);

        frame.add(matrixPanel, BorderLayout.CENTER);
    }

    //int x, int y, int width, int height
    private JPanel buildMatixPanel(){
        JPanel matrixPanel = new JPanel();
        matrixPanel.setPreferredSize(new Dimension(300, 400));
        matrixPanel.setBackground(Color.red);
        matrixPanel.setVisible(true);
        return matrixPanel;
    }

    private JFrame buildMainFrame(){
        JFrame mainFrame = new JFrame("Customer Satisfaction Optimizer");
        mainFrame.setBounds(0, 0, 700, 500);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBackground(Color.white);
        mainFrame.setVisible(true);
        return mainFrame;
    }

    private JTable createMatrix(int[][] matrix, int[] solution){
        JTable dataMatrix = new JTable();
        return dataMatrix;
    }



}
