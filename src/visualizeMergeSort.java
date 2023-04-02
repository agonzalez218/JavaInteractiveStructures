import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class visualizeMergeSort extends JComponent{

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
    class  MergeSortWorker extends SwingWorker<Void, int[]> {
        private final int[] items;
        long delay = 100;
        public MergeSortWorker(int[] unsortedItems) {
            items = Arrays.copyOf(unsortedItems, unsortedItems.length);
        }
        @Override
        protected Void doInBackground() {
            int n = items.length, i;
            int curr_size;
            int left_start;
            for (curr_size = 1; curr_size <= n-1;
                 curr_size = 2*curr_size)
            {
                for (left_start = 0; left_start < n-1;
                     left_start += 2*curr_size)
                {
                    currentFocus.clear();
                    int mid = Math.min(left_start + curr_size - 1, n-1);

                    int right_end = Math.min(left_start
                            + 2*curr_size - 1, n-1);

                    for(i = left_start; i < right_end+1;i++)
                    {
                        currentFocus.add(i);
                    }

                    merge(items, left_start, mid, right_end);
                }
            }
            currentFocus.clear();
            publish(Arrays.copyOf(items, items.length));
            try {
                Thread.sleep( delay);
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
        void merge(int[] arr, int l, int m, int r)
        {
            int i, j, k;
            int n1 = m - l + 1;
            int n2 = r - m;

            int[] L = new int[n1];
            int[] R = new int[n2];

            for (i = 0; i < n1; i++)
                L[i] = arr[l + i];
            for (j = 0; j < n2; j++)
                R[j] = arr[m + 1+ j];

            i = 0;
            j = 0;
            k = l;
            while (i < n1 && j < n2)
            {
                if (L[i] <= R[j])
                {
                    arr[k] = L[i];
                    i++;
                }
                else
                {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1)
            {
                arr[k] = L[i];
                i++;
                k++;
            }

            while (j < n2)
            {
                arr[k] = R[j];
                j++;
                k++;
            }

            publish(Arrays.copyOf(items, items.length));
            try {
                Thread.sleep( delay);
            } catch (Exception ignored) {
            }
        }
    }

    public void mergeSort() {
        new MergeSortWorker(items).execute();
    }

    public visualizeMergeSort( String chosenSortType, List<Integer> testData, int max) {
        JFrame form = new JFrame();
        this.max = max;
        form.setTitle("Visualize "+ chosenSortType+" Algorithm");
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int testDataSize = testData.size();
        int width = 1000;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth()-100;
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
        mergeSort();

        form.getContentPane().add(sortType, BorderLayout.SOUTH);
        form.pack();
        form.setVisible(true);
    }


}