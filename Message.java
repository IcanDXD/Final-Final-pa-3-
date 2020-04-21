/*
 * Name: Ivan Cano
 * Pid: A14995355
 */

/**
 * The abstract class Message will have three instance
 * variables: sender of this message, the time this message
 * is created, and the contents of this message. Since this
 * is an abstract class, it cannot be directly instantiated.
 * @author Proffessor Langlois and the DSC team
 * @since NA
 *
 */
import java.time.LocalDate;

public abstract class Message {

    // Use these variable names as the msgType argument of sendMessage()
    // DO NOT MODIFY!
    public static final int TEXT    = 1000;
    public static final int PHOTO   = 1001;
    public static final int STICKER = 1002;

    // Error message to use in OperationDeniedException
    protected static final String DENIED_USER_GROUP =
            "This operation is disabled in your user group.";

    // instance variables
    private LocalDate date;
    private User sender;
    protected String contents;

    /**
     * Constructor will set the sender and date fields.
     *
     * @param sender The sender of the message
     */
    public Message(User sender) {
        if (sender == null) {
            throw new IllegalArgumentException();
        }
        this.date = LocalDate.now();
        this.sender = sender;
    }

    /**
     * Method will return the date of this message.
     *
     * @return returns local date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Method will return the sender of this message.
     *
     * @return
     */
    public User getSender() {
        return sender;
    }

    /**
     * Returns the contents of the message that is this instance
     *
     * @return the contents
     */
    public abstract String getContents();

}
