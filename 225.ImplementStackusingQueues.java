class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> que;
    Queue<Integer> temp;
    
    public MyStack() {
        que = new LinkedList<>();
        temp = new LinkedList<>();    
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(que.size() == 0){
            que.add(x);
        } else {
            temp.add(x);
            while(que.size() != 0){
                temp.add(que.remove());
            }
            
            while(temp.size() != 0){
               que.add(temp.remove());
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(que.size() != 0){
            return que.remove();    
        } else {
            return -1;
        }        
    }
    
    /** Get the top element. */
    public int top() {
        if(que.size() != 0){
            return que.peek();
        } else {
            return -1;
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */