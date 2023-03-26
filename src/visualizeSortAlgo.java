import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class visualizeSortAlgo extends JComponent{
    private final LinkedList<Line> lines = new LinkedList<>();

    private record Line(int x1, int y1, int x2, int y2, Color color) {
    }


    protected void paintComponent(Graphics g) {
        for (Line line : lines) {
            g.setColor(line.color);
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
    }

    public visualizeSortAlgo( String chosenSortType, List<Integer> testData) {
        JFrame form = new JFrame();
        form.setTitle("Visualize "+ chosenSortType+" Algorithm");
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int testDataSize = testData.size();
        int width = 1000;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth()-100;
        System.out.println(testDataSize);
        if( testDataSize > 200 )
        {
            if( testDataSize > screenWidth)
            {
                testDataSize = screenWidth;
            }
            width = testDataSize+20;
        }
        JLabel sortType = new JLabel();
        this.setPreferredSize(new Dimension(width, 300));
        sortType.setHorizontalAlignment(SwingConstants.CENTER);
        form.getContentPane().add(this, BorderLayout.CENTER);
        sortType.setText(chosenSortType);
        sortType.setBounds(50,25,100,30);

        int i;
        int lineWidth = width/testDataSize;
        for (i = 0; i < testDataSize;i++)
        {
            Color color = new Color(0,0,0);
            lines.add(new Line(i*lineWidth+10,300,i*lineWidth+10,300-testData.get(i)/4, color));
            repaint();
        }
        form.getContentPane().add(sortType, BorderLayout.SOUTH);
        form.pack();
        form.setVisible(true);
    }

}