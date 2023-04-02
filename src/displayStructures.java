import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class JTextFieldLimit extends PlainDocument {
    private final int limit;
    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}

public class displayStructures extends JFrame implements ActionListener {
    List<Integer> testData = new ArrayList<>();
    LinkedList<Integer> queue = new LinkedList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    Node BST;
    String postOrderString = "";
    String inOrderString = "";
    String preOrderString = "";
    JButton mainMenuBttn = new JButton();
    JLabel setLbl = new JLabel();
    JLabel setTxt = new JLabel();
    JScrollPane setScrollPane = new JScrollPane(setTxt);
    JLabel BSTLbl = new JLabel();
    JLabel preorderLbl = new JLabel();
    JLabel preorderTxt = new JLabel();
    JScrollPane preorderScrollPane = new JScrollPane(preorderTxt);
    JLabel inorderLbl = new JLabel();
    JLabel inorderTxt = new JLabel();
    JScrollPane inorderScrollPane = new JScrollPane(inorderTxt);
    JLabel postorderLbl = new JLabel();
    JLabel postorderTxt = new JLabel();
    JScrollPane postorderScrollPane = new JScrollPane(postorderTxt);
    JLabel LLLbl = new JLabel();
    JLabel LLTxt = new JLabel();
    JScrollPane LLScrollPane = new JScrollPane(LLTxt);
    JLabel stackLbl = new JLabel();
    JLabel stackTxt = new JLabel();
    JScrollPane stackScrollPane = new JScrollPane(stackTxt);
    JButton popBttn = new JButton();
    JButton pushBttn = new JButton();
    JTextField enterPushNumber = new JTextField("#");
    JLabel queueLbl = new JLabel();
    JLabel queueTxt = new JLabel();

    JScrollPane queueScrollPane = new JScrollPane(queueTxt);
    JButton enqueueBttn = new JButton();
    JButton dequeueBttn = new JButton();
    JTextField enterQueueNumber = new JTextField("#");
    JLabel currentDataLbl = new JLabel();
    JLabel currentDataTxt = new JLabel();
    JScrollPane currentDataScrollPane = new JScrollPane(currentDataTxt);
    JPanel form = new JPanel();

    private void setLocations(){
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
        currentDataLbl.setBounds(200,10,200,30);
        currentDataLbl.setHorizontalAlignment(SwingConstants.CENTER);
        currentDataLbl.setVerticalAlignment(SwingConstants.CENTER);

        currentDataScrollPane.setBounds(200,40,200,40);

        setLbl.setBounds(200,100,200,30);
        setLbl.setHorizontalAlignment(SwingConstants.CENTER);
        setLbl.setVerticalAlignment(SwingConstants.CENTER);

        setScrollPane.setBounds(200,130,200,40);

        BSTLbl.setBounds(200,190,200,30);
        BSTLbl.setHorizontalAlignment(SwingConstants.CENTER);
        BSTLbl.setVerticalAlignment(SwingConstants.CENTER);

        preorderLbl.setBounds(50,220,200,30);
        preorderLbl.setHorizontalAlignment(SwingConstants.CENTER);
        preorderLbl.setVerticalAlignment(SwingConstants.CENTER);

        preorderScrollPane.setBounds(80,250,130,40);

        inorderLbl.setBounds(200,220,200,30);
        inorderLbl.setHorizontalAlignment(SwingConstants.CENTER);
        inorderLbl.setVerticalAlignment(SwingConstants.CENTER);

        inorderScrollPane.setBounds(235,250,125,40);

        postorderLbl.setBounds(350,220,200,30);
        postorderLbl.setHorizontalAlignment(SwingConstants.CENTER);
        postorderLbl.setVerticalAlignment(SwingConstants.CENTER);

        postorderScrollPane.setBounds(380,250,130,40);

        LLLbl.setBounds(200,310,200,30);
        LLLbl.setHorizontalAlignment(SwingConstants.CENTER);
        LLLbl.setVerticalAlignment(SwingConstants.CENTER);

        LLScrollPane.setBounds(200,340,200,40);

        stackLbl.setBounds(200,400,200,30);
        stackLbl.setHorizontalAlignment(SwingConstants.CENTER);
        stackLbl.setVerticalAlignment(SwingConstants.CENTER);

        stackScrollPane.setBounds(200,430,200,40);

        enterPushNumber.setBounds(465,490,30,30);
        enterPushNumber.setHorizontalAlignment(SwingConstants.CENTER);
        enterPushNumber.setDocument(new JTextFieldLimit(3));
        popBttn.setBounds(150,490,100,30);
        pushBttn.setBounds(350,490,100,30);

        queueLbl.setBounds(200,550,200,30);
        queueLbl.setHorizontalAlignment(SwingConstants.CENTER);
        queueLbl.setVerticalAlignment(SwingConstants.CENTER);

        queueScrollPane.setBounds(200,580,200,40);

        enterQueueNumber.setBounds(465,640,30,30);
        enterQueueNumber.setHorizontalAlignment(SwingConstants.CENTER);
        enterQueueNumber.setDocument(new JTextFieldLimit(3));
        dequeueBttn.setBounds(150,640,100,30);
        enqueueBttn.setBounds(350,640,100,30);

        mainMenuBttn.setBounds(200,700,200,30);

    }

