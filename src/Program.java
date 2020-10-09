import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Program {

    private static void start(){
        InputStreamReader inputStreamReader;
        UserCreator creator = new UserCreator();

        System.out.println("If you are entering a file, specify " +
                "it's path:");
        String path = new Scanner(System.in).nextLine();
        if(path.isEmpty()) {
            inputStreamReader = new InputStreamReader(System.in);

            System.out.println("Now Enter your users: ");
            try {
                creator.generateUsers(inputStreamReader);
            } catch (NotEnoughUserInformationException e) {
                System.err.println("There was not enough information, re-enter tht user!");
                e.retryGeneration(creator, inputStreamReader);
            }
        } else {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(
                        new File(path)
                ));

                try {
                    creator.generateUsers(inputStreamReader);
                } catch (NotEnoughUserInformationException e) {
                    e.retryGeneration(creator, inputStreamReader);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        while (true){
            System.out.println("Enter command: ");
            MapCommand command = MapCommand.stringToCommand(
                    new Scanner(System.in)
                            .nextLine()
            );
            if(command == null)
                continue;
            if(command.equals(MapCommand.END))
                System.exit(0);

            command.filterMap.filterMap(
                    creator.getUsers()
            ).forEach((System.out::println));
        }
    }


    public static void main(String[] args) {
        start();
    }
}
