import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserCreator {
    private ArrayList<User> users =
            new ArrayList<>();
    public void generateUsers(int limit) throws NotEnoughUserInformationException {
        BufferedReader inputReader
                = new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
        );

        int userIndex = 0;
        String name = null;
        Integer age = null;
        String address = null;
        while(users.size() != limit) {
            try {
                name = inputReader.readLine();
                age = Integer.valueOf(inputReader.readLine());
                address = inputReader.readLine();
            } catch (IOException ioExc) {
                ioExc.printStackTrace();
            }

            if (name == null
                    || age == null ||
                address == null) {
                throw new NotEnoughUserInformationException(userIndex);
            }
            User user = new User(name, age, address);
            System.out.println(user);

            users.add(userIndex, user);
            userIndex++;
        }
    }

    public void generateUsers(int userIndex, int limit) throws NotEnoughUserInformationException{
        BufferedReader inputReader
                = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
        String name = null;
        Integer age = null;
        String address = null;
        while(users.size() != limit) {
            try {
                name = inputReader.readLine();
                age = Integer.valueOf(inputReader.readLine());
                address = inputReader.readLine();
            } catch (IOException ioExc) {
                ioExc.printStackTrace();
            }

            if (name == null
                    || age == null |
                address == null) {
                throw new NotEnoughUserInformationException(userIndex);
            }
            User user = new User(name, age, address);

            System.out.println(user);

            users.add(userIndex, user);
            userIndex++;
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
