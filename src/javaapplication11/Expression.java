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
public class Expression {

    private String Exp;
    private String PostfixExp;
    private String PrefixExp;

    Expression(){}
    Expression(String Exp){
        this.Exp=Exp;
    }

    private boolean ParanthesesChecker() {
        Stack Parantheses = new Stack();
        char ch;
        for (int i = 0; i < Exp.length(); i++) {
            ch = Exp.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                Parantheses.Push(ch);
            }
            if (ch == ')') {
                if (Parantheses.Pop() != '(') {
                    System.out.println("Error in Parantheses");
                    return false;
                }
            }
        }
        if (Parantheses.Empty()) {
            return true;
        } else {
            System.out.println("Error in Parantheses");
            return false;
        }
    }

    public void ConvertInfixToPostfix() {
        char sym;
        int PstPosition=0;
        Stack OperatorStack=new Stack();
        char[] Pst = new char[Exp.length()*2];
        for (int i = 0; i < Exp.length(); i++) {
            sym = Exp.charAt(i);
            if (IsOperand(sym)) {
                Pst[PstPosition++] = sym;
            } else {
                Pst[PstPosition++]=',';
                while(!OperatorStack.Empty() && PostfixPrecedence(OperatorStack.TopOfStack(),sym)){
                    Pst[PstPosition++]=OperatorStack.Pop();
                }
                if(OperatorStack.TopOfStack()=='('&&sym==')') OperatorStack.Pop();
                else OperatorStack.Push(sym);
            }
        }
        Pst[PstPosition++]=',';
        while(!OperatorStack.Empty()) Pst[PstPosition++]=OperatorStack.Pop();
        PostfixExp=new String(Pst);
    }

    private boolean IsOperand(char sym) {
        if ((sym >= '0' && sym <= '9') || sym=='.') {
            return true;
        }
        return false;
    }
    
    private boolean PostfixPrecedence(char op1,char op2){
        if((op1=='+'||op1=='-')&&(op2=='+'||op2=='-'))return true;
        if((op1=='*'||op1=='/')&&(op2=='+'||op2=='-'))return true;
        if((op1=='*'||op1=='/')&&(op2=='*'||op2=='/'))return true;
        
        if(op1=='(') return false;
        if(op2==')') return true;
        return false;
    }
    
    public String GetPostfixExpression(){
        return PostfixExp;
    }
    
    public void ConvertInfixToPrefix(){
        char sym;
        Stack OperatorStack=new Stack();
        char Pre[]=new char[Exp.length()];
        int PrePosition=Exp.length()-1;
        for(int i=Exp.length()-1;i>=0;i--){
            sym=Exp.charAt(i);
            if(IsOperand(sym)) Pre[PrePosition--]=sym;
            else{
                while(!OperatorStack.Empty() && PrefixPrecedence(OperatorStack.TopOfStack(),sym)){
                    Pre[PrePosition--]=OperatorStack.Pop();
                }
                if(OperatorStack.TopOfStack()==')'&& sym=='(') OperatorStack.Pop();
                else OperatorStack.Push(sym);
            }
        }
        while(!OperatorStack.Empty()) Pre[PrePosition--]=OperatorStack.Pop();
        PrefixExp=new String(Pre);
    }
    
    public String GetPrefixExpression(){
        return PrefixExp;
    }
    
    private boolean PrefixPrecedence(char op1,char op2){
        if((op1=='*' || op1=='/')&& (op2=='+'||op2=='-')) return true;
        if(op1==')'||op2==')') return false;
        if(op2=='(') return true;
        return false;
    }
}
