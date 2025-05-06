import java.util.Stack;

public class ExcuseLetterStack {
    private Stack<ExcuseLetter> stack;

    public ExcuseLetterStack() {
        stack = new Stack<>();
    }

    public void submitLetter(String id, String name, String className, char type, int duration) {
        ExcuseLetter letter = new ExcuseLetter(id, name, className, type, duration);
        stack.push(letter);
    }

    public void processLetter() {
        if (!stack.isEmpty()) {
            ExcuseLetter latestLetter = stack.pop();
            System.out.println("Processing the latest excuse letter:");
            latestLetter.displayLetter();
        } else {
            System.out.println("No letters to process.");
        }
    }

    public void viewLatestLetter() {
        if (!stack.isEmpty()) {
            ExcuseLetter latestLetter = stack.peek();
            System.out.println("Latest Excuse Letter:");
            latestLetter.displayLetter();
        } else {
            System.out.println("No letters to view.");
        }
    }

    public void searchLetterByName(String name) {
        boolean found = false;
        for (ExcuseLetter letter : stack) {
            if (letter.name.equalsIgnoreCase(name)) {
                letter.displayLetter();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No excuse letter found for student: " + name);
        }
    }
}
