/*
 * Name: Ivan Cano
 * Pid: A14995355
 */

/**
 * The StickerMessage class will also ‘extend’ the abstract class Message.
 * In addition, this class will also have its own instance variable packName,
 * which is the name of the sticker pack this sticker belongs to.
 *
 * @author Proffessor Langlois and the DSC team
 * @since NA
 *
 */
public class StickerMessage extends Message {

    // instance variable
    private String packName;

    /**
     * The constructor of the sticker class
     *
     * @param sender The sender which is the user
     * @param stickerSource The source of the sticker which will always be
     * divide by a "/"
     * @throws OperationDeniedException For when a user is denied
     */
    public StickerMessage(User sender, String stickerSource)
            throws OperationDeniedException {
        super(sender);
        if (!(sender instanceof PremiumUser)) {
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        if (sender == null || stickerSource == null) {
            throw new IllegalArgumentException();
        }
        String[] stickerArray = stickerSource.split("/");
        packName = stickerArray[0];
        String stickerName = stickerArray[1];
        contents = stickerName;
    }

    /**
     * getter for the contents
     *
     * @return the contents
     */
    public String getContents() {
        //check for brackets later
        return getSender().displayName() + " [" + getDate() +
                "]: Sticker" + "[" + contents + "] from Pack [" + packName + "]";
    }

    /**
     * getter for the pack name (first word before /)
     *
     * @return (first word before /)
     */
    public String getPackName() {
        return packName;
    }
}
