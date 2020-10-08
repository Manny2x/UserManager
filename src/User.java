import java.util.Random;

public class User {
    private String name;
    private Integer age;
    private String userID;
    private String address;

    User(String name, Integer age, String address){
        this.name = name;
        this.age = age;
        this.address = address;

        StringBuilder userID =
                new StringBuilder(name.charAt(0) + age);
        char[] ranChars = {'A', 'B', 'C', 'F', 'G', 'H', 'X', 'Y', 'Z'};
        Random ranID = new Random();
        while(userID.length() != 7)
            userID.append(
                    ranChars[ranID.nextInt(ranChars.length)]);
        this.userID = String.valueOf(userID);

    }

        static class SubUser{
           private String name;
           private Object subInfo;

            SubUser(String name, Object subInfo){
                this.name = name;
                this.subInfo = subInfo;
           }

           @Override
           public String toString() {
               return name + ": " + subInfo;
           }
        }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getUserID(){
        return this.userID;
    }
    public String getAddress(){
        return this.address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", userID='" + userID + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
