/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nate
 */
public class resizeableArray {
//store all intergers

    private int[] stack;
    //keep track of items
    private int numItems;

    public resizeableArray() {
        stack = new int[10];

        numItems = 0;
    }

    public void add(int index, int num) {

        //check if there is space in the array if there is then put the number in the array
        if (index > stack.length - 1) {

            //make more room
            int[] temp = new int[stack.length * 2];
            //copy items over
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
            //additems
            stack[numItems] = num;

            numItems++;

        } else {
            //for adding a number on a spot that has a number in it
            //move the rest of the array over then place the number in that spot
            if (stack[index] > 0) {
                for (int pos = numItems - 1; pos >= index; pos--) {
                    stack[pos + 1] = stack[pos];
                }
                stack[index] = num;

            } else {
                //blank space prevention checking if you are trying to add somthing past the end of the list
                //if it is at the end then put the item at that index in the array
                if (index > numItems) {
                    stack[numItems] = num;
                } else {
                    stack[index] = num;

                }
            }
            numItems++;
        }
    }

    public void remove(int index) {
        //check if there is an item at the index  if there is remove that item 
        if (index > numItems) {
            return;
        } else {
            for (int i = index; i < numItems; i++) {
                stack[i] = stack[i + 1];
            }
        }
        numItems--;
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void get(int index) {
        System.out.println(stack[index]);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        resizeableArray p = new resizeableArray();

        for (int i = 0; i < 100; i++) {
            p.add((int) (Math.random() * 100), (int) (Math.random() * 100));
        }

        p.add(5, 177);

        for (int i = 0; i < p.size(); i++) {
            p.get(i);
        }
    }

}
