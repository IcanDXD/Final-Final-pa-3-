/*
 * Name: Ivan Cano
 * Pid: A14995355
 */

/**
 * The TextMessage class will ‘extend’ the abstract class Message.
 * The key difference here is that Message has already implemented
 * certain methods and therefore TextMessage has access to those
 * methods without having to implement anything. For example, you
 * can use getDate() in this class to get the date created of this
 * message without implementing it here.
 *
 * @author Proffessor Langlois and the DSC team
 * @since NA
 *
 */
public class TextMessage extends Message {

    // Error message to use in OperationDeniedException
    private static final String EXCEED_MAX_LENGTH =
            "Your input exceeded the maximum length limit.";

    // input validation criteria
    private static final int MAX_TEXT_LENGTH = 1000;

    /**
     * The constructor of Text Message
     *
     * @param sender the sender, which is the user
     * @param text the text that should be inside the message
     *
     * @throws OperationDeniedException
     */
    public TextMessage(User sender, String text)
            throws OperationDeniedException {
        super(sender);
        if (!(sender instanceof User) || !(text instanceof String)) {
            throw new IllegalArgumentException();
        }
        if (text.length() > MAX_TEXT_LENGTH) {
            throw new OperationDeniedException(EXCEED_MAX_LENGTH);
        }
        //contents is in Message
        contents = text;
    }

    /**
     * getter function that returns the contents
     *
     * @return getter function that returns the contents
     */
    public String getContents() {
        return getSender().displayName() + " [" + getDate() + "]: " + contents;
    }

}
