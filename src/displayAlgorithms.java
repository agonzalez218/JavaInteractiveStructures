import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class displayAlgorithms extends JFrame implements ActionListener {
    List<Integer> testData = new ArrayList<>();
    JLabel currentDataLbl = new JLabel();
    JLabel currentDataTxt = new JLabel();
    JScrollPane currentDataScrollPane = new JScrollPane(currentDataTxt);
    JLabel bubbleSrtLbl = new JLabel();
    JLabel bubbleSrtData = new JLabel();
    JScrollPane bubbleSrtScrollPane = new JScrollPane(bubbleSrtData);
    JLabel selectionSrtLbl = new JLabel();
    JLabel selectionSrtData = new JLabel();
    JScrollPane selectionSrtScrollPane = new JScrollPane(selectionSrtData);
    JLabel insertionSrtLbl = new JLabel();
    JLabel insertionSrtData = new JLabel();
    JScrollPane insertionSrtScrollPane = new JScrollPane(insertionSrtData);
    JLabel quickSrtLbl = new JLabel();
    JLabel quickSrtData = new JLabel();
    JScrollPane quickSrtScrollPane = new JScrollPane(quickSrtData);
    JLabel mergeSrtLbl = new JLabel();
    JLabel mergeSrtData = new JLabel();
    JScrollPane mergeSrtScrollPane = new JScrollPane(mergeSrtData);
    JLabel bubbleSrtTimeLbl = new JLabel();
    JLabel selectionSrtTimeLbl = new JLabel();
    JLabel insertionSrtTimeLbl = new JLabel();
    JLabel quickSrtTimeLbl = new JLabel();
    JLabel mergeSrtTimeLbl = new JLabel();
    JButton bubbleSrtBttn = new JButton();
    JButton selectionSrtBttn = new JButton();
    JButton insertionSrtBttn = new JButton();
    JButton quickSrtBttn = new JButton();
    JButton mergeSrtBttn = new JButton();
    JButton mainMenuBttn = new JButton();
    JLabel addNumbers = new JLabel();
    JButton add20Bttn = new JButton();
    JButton add100Bttn = new JButton();
    JButton add1000Bttn = new JButton();

    JPanel form = new JPanel();

    private void setLocations(){
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
        currentDataLbl.setBounds(200,10,200,30);
        currentDataLbl.setHorizontalAlignment(SwingConstants.CENTER);
        currentDataLbl.setVerticalAlignment(SwingConstants.CENTER);
        currentDataScrollPane.setBounds(200,40,200,40);

        bubbleSrtLbl.setBounds(50,90,200,30);
        bubbleSrtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        bubbleSrtLbl.setVerticalAlignment(SwingConstants.CENTER);
        insertionSrtLbl.setBounds(350,90,200,30);
        insertionSrtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        insertionSrtLbl.setVerticalAlignment(SwingConstants.CENTER);
        quickSrtLbl.setBounds(50,240,200,30);
        quickSrtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        quickSrtLbl.setVerticalAlignment(SwingConstants.CENTER);
        mergeSrtLbl.setBounds(350,240,200,30);
        mergeSrtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mergeSrtLbl.setVerticalAlignment(SwingConstants.CENTER);
        selectionSrtLbl.setBounds(200,390,200,30);
        selectionSrtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        selectionSrtLbl.setVerticalAlignment(SwingConstants.CENTER);

        bubbleSrtScrollPane.setBounds(50,120,200,40);
        insertionSrtScrollPane.setBounds(350,120,200,40);
        quickSrtScrollPane.setBounds(50,270,200,40);
        mergeSrtScrollPane.setBounds(350,270,200,40);
        selectionSrtScrollPane.setBounds(200,420,200,40);

        bubbleSrtTimeLbl.setBounds(50,160,200,30);
        bubbleSrtTimeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        bubbleSrtTimeLbl.setVerticalAlignment(SwingConstants.CENTER);
        insertionSrtTimeLbl.setBounds(350,160,200,30);
        insertionSrtTimeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        insertionSrtTimeLbl.setVerticalAlignment(SwingConstants.CENTER);
        quickSrtTimeLbl.setBounds(50,310,200,30);
        quickSrtTimeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        quickSrtTimeLbl.setVerticalAlignment(SwingConstants.CENTER);
        mergeSrtTimeLbl.setBounds(350,310,200,30);
        mergeSrtTimeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mergeSrtTimeLbl.setVerticalAlignment(SwingConstants.CENTER);
        selectionSrtTimeLbl.setBounds(200,460,200,30);
        selectionSrtTimeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        selectionSrtTimeLbl.setVerticalAlignment(SwingConstants.CENTER);

        bubbleSrtBttn.setBounds(50,190,200,30);
        insertionSrtBttn.setBounds(350,190,200,30);
        quickSrtBttn.setBounds(50,340,200,30);
        mergeSrtBttn.setBounds(350,340,200,30);
        selectionSrtBttn.setBounds(200,490,200,30);



        addNumbers.setBounds(200,610,300,30);
        add20Bttn.setBounds(50,645,100,30);
        add100Bttn.setBounds(250,645,100,30);
        add1000Bttn.setBounds(450,645,100,30);

        mainMenuBttn.setBounds(200,695,200,30);
    }

    private void setText(){
        this.currentDataLbl.setText("Current Test Data:");
        this.setTitle("Sort Algorithms");

        addNumbers.setText("Add Temporary Numbers to Test Data: ");
        add20Bttn.setText("+20");
        add100Bttn.setText("+100");
        add1000Bttn.setText("+1000");

        bubbleSrtLbl.setText("Bubble Sort");
        selectionSrtLbl.setText("Selection Sort");
        insertionSrtLbl.setText("Insertion Sort");
        quickSrtLbl.setText("Quick Sort");
        mergeSrtLbl.setText("Merge Sort");

        bubbleSrtTimeLbl.setText("Bubble Sort");
        selectionSrtTimeLbl.setText("Selection Sort");
        insertionSrtTimeLbl.setText("Insertion Sort");
        quickSrtTimeLbl.setText("Quick Sort");
        mergeSrtTimeLbl.setText("Merge Sort");

        bubbleSrtBttn.setText("Visualize Bubble Sort");
        selectionSrtBttn.setText("Visualize Selection Sort");
        insertionSrtBttn.setText("Visualize Insertion Sort");
        quickSrtBttn.setText("Visualize Quick Sort");
        mergeSrtBttn.setText("Visualize Merge Sort");

        this.mainMenuBttn.setText("Return to Main Menu");
    }

    private void addToForm(){
        this.add(currentDataLbl);
        this.add(currentDataScrollPane);
        this.add(addNumbers);

        this.add(bubbleSrtTimeLbl);
        this.add(selectionSrtTimeLbl);
        this.add(insertionSrtTimeLbl);
        this.add(quickSrtTimeLbl);
        this.add(mergeSrtTimeLbl);

        this.add(bubbleSrtScrollPane);
        this.add(selectionSrtScrollPane);
        this.add(insertionSrtScrollPane);
        this.add(quickSrtScrollPane);
        this.add(mergeSrtScrollPane);

        this.add(bubbleSrtLbl);
        this.add(selectionSrtLbl);
        this.add(insertionSrtLbl);
        this.add(quickSrtLbl);
        this.add(mergeSrtLbl);

        this.add(bubbleSrtBttn);
        bubbleSrtBttn.addActionListener(this);
        this.add(selectionSrtBttn);
        selectionSrtBttn.addActionListener(this);
        this.add(insertionSrtBttn);
        insertionSrtBttn.addActionListener(this);
        this.add(quickSrtBttn);
        quickSrtBttn.addActionListener(this);
        this.add(mergeSrtBttn);
        mergeSrtBttn.addActionListener(this);
        this.add(add20Bttn);
        add20Bttn.addActionListener(this);
        this.add(add100Bttn);
        add100Bttn.addActionListener(this);
        this.add(add1000Bttn);
        add1000Bttn.addActionListener(this);
        this.add(mainMenuBttn);
        mainMenuBttn.addActionListener(this);
    }


    public displayAlgorithms(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.form.setLayout(null);
        setLocations();
        setText();
        addToForm();
        getTestDataFile();
        currentDataTxt.setText(testData.toString().replace("[", "").replace("]", ""));

        sortTestData();

        this.add(this.form);
    }

    public void getTestDataFile() {
        try {
            File myObj = new File("testData.txt");
            Scanner myReader = new Scanner(myObj);
            int counter = 0;
            while (myReader.hasNextLine()) {
                counter += 1;
                try {
                    testData.add(Integer.valueOf(myReader.nextLine()));
                }
                catch(NumberFormatException n){
                    System.out.println("Line " + counter + " in file did not contain integer");
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error in Main Menu finding file, creating new one...");
            int i;
            try {
                FileWriter myWriter = new FileWriter("testData.txt");
                for(i = 0; i < 20; i++)
                {
                    testData.add(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
                    myWriter.write(testData.get(i).toString());
                    myWriter.write("\n");
                }
                myWriter.close();
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }
        }
    }

    public void sortTestData(){
        List<Integer> bblSrtList = new ArrayList<>(testData);
        bubbleSort(bblSrtList);
        List<Integer> selectionSrtList = new ArrayList<>(testData);
        selectionSort(selectionSrtList);
        List<Integer> insertionSrtList = new ArrayList<>(testData);
        insertionSort(insertionSrtList);
        List<Integer> quickSrtList = new ArrayList<>(testData);

        long startTime = System.nanoTime();
        quickSort(quickSrtList, 0, quickSrtList.size()-1);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        quickSrtTimeLbl.setText("Time: "+((float)duration / 1000000000 )+" seconds");
        quickSrtTimeLbl.setToolTipText(String.format("%.9f", (float)duration/1000000000)+" seconds");
        quickSrtData.setText(quickSrtList.toString().replace("[", "").replace("]", ""));

        List<Integer> mergeSrtList = new ArrayList<>(testData);
        startTime = System.nanoTime();
        mergeSort(mergeSrtList, 0, mergeSrtList.size()-1);
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        mergeSrtTimeLbl.setText("Time: "+((float)duration / 1000000000 )+" seconds");
        mergeSrtTimeLbl.setToolTipText(String.format("%.9f", (float)duration/1000000000)+" seconds");
        mergeSrtData.setText(mergeSrtList.toString().replace("[", "").replace("]", ""));
    }

    public void bubbleSort(List<Integer> unsortedList){
        long startTime = System.nanoTime();

        int i,j;
        for( i = 0; i < unsortedList.size(); i++)
        {
            for( j = 0; j < unsortedList.size() - i; j++)
            {
                if( unsortedList.size() > (j+1) && unsortedList.get(j) > unsortedList.get(j+1) )
                {
                    int temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(j + 1));
                    unsortedList.set(j+1, temp);
                }
            }
        }

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        bubbleSrtTimeLbl.setText("Time: "+((float)duration / 1000000000 )+" seconds");
        bubbleSrtTimeLbl.setToolTipText(String.format("%.9f", (float)duration/1000000000)+" seconds");
        bubbleSrtData.setText(unsortedList.toString().replace("[", "").replace("]", ""));
    }

    public void selectionSort(List<Integer> unsortedList){
        long startTime = System.nanoTime();

        int i,j;
        for( i = 0; i < unsortedList.size(); i++)
        {
            int min = unsortedList.get(i), minIndex = i;
            for( j = i; j < unsortedList.size(); j++)
            {
                if( unsortedList.get(j) < min)
                {
                    min = unsortedList.get(j);
                    minIndex = j;
                }
            }
            int temp = unsortedList.get(i);
            unsortedList.set(i, unsortedList.get(minIndex));
            unsortedList.set(minIndex, temp);
        }

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        selectionSrtTimeLbl.setText("Time: "+((float)duration / 1000000000 )+" seconds");
        selectionSrtTimeLbl.setToolTipText(String.format("%.9f", (float)duration/1000000000)+" seconds");
        selectionSrtData.setText(unsortedList.toString().replace("[", "").replace("]", ""));

    }
    public void mergeSort(List<Integer> unsortedList, int left, int right){
        if (left < right) {
            int m = left + (right - left) / 2;

            mergeSort(unsortedList, left, m);
            mergeSort(unsortedList, m + 1, right);

            merge(unsortedList, left, m, right);
        }
    }
    public void merge(List<Integer> unsortedList, int left, int middle, int right){
        int i, j = 0;

        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftSide = new int[n1];
        int[] rightSide = new int[n2];

        for (i = 0; i < n1; ++i)
            leftSide[i] = unsortedList.get(left + i);
        for (i = 0; i < n2; ++i)
            rightSide[i] = unsortedList.get(middle + 1 + i);

        i = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftSide[i] <= rightSide[j]) {
                unsortedList.set(k,leftSide[i]);
                i++;
            }
            else {
                unsortedList.set(k,rightSide[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            unsortedList.set(k, leftSide[i]);
            i++;
            k++;
        }

        while (j < n2) {
            unsortedList.set(k, rightSide[j]);
            j++;
            k++;
        }
    }

    public void insertionSort(List<Integer> unsortedList){
        long startTime = System.nanoTime();

        int i, j;
        for( i = 0; i < unsortedList.size(); i++)
        {
            j = i;
            while (j > 0 && unsortedList.get(j-1) > unsortedList.get(j))
            {
                int temp = unsortedList.get(j-1);
                unsortedList.set(j-1, unsortedList.get(j));
                unsortedList.set(j, temp);
                j--;
            }
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        insertionSrtTimeLbl.setText("Time: "+((float)duration / 1000000000 )+" seconds");
        insertionSrtTimeLbl.setToolTipText(String.format("%.9f", (float)duration/1000000000)+" seconds");
        insertionSrtData.setText(unsortedList.toString().replace("[", "").replace("]", ""));
    }
    public void quickSort(List<Integer> unsortedList, int low, int high){
        if( low < high ){
            int pi = partition(unsortedList, low, high);
            quickSort(unsortedList, low, pi - 1);
            quickSort(unsortedList, pi + 1, high);
        }
    }

    public int partition(List<Integer> unsortedList, int low, int high){
        int pivot = unsortedList.get(high);
        int i = low - 1, j;
        for( j = low; j<= high-1; j++ )
        {
            if( unsortedList.get(j) < pivot ){
                i++;
                int temp = unsortedList.get(j);
                unsortedList.set(j, unsortedList.get(i));
                unsortedList.set(i, temp);
            }
        }
        int temp = unsortedList.get(high);
        unsortedList.set(high, unsortedList.get(i+1));
        unsortedList.set(i+1, temp);
        return i+1;
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        switch (str) {
            case "Return to Main Menu" -> {
                mainMenu menu = new mainMenu();
                this.setVisible(false);
                menu.setVisible(true);
            }
            case "+20" -> {
                if( testData.size() + 20 > width )
                {
                    int result = JOptionPane.showConfirmDialog(this,"ERROR: Adding more integers to array will exceed screen size. Proceed Anyway?", "List Size Exceeds Screen Size",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if( result == JOptionPane.NO_OPTION)
                        return;
                }
                int i;
                for(i = 0; i < 20; i++)
                {
                    testData.add(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
                }
                currentDataTxt.setText(testData.toString().replace("[", "").replace("]", ""));
                sortTestData();
            }
            case "+100" -> {
                if( testData.size() + 100 > width )
                {
                    int result = JOptionPane.showConfirmDialog(this,"ERROR: Adding more integers to array will exceed screen size. Proceed Anyway?", "List Size Exceeds Screen Size",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if( result == JOptionPane.NO_OPTION)
                        return;
                }
                int i;
                for(i = 0; i < 100; i++)
                {
                    testData.add(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
                }
                currentDataTxt.setText(testData.toString().replace("[", "").replace("]", ""));
                sortTestData();
            }
            case "+1000" -> {
                if( testData.size() + 1000 > width )
                {
                    int result = JOptionPane.showConfirmDialog(this,"ERROR: Adding more integers to array will exceed screen size. Proceed Anyway?", "List Size Exceeds Screen Size",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if( result == JOptionPane.NO_OPTION)
                        return;
                }
                int i;
                for (i = 0; i < 1000; i++) {
                    testData.add(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
                }
                currentDataTxt.setText(testData.toString().replace("[", "").replace("]", ""));
                sortTestData();
            }
            case "Visualize Quick Sort" -> {
                List<Integer> tempList = new ArrayList<>(testData);
                visualizeQuickSort quickSorter = new visualizeQuickSort("Quick Sort", tempList);
                quickSorter.setVisible(true);
            }
            case "Visualize Bubble Sort" -> {
                List<Integer> tempList = new ArrayList<>(testData);
                visualizeBubbleSort bubbleSorter = new visualizeBubbleSort("Bubble Sort", tempList);
                bubbleSorter.setVisible(true);
            }
            case "Visualize Merge Sort" -> {
                List<Integer> tempList = new ArrayList<>(testData);
                visualizeMergeSort mergeSorter = new visualizeMergeSort("Merge Sort", tempList);
                mergeSorter.setVisible(true);
            }
            case "Visualize Insertion Sort" -> {
                List<Integer> tempList = new ArrayList<>(testData);
                visualizeInsertionSort insertionSorter = new visualizeInsertionSort("Insertion Sort", tempList);
                insertionSorter.setVisible(true);
            }
            case "Visualize Selection Sort" -> {
                List<Integer> tempList = new ArrayList<>(testData);
                visualizeSelectionSort selectionSorter = new visualizeSelectionSort("Selection Sort", tempList);
                selectionSorter.setVisible(true);
            }
        }
    }
}
