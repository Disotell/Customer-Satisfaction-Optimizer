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
    public static final String ERROR_LABEL = "errorLabel";

    public JFrame frame;

    protected GUI() {

    }

    public void buildGUI(int[][] matrix, int[] solution) {
        if (matrix == null || matrix.length == 0) {
            showError("Error parsing data matrix from file", "Error Message 1");
        }
        else if(solution == null || solution.length == 0){
            showError("Multiple or no solution found for matrix", "Error Message 2");
        }
        else {
            createUIComponents(matrix, solution);
        }
    }

    /**
     * Shows the error message specified by the constructor
     */
    public void showError(String error, String title) {
        if(error == null || title == null){
            return;
        }

        JFrame frame = buildMainFrame();
        frame.setTitle(title);

        JPanel panel = new JPanel();

        JLabel errorLabel = new JLabel(error);
        errorLabel.setName(ERROR_LABEL);

        panel.add(errorLabel);
        frame.add(panel);

        frame.setVisible(true);
        panel.setVisible(true);
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
        mainFrame.setName(MAIN_WINDOW_NAME);
        mainFrame.setBounds(0, 0, 700, 500);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame = mainFrame;
        return mainFrame;
    }

    public JTable createMatrix(int[][] matrix, int[] solution) {
        if(matrix == null || solution == null){
            return null;
        }

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
