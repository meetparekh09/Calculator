/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication11;
import java.awt.event.*;

/**
 *
 * @author Meet Parekh
 */
public class ListenerButton extends CreateWindow implements ActionListener  {
    String Expression = new String();
    Calculator calculator=new Calculator();

    ListenerButton(CreateWindow cw1) {   
        FrameSize=cw1.FrameSize;
        ButtonSize=cw1.ButtonSize;
        b=cw1.b;
        bEquals=cw1.bEquals;
        bMultiply=cw1.bMultiply;
        bDivide=cw1.bDivide;
        bPlus=cw1.bPlus;
        bMinus=cw1.bMinus;
        Equation=cw1.Equation;
        bClear=cw1.bClear;
        bParanthesesOpen=cw1.bParanthesesOpen;
        bParanthesesClose=cw1.bParanthesesClose;
        bDecimal=cw1.bDecimal;
        bBackspace=cw1.bBackspace;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(b[i]==e.getSource()){
                Expression=Expression.concat(Integer.toString(i));
                Equation.setText(Expression);
            }
        }
        if(bMultiply==e.getSource()){
            Expression=Expression.concat("*");
            Equation.setText(Expression);
        }
        if(bDivide==e.getSource()){
            Expression=Expression.concat("/");
            Equation.setText(Expression);
        }
        if(bPlus==e.getSource()){
            Expression=Expression.concat("+");
            Equation.setText(Expression);
        }
        if(bMinus==e.getSource()){
            Expression=Expression.concat("-");
            Equation.setText(Expression);
        }
        if(bEquals==e.getSource()){
            System.out.println("Expression is "+Expression);
            try {
                calculator=new Calculator(Expression);
            } catch (Exception ex) {
                System.out.println("Expression is null");
            }
            Expression=new String(Double.toString(calculator.Calculate()));
            Equation.setText(Expression);
        }
        if(bClear==e.getSource()){
            Expression=new String();
            Equation.setText(Expression);
        }
        if(bParanthesesClose==e.getSource()){
            Expression=Expression.concat(")");
            Equation.setText(Expression);
        }
        if(bParanthesesOpen==e.getSource()){
            Expression=Expression.concat("(");
            Equation.setText(Expression);
        }
        if(bDecimal==e.getSource()){
            Expression=Expression.concat(".");
            Equation.setText(Expression);
        }
        if(bBackspace==e.getSource()){
            char []Temp=new char[Expression.length()-1];
            for(int i=0;i<Temp.length;i++){
                Temp[i]=Expression.charAt(i);
            }
            Expression=new String(Temp);
            Equation.setText(Expression);
        }
    }
    
}
