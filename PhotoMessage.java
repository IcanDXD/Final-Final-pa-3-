/*
 * Name: Ivan Cano
 * Pid: A14995355
 */

/**
 * * The PhotoMessage class will also ‘extend’ the abstract class
 *  *  Message. In addition, this class will also have its own instance
 *  *  variable extension, which is the file extension of the photo.
 *
 * @author Proffessor Langlois and the DSC team
 * @since NA
 *
 */public class PhotoMessage extends Message {

    // Error message to use in OperationDeniedException
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    // input validation criteria
    private static final String[] ACCEPTABLE_EXTENSIONS =
            new String[] {"jpg", "jpeg", "gif", "png", "tif"};

    // instance variable
    private String extension;
    private String originalExtension;

    /**
     * The constructor must call ‘super’ and pass in the parameters required
     * by the Message constructor as the FIRST LINE. In this case, it’s
     * “super(sender);”. This is a requirement of extending an abstract class.
     * You must use the ‘super classes’ constructor via the keyword ‘super’
     *
     * @param sender The sender which is the user
     * @param photoSource the source which will be in a photo
     * appropriate format
     * @throws OperationDeniedException fir when the operation had the wrong cal
     * such as a standard user
     */
    public PhotoMessage(User sender, String photoSource)
                        throws OperationDeniedException {
        super(sender);
        if ( !(sender instanceof PremiumUser) ) {
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        contents = photoSource;
        int tempArrayNumber = photoSource.toLowerCase().split("\\.").length;
        originalExtension = photoSource.split("\\.")[tempArrayNumber - 1];
        extension = photoSource.toLowerCase().split("\\.")[tempArrayNumber - 1];
        if (extension.equals("jpeg") || extension.equals("gif") ||
                extension.equals("png") || extension.equals("tif")) {
            //passes
        }
        else if (sender == null || photoSource == null) {
            throw new IllegalArgumentException();
        }
        else {
            throw new OperationDeniedException(INVALID_INPUT);
        }

    }

    /**
     * A getter that return contents
     *
     * @return A getter that return contents
     */
    public String getContents() {
        return getSender().displayName() + " [" + getDate() + "]: Picture at " + contents;
    }

    /**
     * A getter that return extensions
     *
     * @return A getter that return extensions
     */
    public String getExtension() {
        return originalExtension;
    }
}
