/*
 * Name: Ivan Cano
 * Pid: A14995355
 */

/**
 * The User class is the abstract class that defines the functionality
 * of a user in our messaging app.
 *
 * @author Proffessor Langlois and the DSC team
 * @since NA
 *
 */

import java.util.ArrayList;

public abstract class User {

    // Error message to use in OperationDeniedException
    protected static final String JOIN_ROOM_FAILED =
            "Failed to join the chat room.";
    protected static final String INVALID_MSG_TYPE =
            "Cannot send this type of message to the specified room.";

    // instance variables
    protected String username;
    protected String bio;
    protected ArrayList<MessageExchange> rooms;

    /**
     * The constructor for the User
     *
     * @param username  viable username for the user.
     * @param bio A description for the bio of this user.
     */
    public User(String username, String bio) {
        if (username == null || bio == null) {
            throw new IllegalArgumentException();
        }
        rooms = new ArrayList<MessageExchange>();
        this.username = username;
        this.bio = bio;
    }

    /**
     * sets the bio for the user
     *
     * @param newBio a string for the bio
     */
    public void setBio(String newBio) {
        if (newBio == null) {
            throw new IllegalArgumentException();
        }
        bio = newBio;
    }

    /**
     * return the bio
     *
     * @return returns the bio for this user
     */
    public String displayBio() {
        return bio;
    }

    /**
     * Allows for a user to join a room that is in the
     * message exchange parameter
     *
     * @param me the message exhange that the user will join
     * @throws OperationDeniedException if thr room joined fails
     */
    public void joinRoom(MessageExchange me)
            throws OperationDeniedException {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < rooms.size(); i++) {
            if (me == rooms.get(i)){
                throw new OperationDeniedException(JOIN_ROOM_FAILED);
            }
        if(me.addUser(this)) {
            rooms.add(me);
        }
        else{
            throw new OperationDeniedException();
        }
        }
    }

    /**
     * Quits the roomspecified in the  message exchange
     *
     * @param me The message exchange that is to be left
     */
    public void quitRoom(MessageExchange me) {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        me.removeUser(this);
        rooms.remove(me);
    }

    /**
     * Creates a new instance of the ChatRoom
     * (will be implemented later) class. For each user
     * in the users list calls joinRoom method to join the room.
     *
     * @param users the users that will be joining the made M.E
     * @return the made M.E
     */
    public MessageExchange createChatRoom(ArrayList<User> users) {
        //this whole shit could be wrong
        if (users == null) {
            throw new IllegalArgumentException();
        }
        MessageExchange newRoom = new ChatRoom();
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
     * Creates an instance of a message with the correct
     * type specified by the msgType (compare it to the static
     * class variables in the Message class).
     *
     * @param me the message exchange that the message will be sent to
     * @param msgType the msg type that will be determined
     * by comparing units of type user instance
     * @param contents the type of contents
     */
    public void sendMessage(MessageExchange me, int msgType, String contents) {
        if (me == null || contents == null ) {
            throw new IllegalArgumentException();
        }
        //checks if user is in Message exchange me.
        boolean flag = false;
        for (User i: me.getUsers()) {
            if (this == i) {
                flag = true;
            }
        }
        if (flag == true) {
            throw new IllegalArgumentException();
        }
        if (msgType == 1000) {
            try {
                TextMessage newMessage = new TextMessage(this, contents);
                try {
                    me.recordMessage(newMessage);
                }
                catch (Exception e) {
                    System.out.println(INVALID_MSG_TYPE);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (msgType == 1001) {
            try {
                PhotoMessage newMessage = new PhotoMessage(this, contents);
                try {
                    me.recordMessage(newMessage);
                }
                catch (Exception e) {
                    System.out.println(INVALID_MSG_TYPE);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (msgType == 1002) {
            try {
                StickerMessage newMessage = new StickerMessage(this, contents);
                try {
                    me.recordMessage(newMessage);
                }
                catch (Exception e) {
                    System.out.println(INVALID_MSG_TYPE);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            throw new IllegalArgumentException();
        }
        }


    /**
     * A getter for the message exchange
     *
     * @param me the message exchange
     * @return return the string of the message
     */
    public abstract String fetchMessage(MessageExchange me);

    /**
     * returns the name of the user
     *
     * @return returns the name of the user
     */
    public abstract String displayName();
}
