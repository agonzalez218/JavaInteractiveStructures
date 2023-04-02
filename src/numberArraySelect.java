import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class numberArraySelect extends JFrame implements ActionListener {
    List<Integer> newTestData = new ArrayList<>();

    boolean arrayChanged = false;
    JPanel form = new JPanel();
    JButton mainMenuBttn = new JButton();
    JButton fillRdmBttn = new JButton();
    JButton[] dataPoint = new JButton[8];
    JButton textBoxBttn = new JButton();

    private void setLocations(){
        this.setSize(600, 350);
        this.setLocationRelativeTo(null);
        mainMenuBttn.setBounds(30, 260, 150, 30);
        fillRdmBttn.setBounds(190, 260, 200, 30);
        textBoxBttn.setBounds(400, 260, 150, 30);
    }

    private void setText(){
        this.setTitle("Change Test Data");
        mainMenuBttn.setText("Return to Main Menu");
        fillRdmBttn.setText("Fill with Random Nums");
        textBoxBttn.setText("Dump Test Data");
    }

    private void addToForm(){
        this.add( mainMenuBttn );
        mainMenuBttn.addActionListener(this);
        this.add( textBoxBttn );
        textBoxBttn.addActionListener(this);
        this.add( fillRdmBttn );
        fillRdmBttn.addActionListener(this);
    }


    public numberArraySelect(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.form.setLayout(null);
        setLocations();
        setText();
        addToForm();

        int i;
        for( i = 0; i < 8; i++ )
        {
            JButton tempSquare = new JButton();
            if( i < 4 )
            {
                tempSquare.setBounds(30+(i*150),25,75,75);
            }
            else {
                tempSquare.setBounds(30+((i-4)*150),150,75,75);
            }
            tempSquare.addActionListener(this);
            dataPoint[i] = tempSquare;
            this.add(dataPoint[i]);
        }
        changeDataPoints();
        this.add(this.form);
    }

    /*
      Description:
          Changes all buttons' number choice and re - randomizes it.
    */
    public void changeDataPoints()
    {
        int i;
        for(i = 0; i < 8; i++)
        {
            dataPoint[i].setText(String.valueOf(ThreadLocalRandom.current().nextInt(0, 1000 + 1)));
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
            for (i = 0; i < newTestData.size(); i++) {
                myWriter.write(newTestData.get(i).toString());
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException ex) {
            System.out.println("Error in Number Array Select finding file");
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Return to Main Menu" -> {
                if( arrayChanged ) {
                    setTestDataFile();
                }

                mainMenu menu = new mainMenu();
                this.setVisible(false);
                menu.setVisible(true);
            }
            case "Fill with Random Nums" -> {
                int i;
                try {
                    FileWriter myWriter = new FileWriter("testData.txt");
                    for(i = 0; i < 20; i++)
                    {
                        newTestData.add(ThreadLocalRandom.current().nextInt(0, 1000 + 1));
                        myWriter.write(newTestData.get(i).toString());
                        myWriter.write("\n");
                    }
                    myWriter.close();
                } catch (IOException ex) {
                    System.out.println("An error occurred.");
                    ex.printStackTrace();
                }
            }
            case "Dump Test Data" ->
            {
                dumpIntegers dump = new dumpIntegers();
                this.setVisible(false);
                dump.setVisible(true);
            }
            default -> {
                arrayChanged = true;
                newTestData.add(Integer.valueOf(str));
                changeDataPoints();
            }
        }
    }
}