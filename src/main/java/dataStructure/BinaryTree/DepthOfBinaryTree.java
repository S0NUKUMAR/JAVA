package dataStructure.BinaryTree;

import java.util.Random;

public class DepthOfBinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int i = 0;
        Random rand = new Random();
        while(i++ < 10)
            tree.insertIntoBinaryTree(tree.treeNodeRoot ,rand.nextInt(10));

        tree.printBinaryTree();

        int depth = findDepthOfBinaryTree(tree.treeNodeRoot);
        System.out.println(depth);
    }

    private static int findDepthOfBinaryTree(TreeNode treeNodeRoot) {
        if(treeNodeRoot == null)
            return 0;

        int left = findDepthOfBinaryTree(treeNodeRoot.left) ;
        int right = findDepthOfBinaryTree(treeNodeRoot.right);

        return Math.max(left,right) + 1;
    }
}
