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
    JLabel bubbleSrtLbl = new JLabel();
    JLabel selectionSrtLbl = new JLabel();
    JLabel insertionSrtLbl = new JLabel();
    JLabel quickSrtLbl = new JLabel();
    JLabel mergeSrtLbl = new JLabel();
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
    JScrollPane currentDataScrollPane = new JScrollPane(currentDataTxt);

    JPanel form = new JPanel();

    private void setLocations(){
        this.setSize(600, 780);
        this.setLocationRelativeTo(null);
        currentDataLbl.setBounds(200,10,200,30);
        currentDataLbl.setHorizontalAlignment(SwingConstants.CENTER);
        currentDataLbl.setVerticalAlignment(SwingConstants.CENTER);
        currentDataScrollPane.setBounds(200,40,200,40);

        bubbleSrtLbl.setBounds(200,90,200,30);
        bubbleSrtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        bubbleSrtLbl.setVerticalAlignment(SwingConstants.CENTER);
        insertionSrtLbl.setBounds(200,190,200,30);
        insertionSrtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        insertionSrtLbl.setVerticalAlignment(SwingConstants.CENTER);
        quickSrtLbl.setBounds(200,290,200,30);
        quickSrtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        quickSrtLbl.setVerticalAlignment(SwingConstants.CENTER);
        mergeSrtLbl.setBounds(200,390,200,30);
        mergeSrtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mergeSrtLbl.setVerticalAlignment(SwingConstants.CENTER);
        selectionSrtLbl.setBounds(200,490,200,30);
        selectionSrtLbl.setHorizontalAlignment(SwingConstants.CENTER);
        selectionSrtLbl.setVerticalAlignment(SwingConstants.CENTER);

        bubbleSrtTimeLbl.setBounds(200,120,200,30);
        bubbleSrtTimeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        bubbleSrtTimeLbl.setVerticalAlignment(SwingConstants.CENTER);
        insertionSrtTimeLbl.setBounds(200,220,200,30);
        insertionSrtTimeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        insertionSrtTimeLbl.setVerticalAlignment(SwingConstants.CENTER);
        quickSrtTimeLbl.setBounds(200,320,200,30);
        quickSrtTimeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        quickSrtTimeLbl.setVerticalAlignment(SwingConstants.CENTER);
        mergeSrtTimeLbl.setBounds(200,420,200,30);
        mergeSrtTimeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mergeSrtTimeLbl.setVerticalAlignment(SwingConstants.CENTER);
        selectionSrtTimeLbl.setBounds(200,520,200,30);
        selectionSrtTimeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        selectionSrtTimeLbl.setVerticalAlignment(SwingConstants.CENTER);

        bubbleSrtBttn.setBounds(200,150,200,30);
        selectionSrtBttn.setBounds(200,250,200,30);
        insertionSrtBttn.setBounds(200,350,200,30);
        quickSrtBttn.setBounds(200,450,200,30);
        mergeSrtBttn.setBounds(200,550,200,30);



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
            }
            case "Visualize Quick Sort" -> {
                visualizeSortAlgo algorithmsWindow = new visualizeSortAlgo("Quick Sort", testData);
                algorithmsWindow.setVisible(true);
            }
            case "Visualize Bubble Sort" -> {
                visualizeSortAlgo algorithmsWindow = new visualizeSortAlgo("Bubble Sort", testData);
                algorithmsWindow.setVisible(true);
            }
            case "Visualize Merge Sort" -> {
                visualizeSortAlgo algorithmsWindow = new visualizeSortAlgo("Merge Sort", testData);
                algorithmsWindow.setVisible(true);
            }
            case "Visualize Insertion Sort" -> {
                visualizeSortAlgo algorithmsWindow = new visualizeSortAlgo("Insertion Sort", testData);
                algorithmsWindow.setVisible(true);
            }
            case "Visualize Selection Sort" -> {
                visualizeSortAlgo algorithmsWindow = new visualizeSortAlgo("Selection Sort", testData);
                algorithmsWindow.setVisible(true);
            }
        }
    }
}
