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
public class Stack {
    private Node Head;
    
    public void Push(char Data){
        Head=new Node(Data,Head);
    }
    
    public char Pop(){
        if(Head==null)return '\0';
        char Data=Head.GetData();
        Head=Head.GetNext();
        return Data;
    }
    
    public boolean Empty(){
        if(Head==null)return true;
        else return false;
    }
    
    public char TopOfStack(){
        char Data=Pop();
        Push(Data);
        return Data;
    }
}
