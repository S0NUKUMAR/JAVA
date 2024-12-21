package dataStructure.BinaryTree;

import java.util.Stack;

public class Traversal {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 10);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 8);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 15);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 2);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 3);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 7);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 12);
        tree.insertIntoBinaryTree(tree.treeNodeRoot , 14);
        
        inOrderTraversal(tree.treeNodeRoot);
        preOrderTraversal(tree.treeNodeRoot);
        postOrderTraversal(tree.treeNodeRoot);
    }

    private static void postOrderTraversal(TreeNode treeNodeRoot) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(treeNodeRoot);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.add(node);

            if(node.left!=null)
                stack1.add(node.left);

            if(node.right!=null)
                stack1.add(node.right);
        }

        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data + " ");
        }
        System.out.println();
    }

    private static void inOrderTraversal(TreeNode treeNodeRoot) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = treeNodeRoot;
        while( node!=null ||  !stack.isEmpty()){
            while(node!=null) {
                    stack.add(node);
                    node = node.left;
            }
            node = stack.pop();
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();

    }

    private static void preOrderTraversal(TreeNode treeNodeRoot) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(treeNodeRoot);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.data+ " ");

            if(node.right!=null)
                stack.add(node.right);

            if(node.left!=null)
                stack.add(node.left);

        }
        System.out.println();
    }
}
