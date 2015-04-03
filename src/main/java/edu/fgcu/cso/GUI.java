package edu.fgcu.cso;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by William on 3/11/2015.
 */
public class GUI {
    public static final String MAIN_WINDOW_NAME = "mainWindow";
    public static final String TABLE_NAME = "mainTable";

    protected GUI() {

    }

    public void buildGUI(int[][] matrix, int[] solution) {
        if (matrix == null || solution == null) {
            showError("IllegalState", "Error Message 1");
        } else if (matrix.length == 0 || solution.length == 0) {
            showError("IllegalState2", "Error Message 2");
        } else {
            createUIComponents(matrix, solution);
        }
    }

    /**
     * Shows the error message specified by the constructor
     */
    public void showError(String error, String title) {


        JOptionPane.showMessageDialog(null, error, title, JOptionPane.ERROR_MESSAGE);

/*
        JFrame mainFrame = new JFrame(ERROR_TITLE);
        mainFrame.setName(MAIN_WINDOW);
        mainFrame.setBounds(0, 0, 700, 500);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBackground(Color.white);



        JButton temp2 = new JButton("MyButton");
        temp2.setName("BUTTON");


        JPanel panel = new JPanel();
        panel.add(temp2);
        mainFrame.add(panel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
        panel.setVisible(true);
        temp2.setVisible(true);
        */
    }

    public void createUIComponents(int[][] matrix, int[] solution) {
        JFrame frame = buildMainFrame();

        JPanel matrixPanel = buildMatixPanel();

        JTable table = createMatrix(matrix, solution);

        JScrollPane scrollPane = new JScrollPane(table);

        matrixPanel.add(scrollPane);
        frame.add(matrixPanel, BorderLayout.CENTER);

        frame.setVisible(true);
        matrixPanel.setVisible(true);
        scrollPane.setVisible(true);
        table.setVisible(true);
    }

    public JPanel buildMatixPanel() {
        JPanel matrixPanel = new JPanel();
        matrixPanel.setPreferredSize(new Dimension(300, 400));
        matrixPanel.setBackground(Color.gray);
        return matrixPanel;
    }

    public JFrame buildMainFrame() {
        JFrame mainFrame = new JFrame("Customer Satisfaction Optimizer");
        mainFrame.setBounds(0, 0, 700, 500);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return mainFrame;
    }

    public JTable createMatrix(int[][] matrix, int[] solution) {
        JTable dataMatrix = new AccentedTable(matrix.length, matrix[0].length, solution);
        dataMatrix.setName(TABLE_NAME);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dataMatrix.getModel().setValueAt(Integer.toString(matrix[i][j]),i,j);
            }
        }

        dataMatrix.setTableHeader(null);

        return dataMatrix;
    }


    public class AccentedTable extends JTable{

        int[] highlightedColumnIndices;

        public AccentedTable(int numRows, int numColumns, int[] highlightedColumnIndices) {
            super(numRows, numColumns);
            this.highlightedColumnIndices = highlightedColumnIndices;
        }

        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            Component comp = super.prepareRenderer(renderer, row, column);
            if(highlightedColumnIndices[row] == column){
                comp.setForeground(Color.red);
            }
            else{
                comp.setForeground(Color.black);
            }
            return comp;
        }
    }
}
