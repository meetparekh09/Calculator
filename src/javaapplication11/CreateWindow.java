/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication11;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Meet Parekh
 */
public class CreateWindow {
    protected Dimension FrameSize = new Dimension(350, 250);
    protected Dimension ButtonSize = new Dimension(50, 50);
    protected JButton[] b = new JButton[10];
    protected JButton bEquals = new JButton("=");
    protected JButton bMultiply = new JButton("X");
    protected JButton bDivide = new JButton("/");
    protected JButton bPlus = new JButton("+");
    protected JButton bMinus = new JButton("-");
    protected JTextField Equation = new JTextField(400);
    protected JButton bClear=new JButton("C");
    protected JButton bParanthesesOpen=new JButton("(");
    protected JButton bParanthesesClose=new JButton(")");
    protected JButton bDecimal=new JButton(".");
    protected JFrame f1 = new JFrame("Calculator");
    protected JButton bBackspace=new JButton("<X");
    
    void CreateWindow(){
        ListenerButton L1=new ListenerButton(this);
        for (int i = 0; i < 10; i++) {
            b[i] = new JButton(Integer.toString(i));
            b[i].setSize(ButtonSize);
            b[i].addActionListener(L1);
        }
        bEquals.addActionListener(L1);
        bMultiply.addActionListener(L1);
        bDivide.addActionListener(L1);
        bPlus.addActionListener(L1);
        bMinus.addActionListener(L1);
        bClear.addActionListener(L1);
        bParanthesesOpen.addActionListener(L1);
        bParanthesesClose.addActionListener(L1);
        bDecimal.addActionListener(L1);
        bBackspace.addActionListener(L1);
        JPanel p1 = new JPanel();
        f1.setSize(FrameSize);
        bEquals.setSize(ButtonSize);
        bMultiply.setSize(ButtonSize);
        bDivide.setSize(ButtonSize);
        bClear.setSize(ButtonSize);
        bParanthesesOpen.setSize(ButtonSize);
        bParanthesesClose.setSize(ButtonSize);
        bDecimal.setSize(ButtonSize);
        for (int i = 1; i <= 3; i++) {
            p1.add(b[i]);
        }
        p1.add(bPlus);
        for (int i = 4; i <= 6; i++) {
            p1.add(b[i]);
        }
        p1.add(bMinus);
        for (int i = 7; i <= 9; i++) {
            p1.add(b[i]);
        }
        p1.add(bDivide);
        p1.add(bMultiply);
        p1.add(b[0]);
        p1.add(bEquals);
        p1.add(bClear);
        p1.add(bParanthesesOpen);
        p1.add(bParanthesesClose);
        p1.add(bDecimal);
        p1.add(bBackspace);
        Equation.setEditable(false);
        f1.add(Equation, BorderLayout.NORTH);
        f1.add(p1);
        f1.setVisible(true);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
