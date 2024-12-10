package dataStructure.BinaryTree;

import java.util.Stack;

// A Pair class

public class TwoIdenticalTree {
    static class Pair<U, V> {
        public final U first;       // first field of a pair
        public final V second;      // second field of a pair

        // Constructs a new Pair with specified values
        private Pair(U first, V second)
        {
            this.first = first;
            this.second = second;
        }

        // Factory method for creating a Typed Pair immutable instance
        public static <U, V> Pair <U, V> of(U a, V b)
        {
            // calls private constructor
            return new Pair<>(a, b);
        }
    }
    public static void main(String[] args) {
        Tree tree1 = new Tree();
        int i = 0 ;
        while(i++ < 10)
            tree1.insertIntoTree(i);

        Tree tree2 = new Tree();
        int j = 0 ;
        while(j++ < 10)
            tree2.insertIntoTree(j);


        boolean identical = checkTreeIdenticalRecursive(tree1.treeNodeRoot , tree2.treeNodeRoot);
        System.out.println(identical);

        boolean identicalNonRecursive = checkTreeIdentical(tree1.treeNodeRoot , tree2.treeNodeRoot);
        System.out.println(identicalNonRecursive);
    }

    private static boolean checkTreeIdentical(TreeNode tree1, TreeNode tree2) {
        if(tree1==null && tree2 == null) return true;
        if(tree1 == null) return false;
        if(tree2 == null) return false;

        Stack<Pair<TreeNode,TreeNode>> stack = new Stack<Pair<TreeNode,TreeNode>>();
        stack.add(Pair.of(tree1,tree2));

        while(!stack.isEmpty()){
            TreeNode tmp1 = stack.peek().first ;
            TreeNode tmp2 = stack.peek().second ;

            stack.pop();

            if(tmp1.data != tmp2.data)
                return false;

            if(tmp1.left!=null && tmp2.left!=null)
                stack.push(Pair.of(tmp1.left,tmp2.left));
            else if (tmp1.left != null || tmp2.left != null)
                return false;

            if(tmp1.right!=null && tmp2.right!=null)
                stack.push(Pair.of(tmp1.right,tmp2.right));
            else if (tmp1.right != null || tmp2.right != null)
                return false;

        }
        return true;
    }

    private static boolean checkTreeIdenticalRecursive(TreeNode treeNodeRoot1, TreeNode treeNodeRoot2) {
        if(treeNodeRoot1==null && treeNodeRoot2==null) return true;

        return  (treeNodeRoot1!=null && treeNodeRoot2!=null) &&
                (treeNodeRoot1.data==treeNodeRoot2.data) &&
                checkTreeIdenticalRecursive(treeNodeRoot1.left , treeNodeRoot2.left) &&
                checkTreeIdenticalRecursive(treeNodeRoot1.right , treeNodeRoot2.right);
    }


}
