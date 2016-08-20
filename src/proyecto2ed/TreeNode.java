/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ed;

public class TreeNode {

    private TreeNode father, leftSon, rightBrother;
    private String data;
    private int tabs;

    TreeNode(String data, int tabs) {
        this.data = data;
        father = leftSon = rightBrother = null;
        this.tabs = tabs;
    }

    public TreeNode getFather() {
        return father;
    }

    public void setFather(TreeNode father) {
        this.father = father;
    }

    public TreeNode getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(TreeNode leftSon) {
        this.leftSon = leftSon;
        leftSon.setFather(this);
    }

    public TreeNode getRightBrother() {
        return rightBrother;
    }

    public void setRightBrother(TreeNode rightBrother) {
        this.rightBrother = rightBrother;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public int getTabs() {
        return this.tabs;
    }

    public void setTabs(int tabs) {
        this.tabs = tabs;
    }
}
