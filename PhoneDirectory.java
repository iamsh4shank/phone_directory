package phone_directory;

import phone_directory.BSTNode;
import phone_directory.BST;
import phone_directory.DirectoryModel;

class PhoneDirectory {
    public static void main(String[] args) {
        BST bst = new BST();
        BSTNode bstNode = new BSTNode();
        DirectoryModel directoryModel = new DirectoryModel();
        
        Scanner sc = new Scanner(System.in);
        while (1>0){
            
            System.out.println("          Phone Directory");
            System.out.println("         =================");
            System.out.println("  -->Enter \"1\" to Add Details ");
            System.out.println("  -->Enter \"2\" to display all contact details");
            System.out.println("  -->Enter \"3\" to search any number ");
            System.out.println("  -->Enter \"4\" to find first number");
            System.out.println("  -->Enter \"5\" to find last number");
            System.out.println("  -->Enter \"6\" to Exit");
            System.out.println("\n");
            System.out.print("Please enter your choice: ");
            int choice = sc.nextInt();
            while ((choice != 1) && (choice != 2) && (choice != 3) && (choice !=4) && (choice !=5) && (choice !=6)) {
                System.out.println("Invalid choice!  Please select Add, display, search, find first, find last, or Exit: ");
                choice = sc.nextInt();
            }   
            if (choice  == 1) {      
                System.out.println("To add details follow the prompts.");

                System.out.print("Enter Name of contact: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Enter mobile number: ");
                String phNum = sc.nextLine();

                System.out.print("Enter email ID: ");
                String email = sc.nextLine();
                
                bstNode.insertTodb(new DirectoryModel(name, phNum, email));
                System.out.println("\nYou have successfully added a new entry!");
                System.out.println("\n");
            }

            if (choice == 2){
                bstNode.display();
                System.out.println("\n");
            }

            if (choice == 3){
                System.out.println("enter which name you want to search");
                sc.nextLine();
                String nameToSearch = sc.nextLine();
                bstNode.search(nameToSearch);
                System.out.println("\n");
            }
            
            if (choice == 4) {
                BSTNode bstNode2 = bstNode.returnBST();
                bstNode.minInBST(bstNode2);   
                System.out.println("\n");
            }

            if (choice == 5) {
                BSTNode bstNode2 = bstNode.returnBST();
                bstNode.maxInBST(bstNode2);
                System.out.println("\n");
            }
            if (choice ==6) {
                System.exit(0);
            }
        }
}
}
