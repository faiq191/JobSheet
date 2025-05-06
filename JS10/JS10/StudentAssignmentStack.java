public class StudentAssignmentStack {
    Student[] stack;
    int size;
    int top;

    public StudentAssignmentStack(int size) {
        this.size = size;
        this.top = -1;
        this.stack = new Student[size];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Student std) {
        if (!isFull()) {
            stack[++top] = std;
        } else {
            System.out.println("Stack is already full!!");
        }
    }

    public Student pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            System.out.println("There is no data in Stack!!");
            return null;
        }
    }

    public Student peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("There is no data in Stack!!");
            return null;
        }
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i].nim + "\t" + stack[i].name + "\t" + stack[i].className);
        }
    }

    String convertToBinary(int grade) {
        ConversionStack stack = new ConversionStack();
        while (grade > 0) {
            int mod = grade % 2;
            stack.push(mod);
            grade = grade / 2;
        }
        String binary = "";
        while (!stack.isEmpty()) {
            binary += stack.pop();
        }
        return binary;
    }
}

