package proyecto2ed;

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
                        hijo=hijo.getRightBrother();
                        boolean valido = false;
                        while (!valido) {
                            if (hijo.getRightBrother() == null) {
                                valido = true;
                            } else {
                                hijo = hijo.getRightBrother();
                            }
                        }
                        hijo.setRightBrother(node);
                        hijo.setFather(tmp);
                    }else{
                        hijo.setRightBrother(node);
                        hijo.setFather(tmp);
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

    public void print(TreeNode node) {
        if(node.getFather()!=null){
            System.out.print("Antecesor : "+node.getFather().getData()+ " - ");
        }else{
            System.out.print("Raiz - ");
        }
        System.out.println(node.getData());
        TreeNode tmp = node.getLeftSon();
        while (tmp != null) {
            print(tmp);
            tmp = tmp.getRightBrother();
        }
    }
}
