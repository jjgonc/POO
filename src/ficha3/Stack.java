package ficha3;

//aula 17-03-2021

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<String> stack;

    public Stack (){
        this.stack = new ArrayList<>();
    }

    public Stack (List<String> s) {
        setStack(s);
    }

    public Stack (Stack obj) {
        this.stack = obj.getStack();
        // ou entao (mas era menos eficiente pq ia fazer um clone a mais):
        // setStack(obj.Stack());
    }

    public List<String> getStack() {
        List<String> res = new ArrayList<>(stack.size());
        for (String s: this.stack) {
            res.add(s);
        }
        return res;
    }

    public void setStack (List<String> stk) {
        this.stack = new ArrayList<>();
        for (String s: stk) {
            this.stack.add(s);
        }
        /*
        for (i=0; i<stk.size(); i++) {
            String s = stk.get(i);
            this.stack.add(s);
        }
         */
    }

    public void pushString (String s) {
        this.stack.add(0,s);
    }

    public String top() {
        if (!empty()) {
            return this.stack.get(0);
        }
        return null;
    }

    public void pop () {
        if (!empty()) {
            this.stack.remove(0);
        }
    }

    public boolean empty () {
        return this.stack.isEmpty();
    }

    public int length () {
        return this.stack.size();
    }

    public Stack clone() {
        return new Stack(this);
    }

    public boolean equals (Object o) {
        if (o == this) return true;
        if (o==null || o.getClass() != this.getClass()) return false;
        Stack obj = (Stack) o;
        return this.stack.equals((obj.getStack()));
    }
}
