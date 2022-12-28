package com.kartik.org;

import javax.swing.*;

import com.kartik.org.TreeNode;

import java.awt.*;
import java.awt.event.*;


/*
 * A Viewer for Binary Trees.
 */
public class BinaryTreeView extends JPanel {

	private static final long serialVersionUID = 1L;

	/* The tree currently being display */
    public TreeNode tree;

    /* The max. height of any tree drawn so far.  This
       is used to avoid the tree jumping around when nodes
       are removed from the tree. */
    public int maxHeight;

    /* The font for the tree nodes. */
    protected Font font = new Font("Roman", 0, 14);
    
    public BinaryTreeView(){}
    
    /* 
     * Create a new window with the given width and height 
     * that is showing the given tree.
     */
    public BinaryTreeView(TreeNode tree, int width, int height) {

        //Initialize drawing colors, border, opacity.
        setBackground(Color.white);
        setForeground(Color.black);

        // Create window and make it so hitting the close icon
        // will terminate the program
        JFrame f = new JFrame("BinaryTree View");
        f.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        
        f.getContentPane().add(this, BorderLayout.CENTER);
        f.setSize(new Dimension(width, height));
        f.setVisible(true);
        
        // install initial tree.
        setTree(tree);
    }


	/*
     * Set the display to show the given tree.
     */ 
    public void setTree(TreeNode t) {
        tree = t;
        //maxHeight = tree.height();
        maxHeight = 4;
    }

    /*
     * Invoke this method whenever you would like the window
     * to be refreshed, such as after updating the tree in some
     * way.
     */
    public void refresh() {
        paintImmediately(0,0, getWidth(), getHeight());
    }


    /*
     * Draw the contents of the tree into the given Graphics
     * context.
     * It will place all info between minX and maxX in the x-direction,
     * starting at location y in the y-direction.  Levels of the tree
     * will be separated by yStep pixels.
     */
    protected void drawTree(Graphics g, int minX, int maxX, 
                            int y, int yStep, TreeNode tree) {

        String s = String.valueOf(tree.data);
        
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth(s);
        int height = fm.getHeight();

        int xSep = Math.min((maxX - minX)/8, 10);

        g.drawString(s, (minX + maxX)/2 - width/2, y + yStep/2);

        if (tree.left!=null) {
            // if left tree not empty, draw line to it and recursively
            // draw that tree
            g.drawLine((minX + maxX)/2 - xSep, y + yStep/2 + 5,
                       (minX + (minX + maxX)/2) / 2, 
                       y + yStep + yStep/2 - height);
            drawTree(g, minX, (minX + maxX)/2, y + yStep, yStep, tree.left);
        }
        if (tree.right!=null) {
            // same thing for right subtree.
            g.drawLine((minX + maxX)/2 + xSep, y + yStep/2 + 5,
                       (maxX + (minX + maxX)/2) / 2, 
                       y + yStep + yStep/2 - height);
            drawTree(g, (minX + maxX)/2, maxX, y + yStep, yStep, tree.right);
        }
    }


    /*
     * paint method unherited from the Swing library.  Just
     * calls drawTree whenever the window needs to be repainted.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);      
        //clears the background
        int width = getWidth();
        int height = getHeight();
       // maxHeight = Math.max(tree.height, maxHeight);
        maxHeight = Math.max(4, maxHeight);
        int treeHeight = maxHeight;

        drawTree(g, 0, width, 0, height / (treeHeight + 1), tree);

    } 
    
    public void method(TreeNode tree){
    	 BinaryTreeView btv = new BinaryTreeView(tree, 400, 400);
         btv.refresh();
    }
    
    /* 
     * Test code.
     */
    public static void main(String s[]) {
        TreeNode tree2 = createBinaryTree();
        BinaryTreeView btv = new BinaryTreeView(tree2, 400, 400);
        btv.refresh();
    }
    
   /* public static class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data)
		{
			this.data=data;
		}
	}*/
    
    public static TreeNode createBinaryTree()
	{
 
		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		TreeNode node55 = new TreeNode(55);
		TreeNode node5 = new TreeNode(5);
		rootNode.left=node20;
		rootNode.right=node60;
 
		node20.left=node10;
		node20.right=node30;
 
		node60.left=node50;
		node60.right=node70;
		node50.right=node55;
		node10.left=node5;
		return rootNode;
	}
}