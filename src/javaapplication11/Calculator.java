/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

/**
 *
 * @author Meet Parekh
 */
public class Calculator {

    private Expression Exp = new Expression();

    Calculator(){}
    Calculator(String exp) throws Exception {
        Exp=new Expression(exp);
        Exp.ConvertInfixToPostfix();
    }

    @SuppressWarnings("empty-statement")
    public double Calculate() {
        System.out.println(Exp.GetPostfixExpression());
        StackDouble OperandStack = new StackDouble();
        String Pst = Exp.GetPostfixExpression();
        String Temp;
        for (int i = 0; i < Pst.length(); i++) {
            if (Pst.charAt(i) == ','); else {
                if (IsOperand(Pst.charAt(i))) {
                    int j = i;
                    for (; Pst.charAt(j) != ','; j++);
                    char[] temp = new char[j - i];
                    int count = 0;
                    while (i != j) {
                        temp[count++] = Pst.charAt(i++);
                    }
                    Temp=new String(temp);
                    OperandStack.Push(ConvertDouble(Temp));
                } else {
                    OperandStack.Push(PerformOperation(OperandStack.Pop(), OperandStack.Pop(), Pst.charAt(i)));
                }
            }
        }
        return OperandStack.Pop();
    }

    private double PerformOperation(double op2, double op1, char sym) {
        switch (sym) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            default:
                return op2;
        }
    }

    private boolean IsOperand(char sym) {
        if (sym >= '0' && sym <= '9') {
            return true;
        }
        return false;
    }

    private double ConvertDouble(String s1) {
        return Double.parseDouble(s1);
    }
}
