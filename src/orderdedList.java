/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nate
 */
public class orderdedList {

    private IntNode head;
    private int numItems;

    private orderdedList() {
        numItems = 0;
        head = null;
    }

    /**
     * *
     * Add a number that you want to put in the list
     *
     * @param num
     */
    public void add(int num) {
        //create the number to add
        IntNode temp = new IntNode(num);
        //starts at the begining of the list
        //adds the first item in the list
        if (head == null) {
            head = temp;
        } else {
            //if the number is smaller than head
            if (num < head.getNum()) {
                IntNode p = head;
                head = temp;
                head.setNext(p);

            } else {

                IntNode node = head;
                //if head is the only thing in the list
                if (head.getNext() == null) {
                    head.setNext(temp);
                } else {
                    //moves through the list until it finds something larger than num
                    while (node.getNext().getNum() < num) {
                        node = node.getNext();
                        if (node.getNext() == null) {
                            break;
                        }
                    }
                    //saves what comes after where we want to insert it
                    IntNode p = node.getNext();
                    //sets it to be the number to everything after and set the number that we are on to point to the new number
                    temp.setNext(p);
                    node.setNext(temp);
                }
            }

        }

        numItems++;
    }

    /**
     * *
     * Removes the first of the specified number
     *
     * @param num
     */
    public void remove(int num) {
        if (numItems == 0) {
            return;
        }
        IntNode node = head;
        //move to spot just before
        if (head.getNum() == num) {
            head = head.getNext();

        } else {
            while (node.getNext().getNum() != num) {
                if (node.getNext().getNext() == null) {
                    return;
                }
                node = node.getNext();
            }
            node.setNext(node.getNext().getNext());
        }
        numItems--;

    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int index) {
        IntNode node = head;
        //move the num of times
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getNum();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        orderdedList o = new orderdedList();

        for (int i = 0; i < 10; i++) {
            int test = (int) (Math.random() * 1000);
            o.add(test);
           // o.remove(test);
            // System.out.println(test);
        }
        o.add(784);
        o.add(784);

        o.remove(784);
        o.remove(784);
        o.remove(784);

        for (int i = 0; i < o.size(); i++) {
            System.out.println(o.get(i) );
        }
        

    }

}
