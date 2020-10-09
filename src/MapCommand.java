
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MapCommand {
    AGE((list) -> {
        Stream<User.SubUser> userStream =
                list.stream().filter((user) -> user.getAge() >= 0)
                        .map((user) ->
                                new User.SubUser(user.getName(),
                                    user.getAge()));
        return userStream.collect(Collectors.toList());
    }),
    USER_ID((list) -> {
        Stream<User.SubUser> userStream =
                list.stream()
                        .map((user ->
                                new User.SubUser(user.getName(),
                                    user.getUserID())));
        return userStream.collect(Collectors.toList());
    }),
    ADDRESS((list) -> {
        Stream<User.SubUser> userStream =
                list.stream().filter((user) -> !user.getAddress().equals("NULL"))
                        .map((user ->
                                new User.SubUser(user.getName(),
                                    user.getAddress())));
        return userStream.collect(Collectors.toList());
    }),
    PHONE((list) -> {
        Stream<User.SubUser> userStream =
                list.stream().filter((user) -> !user.getPhone().equals("NULL"))
                        .map((user ->
                                new User.SubUser(user.getName(),
                                        user.getPhone())));
        return userStream.collect(Collectors.toList());
    }),END;

    FilterMap filterMap;

    MapCommand(FilterMap fMap){
        this.filterMap = fMap;
    }
    MapCommand(){}

    public static MapCommand stringToCommand(String str){
        ArrayList<MapCommand> commands =
                new ArrayList<>(Arrays.asList(MapCommand.ADDRESS,
                        MapCommand.AGE,
                        MapCommand.USER_ID,
                        MapCommand.END,
                        MapCommand.PHONE));

        for(MapCommand command : commands){
            if(str.toUpperCase().equals(
                    String.valueOf(command)
            ))
                return command;
        }
        return null;
    }
}
