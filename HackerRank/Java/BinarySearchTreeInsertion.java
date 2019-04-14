import java.util.Scanner;

class BinarySearchTreeInsertion {

    public static void preOrder(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

    public static Node insert(Node root, int data) {
        Node insertion = new Node(data);
        if (root == null) {
            return insertion;
        } else {
            Node current = root;
            while (true) {
                if (data > current.data && current.right != null) {
                    current = current.right;
                } else if (data < current.data && current.left != null) {
                    current = current.left;
                } else {
                    break;
                }
            }
            if (data > current.data) {
                current.right = insertion;
            } else if (data < current.data) {
                current.left = insertion;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}