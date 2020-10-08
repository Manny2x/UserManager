import java.util.Scanner;

public class Program {
    private static void start(){
        System.out.println("Enter the the amount of Users you want: ");
        int limit = new Scanner(System.in).nextInt();

        UserCreator creator = new UserCreator();

        System.out.println("Now Enter your users: ");
        try{
            creator.generateUsers(limit);
        } catch (NotEnoughUserInformationException e) {
            e.retryGeneration(creator, limit);
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
