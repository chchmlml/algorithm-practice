package io.haicheng;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>Title: BinaryTree</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/7/17 11:05
 */
public class BinaryTree<T> {

    /**
     * 创建二叉树
     */
    public TreeNode<T> createNode(LinkedList<T> treeData) {
        TreeNode<T> root = null;

        T data = treeData.removeFirst();
        if (null != data) {
            root = new TreeNode<T>(data, null, null);
            root.left = createNode(treeData);
            root.right = createNode(treeData);
        }
        return root;
    }

    /**
     * 递归先序遍历
     */
    public void preOrder(TreeNode<T> root) {

        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 递归中序遍历
     */
    public void inOrder(TreeNode<T> root) {
        if (root != null) {
            preOrder(root.left);
            System.out.println(root.data);
            preOrder(root.right);
        }
    }

    /**
     * 递归后序遍历
     */
    public void backOrder(TreeNode<T> root) {
        if (root != null) {
            preOrder(root.left);
            preOrder(root.right);
            System.out.println(root.data);
        }
    }

    /**
     * 非递归先序遍历
     */
    public void preOrderNoRecu(TreeNode<T> root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || stack != null) {
            while (root != null) {
                System.out.println(root.data);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    /**
     * 非递归中序遍历
     */
    public void inOrderNoRecu(TreeNode<T> root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || stack != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }
    }

    /**
     * 非递归后序遍历
     */
    public void backOrderNoRecu(TreeNode<T> t) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Integer> s2 = new Stack<Integer>();
        Integer i = new Integer(1);
        while (t != null || !s.empty()) {
            while (t != null) {
                s.push(t);
                s2.push(new Integer(0));
                t = t.left;
            }
            while (!s.empty() && s2.peek().equals(i)) {
                s2.pop();
                System.out.print(s.pop().data);
            }

            if (!s.empty()) {
                s2.pop();
                s2.push(new Integer(1));
                t = s.peek();
                t = t.right;
            }
        }
    }
}


class TreeNode<T> {

    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}