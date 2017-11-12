/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nate
 */
public class IntNode {
     private int item;
    private IntNode next;
    
    public IntNode(int num){
        item = num;
        next = null;
    }
    
   
    public int getNum(){
        return item;
    }
    
    public IntNode getNext(){
        return next;
    }
    
    public void setNext(IntNode node){
      next = node;
    }
   
}
