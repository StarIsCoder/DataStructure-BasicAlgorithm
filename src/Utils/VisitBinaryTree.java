package Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class VisitBinaryTree {
    public static void visitWithStackPreorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            System.out.println(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }

        }
    }

    public static void visitWithStackInorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tmp = stack.pop();
        while (!stack.empty() || tmp != null) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            System.out.println(tmp.val);
            tmp = tmp.right;
        }
    }

    public static void visitTreeWithStackPostorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode tmp = stack.peek().right;
                if (tmp == null) {
                    tmp = stack.pop();
                    System.out.println(tmp.val);
                    while (!stack.empty() && tmp == stack.peek().right) {
                        tmp = stack.pop();
                        System.out.println(tmp.val);
                    }
                } else {
                    cur = tmp;
                }
            }
        }
    }


    public static void visitWithRecursionPreorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        visitWithRecursionPreorder(root.left);
        visitWithRecursionPreorder(root.right);
    }

    public static void visitWithRecursionInorder(TreeNode root) {
        if (root == null) return;
        visitWithRecursionInorder(root.left);
        System.out.println(root.val);
        visitWithRecursionInorder(root.right);
    }

    public static void visitWithRecursionPostorder(TreeNode root) {
        if (root == null) return;
        visitWithRecursionPostorder(root.left);
        visitWithRecursionPostorder(root.right);
        System.out.println(root.val);
    }

    public static void morrisPreorderTraverse(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == cur) {
                    pre.right = null;
                    cur = cur.right;
                } else {
                    pre.right = cur;
                    System.out.println(cur.val);
                    cur = cur.left;
                }
            }
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode tmp = stack.peek().right;
                if (tmp == null) {
                    tmp = stack.pop();
                    list.add(tmp.val);
                    while (!stack.empty() && tmp == stack.peek().right) {
                        tmp = stack.pop();
                        list.add(tmp.val);
                    }
                } else {
                    cur = tmp;
                }
            }
        }
        return list;
    }
}
