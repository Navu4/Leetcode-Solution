class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> st; // Main stack
    Stack<Integer> temp; // Temp stack

    public MinStack() {
        st = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int val) {
        st.push(val);

        if (temp.size() == 0 || val <= temp.peek()) {
            temp.push(val);
        }
    }

    public void pop() {
        if (st.size() != 0) {
            int data = st.pop();

            if (data == temp.peek()) {
                temp.pop();
            }
        }
    }

    public int top() {
        if (st.size() != 0) {
            return st.peek();
        } else {
            return -1;
        }
    }

    public int getMin() {
        if (temp.size() != 0) {
            return temp.peek();
        } else {
            return -1;
        }
    }
}