    private void setText(){

        ImageIcon icon = (ImageIcon)UIManager.getIcon("OptionPane.informationIcon");
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        Icon scaledIcon = new ImageIcon( scaledImage );

        this.setTitle("Data Structures");
        this.currentDataLbl.setText("Current Test Data:");
        this.setLbl.setText("Set Structure:");
        this.setLbl.setHorizontalTextPosition(SwingConstants.LEFT);
        this.setLbl.setIcon( scaledIcon );
        this.setLbl.setToolTipText("<html><p>" + "Set Structure: <br> Only allows unique values and does not add duplicates" + "</p></html>");
        this.BSTLbl.setText("Binary Search Tree Structure:");
        this.BSTLbl.setHorizontalTextPosition(SwingConstants.LEFT);
        this.BSTLbl.setIcon( scaledIcon );
        this.BSTLbl.setToolTipText("<html><p>" + "Binary Search Tree: <br> Uses Linked List structure to create a Tree structure. <br> The tree starts with a single node called the root, then <br> every value less than goes the left subtree and <br> values higher go the the right subtree." + "</p></html>");
        this.preorderLbl.setText("Pre-order Print:");
        this.preorderLbl.setHorizontalTextPosition(SwingConstants.LEFT);
        this.preorderLbl.setIcon( scaledIcon );
        this.preorderLbl.setIcon( scaledIcon );
        this.preorderLbl.setToolTipText("<html><p>" + "Preorder Print Method: <br> This displays the nodes in order from left subtree then to the root then to right subtree" + "</p></html>");
        this.inorderLbl.setText("In-order Print:");
        this.inorderLbl.setHorizontalTextPosition(SwingConstants.LEFT);
        this.inorderLbl.setIcon( scaledIcon );
        this.inorderLbl.setIcon( scaledIcon );
        this.inorderLbl.setToolTipText("<html><p>" + "Inorder Print Method: <br> This displays the nodes sorted and in order from root to the left subtree then to the right subtree" + "</p></html>");
        this.postorderLbl.setText("Post-order Print:");
        this.postorderLbl.setHorizontalTextPosition(SwingConstants.LEFT);
        this.postorderLbl.setIcon( scaledIcon );
        this.postorderLbl.setToolTipText("<html><p>" + "Postorder Print Method: <br> This displays the nodes in order from left subtree to the right subtree then to the root" + "</p></html>");
        this.LLLbl.setText("Linked List Structure:");
        this.LLLbl.setHorizontalTextPosition(SwingConstants.LEFT);
        this.LLLbl.setIcon( scaledIcon );
        this.LLLbl.setToolTipText("<html><p>" + "Linked List Structure: <br>Uses a node class to store two values for each element in list. <ul> <li>a reference to the next linked node in the list</li> <li>and the node's data value</li></ul>" + "</p></html>");
        this.stackLbl.setText("Stack Structure:");
        this.stackLbl.setHorizontalTextPosition(SwingConstants.LEFT);
        this.stackLbl.setIcon( scaledIcon );
        this.stackLbl.setToolTipText("<html><p>" + "Stack Structure: <br>Uses linked list structure to implement first in, last out structure" + "</p></html>");
        this.pushBttn.setText("Push");
        this.popBttn.setText("Pop");
        this.queueLbl.setText("Queue Structure:");
        this.queueLbl.setHorizontalTextPosition(SwingConstants.LEFT);
        this.queueLbl.setIcon( scaledIcon );
        this.queueLbl.setToolTipText("<html><p>" + "Queue Structure: <br>Uses linked list structure to implement first in, first out structure" + "</p></html>");
        this.enqueueBttn.setText("Enqueue");
        this.dequeueBttn.setText("Dequeue");
        this.mainMenuBttn.setText("Return to Main Menu");
    }

