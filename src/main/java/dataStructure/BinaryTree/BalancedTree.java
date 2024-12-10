package dataStructure.BinaryTree;

public class BalancedTree {
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

        boolean balanced = isBalanced(tree.treeNodeRoot);
        System.out.println(balanced);

        int balanced1 = isBalancedLinear(tree.treeNodeRoot);
        System.out.println(balanced1 > 0);

    }

    private static int isBalancedLinear(TreeNode treeNodeRoot) {
        if(treeNodeRoot == null)
            return 0;

        int leftHeight = isBalancedLinear(treeNodeRoot.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = isBalancedLinear(treeNodeRoot.right);
        if(rightHeight == -1){
            return -1;
        }

        if(Math.abs(rightHeight - leftHeight)>1)
            return  -1;
        else
            return Math.max(leftHeight,rightHeight) +1;
    }

    private static boolean isBalanced(TreeNode treeNodeRoot) {
        if(treeNodeRoot == null)
            return true;

        int leftHeight = calculateHeight(treeNodeRoot.left);
        int rightHeight = calculateHeight(treeNodeRoot.right);

        if(Math.abs(leftHeight - rightHeight)>1)
            return false;

        return isBalanced(treeNodeRoot.left) && isBalanced(treeNodeRoot.right);
    }

    private static int calculateHeight(TreeNode treeNode) {
        if(treeNode == null)
            return 0;

        return Math.max(calculateHeight(treeNode.left),calculateHeight(treeNode.right)) + 1;
    }
}
