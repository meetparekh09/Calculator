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
public class NodeDouble {
    private double Data;
    private NodeDouble Next;
    
    public NodeDouble(double Data,NodeDouble Next){
        this.Data=Data;
        this.Next=Next;
    }
    
    public double GetData(){
        return Data;
    }
    
    public NodeDouble GetNext(){
        return Next;
    }
}
