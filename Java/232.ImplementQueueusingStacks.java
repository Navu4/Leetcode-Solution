class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> st;
    Stack<Integer> temp; 
    
    public MyQueue() {
        st = new Stack<>();
        temp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(st.size() == 0){
            st.push(x);
        } else {
            while(st.size() != 0){
                temp.push(st.pop());
            }
            
            st.push(x);
            while(temp.size() != 0){
                st.push(temp.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(st.size() != 0){
                return st.pop();
        } else {
            return -1;
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if(st.size() != 0){
            return st.peek();
        } else {
            return -1;
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st.size() == 0;
    }
}