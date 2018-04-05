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
public class Node {
    private char Data;
    private Node Next;
    
    public Node(char Data,Node Next){
        this.Data=Data;
        this.Next=Next;
    }
    
    public char GetData(){
        return Data;
    }
    
    public Node GetNext(){
        return Next;
    }
}
