import java.util.Scanner;

class HeightOfABinaryTree {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        //recursively call height with the next node and add one for each
        // increased depth. compare with max
        int max = 0;
        int depth = 0;
        if (root.left != null) {
            depth = height(root.left) + 1;
            if (depth > max) {
                max = depth;
            }
        }
        if (root.right != null) {
            depth = height(root.right) + 1;
            if (depth > max) {
                max = depth;
            }
        }
        return max;

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}