import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCreator {
    private ArrayList<User> users =
            new ArrayList<>();
    public void generateUsers(InputStreamReader inputStreamReader)
            throws NotEnoughUserInformationException {
        BufferedReader inputReader
                = new BufferedReader(
                        inputStreamReader
        );

        int userIndex = 0;
        String name = null;
        Integer age = null;
        String address = null;
        String phone = null;
        while(true) {
            try {
                String userInfo = inputReader.readLine();

                System.out.println(userInfo);
                if(userInfo.isEmpty())
                    break;
                if(this.checkFalseSyntax(userInfo)){
                    System.err.println("Incorrect syntax, the correct syntax is -- \n" +
                            "NAME, AGE, ADDRESS, PHONE");
                    System.exit(1);
                }
                String[] userInfoArray =
                            userInfo
                                .split(", ");

                name = userInfoArray[0];
                age = Integer.valueOf(userInfoArray[1]);
                address = userInfoArray[2];
                phone = userInfoArray[3];
            } catch (NullPointerException | NumberFormatException e) {
                throw new NotEnoughUserInformationException(userIndex);
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert name != null;
            User user = new User(name, age, address, phone);
            System.out.println(user);

            users.add(userIndex, user);
            userIndex++;
        }
    }


    public void generateUsers(int userIndex,
                              InputStreamReader inputStreamReader) throws NotEnoughUserInformationException{
        BufferedReader inputReader
                = new BufferedReader(
                inputStreamReader
        );

        String name = null;
        Integer age = null;
        String address = null;
        String phone = null;
        while(true) {
            try {
                String userInfo = inputReader.readLine();

                if(userInfo.toUpperCase().equals("END"))
                    break;
                if(this.checkFalseSyntax(userInfo)){
                    System.err.println("Incorrect syntax, the correct syntax is -- \n" +
                            "NAME, AGE, ADDRESS, PHONE");
                    System.exit(1);
                }
                String[] userInfoArray =
                            userInfo
                                .split(", ");

                name = userInfoArray[0];
                age = Integer.valueOf(userInfoArray[1]);
                address = userInfoArray[2];
                phone = userInfoArray[3];
            } catch (Exception exc) {
                exc.printStackTrace();
            }

            assert name != null;
            assert address != null;
            if (name.strip().isEmpty() ||
                    address.strip().isEmpty()
                    || phone.strip().isEmpty()) {
                throw new NotEnoughUserInformationException(userIndex);
            }
            User user = new User(name, age, address, phone);
            System.out.println(user);

            users.add(userIndex, user);
            userIndex++;
        }
    }

    private boolean checkFalseSyntax(String userInfo){
        int occurrences = 0;
        Pattern pattern = Pattern.compile(", +");
        Matcher matcher = pattern.matcher(userInfo);
        while (matcher.find()){
            occurrences++;
        }

        return occurrences != 3;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
