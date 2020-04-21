/*
 * Name: Ivan Cano
 * Pid: A14995355
 */

/**
 *
 * @author Proffessor Langlois and the DSC team
 * @since NA
 *
 */import java.util.ArrayList;

public class PremiumUser extends User {

    // instance variable
    private String customTitle;

    /**
     * Constructor of the premiumUser
     *
     * @param username the name that will be used for the user
     * @param bio the bio that describes the user
     */
    public PremiumUser(String username, String bio) {
        super(username, bio);
    }

    /**
     * A getter for the message exchange
     *
     * @param me the message exchange
     * @return return the string of the message
     */
    public String fetchMessage(MessageExchange me) {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        String finalString = "";
        ArrayList<Message> messageArray = me.getLog();
        int exchangeSize = messageArray.size();
        for (int i = 0; i < exchangeSize; i++) {
            finalString += messageArray.get(i).getContents() + "\n";
        }
        return finalString;
    }

    /**
     * An exclusive photoroom that only premium users can join
     *
     * @param users An arraylist of users that will be added to the
     * photoroom if they are premium members
     * @return returns the photoroom created
     */
    public MessageExchange createPhotoRoom(ArrayList<User> users) {
        if (users == null) {
            throw new IllegalArgumentException();
        }
        MessageExchange newRoom = new PhotoRoom();
        for (int i = 0; i < users.size(); i++ ) {
            try{
                newRoom.addUser(users.get(i));
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            newRoom.addUser(this);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return newRoom;
    }

    /**
     * Displays name of the premium user
     *
     * @return Displays name of the premium user
     */
    public String displayName() {
        return "<" + bio + "> " + username;
    }

    /**
     * Sets a new title for the user
     *
     * @param newTitle the new title in string form
     */
    public void setCustomTitle(String newTitle) {
        bio = newTitle;
    }
}
