/*
 * Name: Ivan Cano
 * Pid: A14995355
 */

/**
 * PhotoRoom class also implements the MessageExchange interface.
 * Although it’s highly similar to the normal ChatRoom, this class
 * has some key features that distinguish itself from ordinary
 *
 * @author Proffessor Langlois and the DSC team
 * @since NA
 *
 */

import java.util.ArrayList;

public class PhotoRoom implements MessageExchange {

    // instance variables
    private ArrayList<User> users;
    private ArrayList<Message> log;

    /**
     * Initializer/contructor of the Photo room
     */
    public PhotoRoom() {
        users = new ArrayList<User>();
        log = new ArrayList<Message>();
    }

    /**
     * Returns a log of the list of messages in the Photproom
     *
     * @return Returns a log of the list of messages in the Photproom
     */
    public ArrayList<Message> getLog() {
        return log;
    }

    /**
     * Method adds the given user u to this room. If this user is not
     * a PremiumUser, deny this operation by returning false.
     * Otherwise, add the user and return true.
     *
     * @param u User to add.
     * @return Always returns a true
     */
    public boolean addUser(User u) {
        if (u instanceof PremiumUser){
            users.add(u);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method removes the given user u from this room.
     *
     * @param u User to remove.
     */
    public void removeUser(User u) {
        try{
            users.remove(u);
        }
        catch (Exception e){
        }
    }

    /**
     * Method returns the users of this chat room.
     *
     * @return Method returns the users of this chat room.
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Method adds a new message to the log of this chat room.
     * If this message is not a PhotoMessage, deny this operation
     * by returning false. Otherwise, record the message and return true.
     * @param m Message to add.
     * @return returns true if successful and false otherwise
     */
    public boolean recordMessage(Message m) {
        if (m instanceof PhotoMessage) {
            log.add(m);
            return true;
        }
        else {
            return false;
        }
    }
}
