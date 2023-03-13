import javax.swing.*;
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

public class mainMenu extends JFrame implements ActionListener {
    List<Integer> testData = new ArrayList<>();
    JPanel form = new JPanel();
    JButton changeTestDataBttn = new JButton();
    JLabel currentDataLbl = new JLabel();

    JLabel currentDataTxt = new JLabel();
    JScrollPane scrollPane = new JScrollPane(currentDataTxt);
    JButton viewStructuresBttn = new JButton();
    JButton viewAlgorithmsBttn = new JButton();
    JButton exitBttn = new JButton();

    private void setLocations(){
        this.setSize(325, 350);
        this.setLocationRelativeTo(null);
        changeTestDataBttn.setBounds(50, 30, 200, 30);
        currentDataLbl.setBounds(50,60,200,30);
        currentDataLbl.setHorizontalAlignment(SwingConstants.CENTER);
        currentDataLbl.setVerticalAlignment(SwingConstants.CENTER);
        scrollPane.setBounds(50,90,200,40);
        currentDataTxt.setBounds(50,90,200,20);
        viewStructuresBttn.setBounds(50, 150, 200, 30);
        viewAlgorithmsBttn.setBounds(50, 200, 200, 30);
        exitBttn.setBounds(50, 260, 200, 30);
    }

    private void setText(){
        this.setTitle("Java Interactive Structures");
        currentDataLbl.setText("Current Data:");
        currentDataTxt.setText(testData.toString().replace("[", "").replace("]", ""));
        changeTestDataBttn.setText("Change Test Data");
        viewStructuresBttn.setText("View Data Structures");
        viewAlgorithmsBttn.setText("View Sort Algorithms");
        exitBttn.setText("Exit Application");
    }

    private void addToForm(){
        this.add( currentDataLbl );
        this.add(scrollPane);
        this.add( changeTestDataBttn );
        changeTestDataBttn.addActionListener(this);
        this.add( viewStructuresBttn );
        viewStructuresBttn.addActionListener(this);
        this.add( viewAlgorithmsBttn );
        viewAlgorithmsBttn.addActionListener(this);
        this.add( exitBttn );
        exitBttn.addActionListener(this);
        this.add(this.form);

    }


    public mainMenu(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.form.setLayout(null);
        setLocations();
        getTestDataFile();
        setText();
        addToForm();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        setTestDataFile();

        switch (str) {
            case "Exit Application" -> {
                try {
                    FileWriter myWriter = new FileWriter("testData.txt");
                    myWriter.write("");
                    myWriter.close();
                } catch (IOException ex) {
                    System.out.println("Error in Number Array Select finding file, creating new one...");
                    ex.printStackTrace();
                }
                System.exit(0);
            }
            case "Change Test Data" -> {
                numberArraySelect numWindow = new numberArraySelect();
                this.setVisible(false);
                numWindow.setVisible(true);
            }
            case "View Data Structures" -> {
                displayStructures structuresWindow = new displayStructures();
                this.setVisible(false);
                structuresWindow.setVisible(true);
            }
            case "View Sort Algorithms" -> {
                displayAlgorithms algorithmsWindow = new displayAlgorithms();
                this.setVisible(false);
                algorithmsWindow.setVisible(true);
            }
        }
    }

    /*
      Description:
          Opens testData.txt file and enters data from TestData list
    */
    public void setTestDataFile() {
        try {
            int i;
            FileWriter myWriter = new FileWriter("testData.txt");
            for (i = 0; i < testData.size(); i++) {
                myWriter.write(testData.get(i).toString());
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException ex) {
            System.out.println("Error in Number Array Select finding file");
            ex.printStackTrace();
        }
    }

    /*
      Description:
          Opens testData.txt file and adds all integers into the TestData list.
          If file not found, fill TestData list with random numbers and create file.
    */
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
}
