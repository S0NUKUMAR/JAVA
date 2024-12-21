package dataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ViewTree {
    static int leftLevel = 0;
    static int rightLevel = 0;
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 10);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 2);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 3);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 7);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 8);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 15);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 12);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 14);


        printLeftView(tree.treeNodeRoot , 1);
        System.out.println();
        printLeftViewIterative(tree.treeNodeRoot);

        System.out.println();
        printRightView(tree.treeNodeRoot,1);


    }

    private static void printRightView(TreeNode treeNodeRoot, int level) {
        if(treeNodeRoot == null)
            return;

        if(ViewTree.rightLevel < level) {
            System.out.print(treeNodeRoot.data + " ");
            ViewTree.rightLevel = level;
        }

        printRightView(treeNodeRoot.right, level+1);
        printRightView(treeNodeRoot.left , level+1);
    }

    private static void printLeftViewIterative(TreeNode treeNodeRoot) {
        if(treeNodeRoot == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNodeRoot);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();

            for(int i = 1 ; i<=n;i++){
                TreeNode temp = queue.poll();

                // Print the left most element at
                // the level
                if (i == 1)
                    System.out.print((temp != null ? temp.data : 0) + " ");

                // Add left node to queue
                if ((temp != null ? temp.left : null) != null)
                    queue.add(temp.left);

                // Add right node to queue
                if ((temp != null ? temp.right : null) != null)
                    queue.add(temp.right);
            }
        }
    }

    private static void printLeftView(TreeNode treeNodeRoot, int level) {
        if(treeNodeRoot == null){
            return;
        }

        if(ViewTree.leftLevel < level){
            System.out.print(treeNodeRoot.data + " ");
            ViewTree.leftLevel = level;
        }


        printLeftView(treeNodeRoot.left ,level+1);
        printLeftView(treeNodeRoot.right ,level+1);

    }
}
