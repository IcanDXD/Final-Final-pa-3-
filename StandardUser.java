/*
 * Name: Ivan Cano
 * Pid: A14995355
 */

/**
 *
 * Returns the message of the user returning message, but in the case of this
 * fetch message, it will only return 1/10 of the size of the message
 *
 * @author Proffessor Langlois and the DSC team
 * @since NA
 *
 */import java.util.ArrayList;
import java.util.List;

public class StandardUser extends User {

    // Message to append when fetching non-text message
    private static final String FETCH_DENIED_MSG =
            "This message cannot be fetched because you are not a premium user.";
    /**
     * The constructor the StandardUser; calls the Super method constructor
     *
     * @param username takes in a valid string name
     */
    public StandardUser(String username, String bio) {
        super(username, bio);
    }

    /**
     * For standard users, they can only fetch the latest 1/10 of all the messages
     * in the message exchange. You should calculate the number of messages you
     * should fetch with integer division to avoid potential rounding difference.
     *
     * @param me the message exchange that it will read through its messages
     * @return returns the contents of the M.E
     */
    public String fetchMessage(MessageExchange me) {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        int tenDivider = 10;
        String finalString = "";
        ArrayList<Message> messageArray = me.getLog();
        int exchangeSize = messageArray.size();
        int exchangeSizeDivided = exchangeSize/tenDivider;
        for (int i = 0; i < exchangeSizeDivided; exchangeSizeDivided--) {
            if (messageArray.get(exchangeSize - exchangeSizeDivided) instanceof TextMessage) {
                finalString += messageArray.get(exchangeSize - exchangeSizeDivided).getContents() + "\n";
            }
            else {
                finalString += FETCH_DENIED_MSG + "\n";
            }
        }
        return finalString;

    }

    /**
     * The getter for the name of the name of the user
     *
     * @return name of user
     */
    public String displayName() {
        return username;
    }
}
