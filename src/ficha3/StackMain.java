package ficha3;
//aula 17-03-2021
public class StackMain {
    public static void main (String[] args) {
        Stack stk = new Stack();
        System.out.println("Vazia? " +stk.empty());

        for (int i=0; i<10; i++) {
            stk.pushString("String " .concat(Integer.toString(i)));
        }
        System.out.println("Vazia? " +stk.empty());
        System.out.println("Tamanho Stack: " +stk.length());
        System.out.println("Top " +stk.top());
        System.out.println("Stack : " +stk);

        Stack stk2 = stk.clone();
        System.out.println("stk == stk2? " +stk.equals(stk2));
        for (int i=0; i<5; i++) {
            stk2.pop();
        }
        System.out.println("stk == stk2? "+stk.equals(stk2));
        System.out.println("Tamanho stack1 " +stk.length());
        System.out.println("Top 2 " +stk2.top());
        System.out.println("Stack: "+stk);
        System.out.println("Stack 2: "+stk2);
    }
}
