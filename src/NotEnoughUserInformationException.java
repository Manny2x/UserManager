import java.io.InputStreamReader;

public class NotEnoughUserInformationException extends Exception{

    private int index;

    NotEnoughUserInformationException(int index){
        this.index = index;
    }

    private int retryAttempts = 0;

    public void retryGeneration(UserCreator userCreator,
                                InputStreamReader inputStreamReader){
        try {
            userCreator.generateUsers(this.getIndex(), inputStreamReader);
        } catch (NotEnoughUserInformationException e){
            retryAttempts++;
            if(retryAttempts >= 4){
                System.err.println("Too many null attempts, exiting!");
                System.exit(1);
            }

            retryGeneration(userCreator, inputStreamReader);
        }
    }

    @Override
    public String toString() {
        return "There was not enough information given to create the user" +
                "Index of creation: " + index;
    }

    public int getIndex() {
        return index;
    }
}
