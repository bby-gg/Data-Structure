package day04;

public class test {
    public static void main(String[] args) {
        MyArrayStack<String> stack = new MyArrayStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.size());    // 3
        System.out.println(stack.peek());    // C
        System.out.println(stack.pop());     // C
        System.out.println(stack.pop());     // B
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.pop());     // A
        System.out.println(stack.isEmpty()); // true

        try {
            stack.pop();
        } catch (Exception e) {
            System.out.println("空栈 pop 抛异常 OK");
        }
    }
}