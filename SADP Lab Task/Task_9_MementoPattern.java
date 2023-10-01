import java.util.ArrayList;
import java.util.List;

// Memento class to store the state of the text editor
class EditorMemento {
    private String text;

    public EditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Originator class representing the text editor
class TextEditor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public EditorMemento save() {
        return new EditorMemento(text);
    }

    public void restore(EditorMemento memento) {
        text = memento.getText();
    }
}

// Caretaker class to manage the mementos
class History {
    private List<EditorMemento> mementos = new ArrayList<>();

    public void push(EditorMemento memento) {
        mementos.add(memento);
    }

    public EditorMemento pop() {
        int lastIndex = mementos.size() - 1;
        EditorMemento memento = mementos.get(lastIndex);
        mementos.remove(lastIndex);
        return memento;
    }
}

class MementoPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.setText("This is the initial text.");

        // Save the initial state
        history.push(editor.save());

        // Modify the text
        editor.setText("Modified text: Adding more content.");

        // Save the modified state
        history.push(editor.save());

        // Modify the text again
        editor.setText("Modified text: Making further changes.");

        // Restore the previous state
        editor.restore(history.pop());

        System.out.println("Current Text: " + editor.getText());
    }
}
