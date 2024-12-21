package dataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree{
    TreeNode treeNodeRoot ;

    public void insertIntoTree(int data){
        if(treeNodeRoot == null) {
            treeNodeRoot = new TreeNode(data);
            return;
        }


        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNodeRoot);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();

            if (top.left == null) {
                top.left = new TreeNode(data);
                break;
            } else {
                queue.add(top.left);
            }

            if (top.right == null) {
                top.right = new TreeNode(data);
                break;
            } else {
                queue.add(top.right);
            }
        }
    }

    public void printBinaryTree(){

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNodeRoot);

        while(!queue.isEmpty()){
            TreeNode top =  queue.poll();
            System.out.print(top.data + " ");
            if(top.left !=null){
                queue.add(top.left);
            }
            if(top.right !=null){
                queue.add(top.right);
            }

        }
        System.out.println();
    }

    public TreeNode insertIntoBinaryTree(TreeNode treeNodeRoot ,int data){
        if(treeNodeRoot == null) {
            treeNodeRoot = new TreeNode(data);
            return this.treeNodeRoot = treeNodeRoot;
        }

        if(treeNodeRoot.data < data){
            treeNodeRoot.right = insertIntoBinaryTree(treeNodeRoot.right , data);
        }else{
            treeNodeRoot.left = insertIntoBinaryTree(treeNodeRoot.left , data);
        }

        return this.treeNodeRoot = treeNodeRoot;
    }

}
