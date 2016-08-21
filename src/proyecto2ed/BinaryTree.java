package proyecto2ed;

import javax.swing.JTextArea;

public class BinaryTree {

    TreeNode root;

    BinaryTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void insert(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            TreeNode tmp = PreOrder(root, node.getFather());
            if (tmp != null) {
                if (tmp.getLeftSon() == null) {
                    tmp.setLeftSon(node);
                } else {
                    TreeNode hijo = tmp.getLeftSon();
                    if (hijo.getRightBrother() != null) {
                        hijo = hijo.getRightBrother();
                        boolean valido = false;
                        while (!valido) {
                            if (hijo.getRightBrother() == null) {
                                valido = true;
                            } else {
                                hijo = hijo.getRightBrother();
                            }
                        }
                        hijo.setRightBrother(node);
                    } else {
                        hijo.setRightBrother(node);
                    }
                }
            }

        }
    }

    public TreeNode PreOrder(TreeNode root, TreeNode searched) {
        if (root == null) {
            return null;
        }
        if (root == searched) {
            return root;
        }
        TreeNode tmp = root.getLeftSon();
        while (tmp != null) {
            TreeNode temporal = PreOrder(tmp, searched);
            if (temporal != null) {
                return tmp;
            } else {
                tmp = tmp.getRightBrother();
            }
        }
        return null;
    }

    public void print(TreeNode node, JTextArea board) {
        for (int i = 0; i < node.getTabs(); i++) {
            board.append("\t");
        }
        if (node.getFather() != null) {
            board.append(node.getData()+" - ");
            board.append("Padre: " + node.getFather().getData());
        } else {
            board.append("Raiz - ");
            board.append(node.getData());
        }
        board.append("\n");
        TreeNode tmp = node.getLeftSon();
        while (tmp != null) {
            print(tmp,board);
            tmp = tmp.getRightBrother();
        }
    }

    public void inOrder() {
        int cont = 0;
        TreeNode tmp = root.getLeftSon();
        cont++;
        while ((tmp = tmp.getRightBrother()) != null) {
            cont++;
        }
        for (int i = 0; i < cont + root.getTabs(); i++) {
            System.out.print("\t");
        }
        System.out.println(root.getData());
        TreeNode principal = root;
        tmp = principal.getLeftSon();
        LinkedList Hijos = new LinkedList();
        while (tmp != null) {
            Hijos.insert(tmp, Hijos.length());
            tmp = tmp.getRightBrother();
        }
        

    }

}
