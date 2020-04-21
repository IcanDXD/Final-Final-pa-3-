/*
 * Name: Ivan Cano
 * Pid: A14995355
 */

/**
 * The ChatRoom class implements the MessageExchange interface.
 * The ChatRoom class is a simulator of a chat room that moderates
 * the communications between users by storing logs of the messages,
 * and recording the users that are in a particular chat room.
 *
 * @author Proffessor Langlois and the DSC team
 * @since NA
 *
 */import java.util.ArrayList;

public class ChatRoom implements MessageExchange {

    // instance variables
    private ArrayList<User> users;
    private ArrayList<Message> log;

    /**
     * Initializer/constructor of the Chatroom
     */
    public ChatRoom() {
        users = new ArrayList<User>();
        log = new ArrayList<Message>();
    }

    /**
     * getter of the users texts
     *
     * @return users texts
     */
    public ArrayList<Message> getLog() {
        return log;
    }

    /**
     * Adds the user specified to the room
     *
     * @param u User to add.
     * @return a true statement always
     */
    public boolean addUser(User u) {
            users.add(u);
            return true;
    }

    /**
     * The user to be removed in the room
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
     * gets the users in the room
     *
     * @return gets the users in the room
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Records a message into the logs of the room
     *
     * @param m Message to add.
     * @return a true always
     */
    public boolean recordMessage(Message m) {
        log.add(m);
        return true;
    }
}
