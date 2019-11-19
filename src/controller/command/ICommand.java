package controller.command;

/**
 * This interface represents a command for the Image Model. It is a representation of the Command
 * Design pattern, multiple command classes implement this interface and provide the functionality
 * for specific commands.
 */
public interface ICommand {

  void execute();
}
