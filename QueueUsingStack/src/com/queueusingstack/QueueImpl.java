package com.queueusingstack;

import java.util.Stack;

public class QueueImpl {
	
	Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    public void enQueue(int x) {
    	
    	while(!s1.isEmpty()) {
    		s2.push(s1.pop());
    	}
    	
    	s1.push(x);
    	
    	while(!s2.isEmpty()) {
    		s1.push(s2.pop());
    	}
    	
    	
    }
    
    public void deQueue()
    {
    	if (s1.isEmpty())
        {
            System.out.println("Q is Empty");
            System.exit(0);
        }
    	
    	int popedElement = s1.peek();
    	s1.pop();
    	System.out.println(popedElement);
    	
    }

	public static void main(String[] args) {
		
		QueueImpl q = new QueueImpl();
		q.enQueue(2);
		q.enQueue(4);
		q.enQueue(6);
		
		q.deQueue();
		q.deQueue();
		q.deQueue();
		

	}

}
