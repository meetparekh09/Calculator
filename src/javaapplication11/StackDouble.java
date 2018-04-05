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
public class StackDouble {
    private NodeDouble Head;
    
    public void Push(double Data){
        Head=new NodeDouble(Data,Head);
    }
    
    public double Pop(){
        if(Head==null)return '\0';
        double Data=Head.GetData();
        Head=Head.GetNext();
        return Data;
    }
    
    public boolean Empty(){
        if(Head==null)return true;
        else return false;
    }
    
    public double TopOfStack(){
        double Data=Pop();
        Push(Data);
        return Data;
    }
}
