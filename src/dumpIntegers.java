import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class dumpIntegers extends JFrame implements ActionListener {
    JPanel form = new JPanel();
    JTextArea  dumpText = new JTextArea();
    JScrollPane dumpTextScroll = new JScrollPane(dumpText);
    JButton returnToMainMenu = new JButton("Return to Change Test Data");
    JButton enterIntegers = new JButton("Dump Integers");

    private void setLocations(){
        this.setSize(325, 390);
        this.setLocationRelativeTo(null);
        dumpTextScroll.setBounds(50,20,200,200);
        dumpText.setLineWrap(true);
        returnToMainMenu.setBounds(50,250,200,40);
        enterIntegers.setBounds(50,290,200,40);
    }

    private void setText(){
        this.setTitle("Dump Integers into Test Data");
    }

    private void addToForm(){
        this.add( dumpTextScroll );
        this.add(returnToMainMenu);
        returnToMainMenu.addActionListener(this);
        this.add( enterIntegers );
        enterIntegers.addActionListener(this);
        this.add(this.form);
    }

    public dumpIntegers(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.form.setLayout(null);
        setLocations();
        setText();
        addToForm();
        this.setVisible(true);
    }

    /*
      Description:
          Opens testData.txt file and enters data from TestData list
    */
    public void setTestDataFile() {
        try {
            String []txtField = dumpText.getText().split("\n");
            FileWriter myWriter = new FileWriter("testData.txt");
            for(String line: txtField){
                myWriter.write(line);
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException ex) {
            System.out.println("Error in Number Array Select finding file");
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Return to Change Test Data" -> {
                numberArraySelect numChange = new numberArraySelect();
                this.setVisible(false);
                numChange.setVisible(true);
            }
            case "Dump Integers" -> {
                if(Objects.equals(dumpText.getText(), "")) {
                    JOptionPane.showMessageDialog(null, "ERROR: No numbers entered to dump...");
                    return;
                }
                setTestDataFile();
                numberArraySelect numChange = new numberArraySelect();
                this.setVisible(false);
                numChange.setVisible(true);
            }
        }
    }
}