    private void addToForm(){
        this.add(currentDataLbl);
        this.add(currentDataScrollPane);
        this.add(setLbl);
        this.add(setScrollPane);
        this.add(BSTLbl);
        this.add(preorderLbl);
        this.add(preorderScrollPane);
        this.add(inorderLbl);
        this.add(inorderScrollPane);
        this.add(postorderLbl);
        this.add(postorderScrollPane);
        this.add(LLLbl);
        this.add(LLScrollPane);
        this.add(stackLbl);
        this.add(stackScrollPane);
        this.add(pushBttn);
        this.add(enterPushNumber);
        pushBttn.addActionListener(this);
        this.add(popBttn);
        popBttn.addActionListener(this);
        this.add(enqueueBttn);
        this.add(queueLbl);
        this.add(queueScrollPane);
        this.add(enterQueueNumber);
        enqueueBttn.addActionListener(this);
        this.add(dequeueBttn);
        dequeueBttn.addActionListener(this);
        this.add(mainMenuBttn);
        mainMenuBttn.addActionListener(this);
    }


    public displayStructures(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.form.setLayout(null);
        setLocations();
        setText();
        addToForm();

        getTestDataFile();

        currentDataTxt.setText(testData.toString().replace("[", "").replace("]", ""));
        createSet();
        createBST();
        preOrderString = preOrderString.substring(0, preOrderString.length() - 2);
        inOrderString = inOrderString.substring(0, inOrderString.length() - 2);
        postOrderString = postOrderString.substring(0, postOrderString.length() - 2);
        preorderTxt.setText(preOrderString);
        inorderTxt.setText(inOrderString);
        postorderTxt.setText(postOrderString);
        createLinkedList();
        createStack();
        createQueue();

        this.add(this.form);
    }

    public void createSet(){
        int i;
        List<Integer> set = new ArrayList<>();
        for (i = 0; i < testData.size(); i++)
        {
            if(!set.contains(testData.get(i)))
            {
                set.add(testData.get(i));
            }
        }
        setTxt.setText(set.toString().replace("[", "").replace("]", ""));
    }

    static class Node{
        int data;
        Node left, right;

        public Node(int val)
        {
            data = val;
            left = right = null;
        }
    }

    Node insertBST(Node root, int val)
    {
        if( root == null )
        {
            return new Node(val);
        }
        else if( root.data > val )
        {
            root.left = insertBST(root.left, val);
        }
        else if( root.data < val )
        {
            root.right = insertBST(root.right, val);
        }
        return root;
    }

    public void createBST(){
        int i;
        BST = new Node(testData.get(0));
        for (i = 1; i < testData.size(); i++)
        {
            insertBST(BST, testData.get(i));
        }
        traverseBST(BST);
    }

    void traverseBST(Node root)
    {
        if (root != null ) {

            preOrderString += root.data;
            preOrderString += ", ";
            traverseBST(root.left);
            inOrderString += root.data;
            inOrderString += ", ";
            traverseBST(root.right);
            postOrderString += root.data;
            postOrderString += ", ";
        }
    }

    public void createQueue(){
        int i;
        for (i = 0; i < testData.size(); i++)
        {
            queue.addLast(testData.get(i));
        }
        queueTxt.setText(queue.toString().replace("[", "").replace("]", ""));
    }

    public void createStack(){
        int i;
        for (i = 0; i < testData.size(); i++)
        {
            stack.addFirst(testData.get(i));
        }
        stackTxt.setText(stack.toString().replace("[", "").replace("]", ""));
    }

    public void createLinkedList(){
        int i;
        Node linkedList = new Node(testData.get(0));
        Node tempPtr = linkedList;
        for (i = 1; i < testData.size(); i++)
        {
            tempPtr.right = new Node(testData.get(i));
            tempPtr = tempPtr.right;
        }
        tempPtr = linkedList;
        StringBuilder LLstring = new StringBuilder();
        while(tempPtr != null)
        {
            LLstring.append(tempPtr.data);
            LLstring.append(", ");
            tempPtr = tempPtr.right;
        }
        LLstring = new StringBuilder(LLstring.substring(0, LLstring.length() - 2));
        LLTxt.setText(String.valueOf(LLstring));
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
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Return to Main Menu" -> {
                mainMenu menu = new mainMenu();
                this.setVisible(false);
                menu.setVisible(true);
            }
            case "Enqueue" -> {
                queue.addLast(Integer.valueOf(enterQueueNumber.getText()));
                queueTxt.setText(queue.toString().replace("[", "").replace("]", ""));
            }
            case "Dequeue" -> {
                queue.removeFirst();
                queueTxt.setText(queue.toString().replace("[", "").replace("]", ""));
            }
            case "Push" -> {
                stack.addFirst(Integer.valueOf(enterPushNumber.getText()));
                stackTxt.setText(stack.toString().replace("[", "").replace("]", ""));
            }
            case "Pop" -> {
                stack.removeFirst();
                stackTxt.setText(stack.toString().replace("[", "").replace("]", ""));
            }
        }
    }
}
