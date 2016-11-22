package lection_first.lambda.patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 20.11.2016.
 */
//reciever - perform any operations
interface Editor {
    void open();
    void save();
    void close();
    void edit();
}

//
class FileEditor implements Editor{

    @Override
    public void open() {
        System.out.println("FileEditor::open");
    }

    @Override
    public void save() {
        System.out.println("FileEditor::save");
    }

    @Override
    public void close() {
        System.out.println("FileEditor::close");
        System.out.println();
    }

    @Override
    public void edit() {
        System.out.println("FileEditor::edit");
    }
}

//command
@FunctionalInterface
interface Command{
    void perform();
}

//concrete command
class SaveCommand implements Command{

    private Editor editor;

    SaveCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}

class OpenCommand implements Command{
    private Editor editor;

    OpenCommand(Editor editor) {
        this.editor = editor;
    }
    @Override
    public void perform() {
        editor.open();
    }
}

class EditCommand implements Command{
    private Editor editor;

    EditCommand (Editor editor){
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.edit();
    }
}

class CloseCommand implements Command{
    private Editor editor;

    CloseCommand(Editor editor) {
        this.editor = editor;
    }
    @Override
    public void perform() {
        editor.close();
    }
}

//invoker
class Macros {

    private final List<Command> commands;

    Macros() {
        this.commands = new ArrayList<>();
    }

    void addCommand (Command command){
        commands.add(command);
    }

    void run (){
        commands.forEach(Command::perform);
    }
}

//client
public class CommandPattern {
    public static void main(String[] args) {
        Macros macros = new Macros();
        Editor editor = new FileEditor();
        Command open = new OpenCommand(editor);
        Command save = new SaveCommand(editor);
        Command close = new CloseCommand(editor);
        Command edit = new EditCommand(editor);

        macros.addCommand(open);
        macros.addCommand(save);
        macros.addCommand(edit);
        macros.addCommand(close);

        macros.run();

        Macros functionalMacros = new Macros();
        functionalMacros.addCommand(editor::open);
        functionalMacros.addCommand(editor::save);
        functionalMacros.addCommand(editor::edit);
        functionalMacros.addCommand(editor::close);

        functionalMacros.run();
    }
}
