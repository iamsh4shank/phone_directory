package phone_directory;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import phone_directory.DirectoryModel;
import phone_directory.BST;
import phone_directory.PhoneDirectory;

class BSTNode {
    String name;
    String phNum;
    String email;
    BSTNode left;
    BSTNode right;

    public BSTNode() {};

    public BSTNode(DirectoryModel dModel) {
        this.name = dModel.name;
        this.phNum = dModel.phNum;
        this.email = dModel.email;
    }

    public void insert(DirectoryModel directoryModel) {
        if (comp(directoryModel.name, this.name)) {    
            if (left == null) left = new BSTNode(directoryModel);
            else left.insert(directoryModel);
        } else if (directoryModel.name.equals(this.name)) {
            if (directoryModel.phNum != this.phNum || directoryModel.email != this.email) {
                if (Long.parseLong(directoryModel.phNum)< Long.parseLong(this.phNum)) {
                    left.insert(directoryModel);
                } else {
                    right.insert(directoryModel);
                }
            }
        } else {
            if (right == null) right = new BSTNode(directoryModel);
            else right.insert(directoryModel);
        }

    } 

    public boolean comp(String name1, String name2) {
        if (name1.length()<name2.length()) {
            for (int i = 0; i<name1.length();i++) {
                if (name1.toLowerCase().charAt(0)<name2.toLowerCase().charAt(0)) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i<name2.length();i++) {
                if (name1.toLowerCase().charAt(i)<name2.toLowerCase().charAt(i)) {
                    return true;
                } else return false;
            }
        }
        return false;
    }
    public void insertTodb(DirectoryModel directoryModel) {
        try {
            File file = new File("data.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(directoryModel.name + " " + directoryModel.phNum+ " "+ directoryModel.email+"\n");
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inorder() {
        if (left != null) left.inorder();
        System.out.print("Name: "+name+" Phone number: "+ phNum+" Email: "+email + "\n");
        if (right != null) right.inorder();
    }

    public void display() {
        BST bst = new BST();
        try {
            File f = new File("data.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            System.out.println("Saved Contacts");
            while ((readLine = b.readLine()) != null) {
                String[] arrOfStr = readLine.split(" ", 0);
                if (arrOfStr.length == 3) {
                    bst.insert( new DirectoryModel(arrOfStr[0], arrOfStr[1], arrOfStr[2]));
                }
            }
            bst.inorder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void search(String name) {
        try {
            ArrayList<DirectoryModel> directoryModels = new ArrayList<DirectoryModel>();
            File f = new File("data.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                String[] arrOfStr = readLine.split(" ", 0); 
                if (name.toLowerCase().equals(arrOfStr[0].toLowerCase())) {
                    directoryModels.add(new DirectoryModel(arrOfStr[0], arrOfStr[1], arrOfStr[2]));
                } 
            }
            if (directoryModels.isEmpty()) {
                System.out.println("No such contacts found!");
            } else {
                for (DirectoryModel a:directoryModels) {
                    System.out.print("Name: "+a.name+" Phone number: "+ a.phNum+" Email: "+a.email + "\n");
                }   
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BSTNode returnBST() {
        BST bst = new BST();
        try {
            File f = new File("data.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                String[] arrOfStr = readLine.split(" ", 0);
                if (arrOfStr.length == 3) {
                    bst.insert( new DirectoryModel(arrOfStr[0], arrOfStr[1], arrOfStr[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bst.root;
    }

    public void minInBST(BSTNode bstNode) {
        if (bstNode.left == null) {
            System.out.print("Name: "+bstNode.name+" Phone number: "+ bstNode.phNum+" Email: "+bstNode.email + "\n");
        } else {
            minInBST(bstNode.left);
        }
    }

    public void maxInBST(BSTNode bstNode) {
        if (bstNode.right == null) {
            System.out.print("Name: "+bstNode.name+" Phone number: "+ bstNode.phNum+" Email: "+bstNode.email + "\n");
        } else {
            maxInBST(bstNode.right);
        }
    }
}
