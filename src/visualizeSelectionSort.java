import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class visualizeSelectionSort extends JComponent{

    private int[]items;
    private final int lineWidth;
    private final int max;
    private final List<Integer> currentFocus = new ArrayList<>();

    /*
      Description:
          Displays test data array as bar graph, each element as a line or bar
    */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (int i = 0; i < items.length; i++)
        {
            int height = 300-(int) (((float)items[i] / max) * 290);
            if( height == 300 )
                height = 299;
            if( currentFocus.contains(i) )
                g.setColor( Color.red );
            else
                g.setColor( Color.BLACK );
            g.drawLine(i*lineWidth+10, 300, i*lineWidth+10, height);
        }
    }

    /*
      Description:
          Updates item array and repaints graph
    */
    public void setItems(int[] items) {
        this.items = items;
        repaint();
    }

    /*
      Description:
          Swing Worker used to sort items and update graph and item array with each swap
    */
    class SelectionSortWorker extends SwingWorker<Void, int[]> {
        private final int[] items;
        public SelectionSortWorker(int[] unsortedItems) {
            items = Arrays.copyOf(unsortedItems, unsortedItems.length);
        }
        @Override
        protected Void doInBackground() {
            int n = items.length;
            long delay = 100;
            int temp;

            for (int i = 0; i < n; i++) {
                int min = items[i], minIndex = i;
                for (int j = i; j < n; j++) {
                    if (items[j] < min) {
                        min = items[j];
                        minIndex = j;
                    }
                }

                temp = items[minIndex];
                items[minIndex] = items[i];
                items[i] = temp;

                currentFocus.clear();
                currentFocus.add(i);
                currentFocus.add(minIndex);

                publish(Arrays.copyOf(items, items.length));
                try {
                    Thread.sleep( delay);
                } catch (Exception ignored) {
                }
            }
            currentFocus.clear();
            publish(Arrays.copyOf(items, items.length));
            try {
                Thread.sleep(delay);
            } catch (Exception ignored) {
            }
            return null;
        }
        @Override
        protected void process(List<int[]> list) {
            int[] items = list.get(list.size() - 1);
            setItems(items);
        }
        @Override
        protected void done() {
        }
    }

    public void selectionSort() {
        new SelectionSortWorker(items).execute();
    }

    public visualizeSelectionSort( String chosenSortType, List<Integer> testData, int max) {
        JFrame form = new JFrame();
        this.max = max;
        form.setTitle("Visualize "+ chosenSortType+" Algorithm");
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int testDataSize = testData.size();
        int width = 1000;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth()-100;
        System.out.println(testDataSize);
        if( testDataSize > 500 )
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
        lineWidth = width/testDataSize;
        int []arr = new int[testDataSize];

        for( i = 0; i < testDataSize; i++ )
        {
            arr[i] = testData.get(i);
        }

        items = arr;
        selectionSort();

        form.getContentPane().add(sortType, BorderLayout.SOUTH);
        form.pack();
        form.setVisible(true);
    }
}