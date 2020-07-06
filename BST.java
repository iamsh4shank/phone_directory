package phone_directory;

import phone_directory.BSTNode;
import phone_directory.DirectoryModel;
import phone_directory.PhoneDirectory;

class BST {
    BSTNode root;
    public void insert(DirectoryModel directoryModel) {
        if (root == null) root = new BSTNode(directoryModel);
        else root.insert(directoryModel);
    }

    public void inorder() {
        if (root == null) return;
        else root.inorder();
    }

    public void display() {
        if (root == null) return;
        else root.display();
    }

    public void search(String name) {
        if (root == null) return;
        else root.search(name);
    }

}
