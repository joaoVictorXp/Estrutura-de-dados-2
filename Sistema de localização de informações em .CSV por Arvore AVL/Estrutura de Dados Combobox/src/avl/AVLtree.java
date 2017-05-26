package avl;

import java.util.ArrayList;

import dados.Dados;

public class AVLtree {
 
    private Node root;
 
    public class Node {
        private String key;
        private int balance;
        private int height;
        private Node left, right, parent;
        private Dados dados;
        
        Node(String k, Node p, Dados d) {
            key = k;
            parent = p;
            dados = d;
        }

		public Dados getDados() {
			return dados;
		}
    }
 
    public boolean insert(String key, Dados d) {
        if (root == null)
            root = new Node(key, null, d);
        else {
            Node n = root;
            Node parent;
            while (true) {
//                if (n.key == key)
//                    return false;
 
                parent = n;
 
                int goLeft = n.key.compareToIgnoreCase(key);
                n = goLeft <= 0 ? n.left : n.right;
 
                if (n == null) {
                    if (goLeft <= 0) {
                        parent.left = new Node(key, parent, d);
                    } else {
                        parent.right = new Node(key, parent, d);
                    }
                    rebalance(parent);
                    break;
                }
            }
        }
        return true;
    }
 
//    private void delete(Node node){
//        if(node.left == null && node.right == null){
//            if(node.parent == null) root = null;
//            else{
//                Node parent = node.parent;
//                if(parent.left == node){
//                    parent.left = null;
//                }else parent.right = null;
//                rebalance(parent);
//            }
//            return;
//        }
//        if(node.left!=null){
//            Node child = node.left;
//            while (child.right!=null) child = child.right;
//            node.key = child.key;
//            delete(child);
//        }else{
//            Node child = node.right;
//            while (child.left!=null) child = child.left;
//            node.key = child.key;
//            delete(child);
//        }
//    }
 
//    public void delete(int delKey) {
//        if (root == null)
//            return;
//        Node node = root;
//        Node child = root;
// 
//        while (child != null) {
//            node = child;
//            child = delKey >= node.key ? node.right : node.left;
//            if (delKey == node.key) {
//                delete(node);
//                return;
//            }
//        }
//    }
 
    private void rebalance(Node n) {
        setBalance(n);
 
        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right))
                n = rotateRight(n);
            else
                n = rotateLeftThenRight(n);
 
        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left))
                n = rotateLeft(n);
            else
                n = rotateRightThenLeft(n);
        }
 
        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }
 
    private Node rotateLeft(Node a) {
 
        Node b = a.right;
        b.parent = a.parent;
 
        a.right = b.left;
 
        if (a.right != null)
            a.right.parent = a;
 
        b.left = a;
        a.parent = b;
 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
 
        setBalance(a, b);
 
        return b;
    }
 
    private Node rotateRight(Node a) {
 
        Node b = a.left;
        b.parent = a.parent;
 
        a.left = b.right;
 
        if (a.left != null)
            a.left.parent = a;
 
        b.right = a;
        a.parent = b;
 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
 
        setBalance(a, b);
 
        return b;
    }
 
    private Node rotateLeftThenRight(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }
 
    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }
 
    private int height(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }
 
    private void setBalance(Node... nodes) {
        for (Node n : nodes){
            reheight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }
 
    public void printBalance() {
        printBalance(root);
    }
 
    private void printBalance(Node n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%s ", n.balance);
            printBalance(n.right);
        }
    }
 
    private void reheight(Node node){
        if(node!=null){
            node.height=1 + Math.max(height(node.left), height(node.right));
        }
    }
    
    public ArrayList<Node> inorder(String chave) {
		ArrayList<Node> ret = new ArrayList<>();
		inorder(root, ret, chave);
		return ret;
	}
	final protected void inorder(Node no, ArrayList<Node> lista, String chave) {
            if (no == null) {
                return;
            }
            
            inorder(no.left, lista, chave);
            
            if(no.key.toLowerCase().contains(chave.toLowerCase())){
              lista.add(no);
            }   
            
            inorder(no.right, lista, chave);
	}
}