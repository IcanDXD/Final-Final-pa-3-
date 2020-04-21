/*
 * Name: Ivan Cano
 * Pid: A14995355
 */

/**
 *
 * @author Proffessor Langlois and the DSC team
 * @since NA
 *
 */
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Messenger Application Test
 * @author Proffessor Langlois and the DSC 30 Spr 2020 team
 * @since  NA
 */
public class MessengerApplicationTest {

    /*
      Messages defined in starter code. Remember to copy and paste these strings to the
      test file if you cannot directly access them. DO NOT change the original declaration
      to public.
     */

    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    /*
      Global test variables. Initialize them in @Before method.
     */
    PremiumUser marina;
    PremiumUser Ivan;
    PremiumUser Jose;

    MessageExchange room;
    TextMessage firstMessage;
    TextMessage secondMessage;
    TextMessage thirdMessage;

    StandardUser AnnnieRose;
    StandardUser Miku;
    StandardUser MexHeart;

    PhotoMessage photo1;
    PhotoMessage photo2;
    PhotoMessage photo3;

    StickerMessage sticker1;
    StickerMessage sticker2;
    StickerMessage sticker3;

    ChatRoom chatRoom1;
    ChatRoom chatRoom2;
    ChatRoom chatRoom3;

    PhotoRoom photoRoom1;
    PhotoRoom photoRoom2;
    PhotoRoom photoRoom3;


    /*
      The date used in Message and its subclasses. You can directly
      call this in your test methods.
     */
    LocalDate date = LocalDate.now();

    @Before
    public void setupAllConstructors() throws OperationDeniedException {
        marina = new PremiumUser("Marina", "Instructor");
        room = new ChatRoom();
        Ivan = new PremiumUser("Ivan", "I am a God");
        AnnnieRose = new StandardUser("AnnnieRose", "Good Artist");

        firstMessage = new TextMessage(marina, "this class hard");
        secondMessage = new TextMessage(Ivan, "bruh");
        thirdMessage = new TextMessage(AnnnieRose, "Dope Artist");

        photo1 = new PhotoMessage(marina, "lmao.png");
        photo2 = new PhotoMessage(Ivan, "hill.JPeG");
        photo3 = new PhotoMessage(Ivan, "omg.gif");

        sticker1 = new StickerMessage(Ivan, "yeah idk man/lmao");
        sticker2 = new StickerMessage(Ivan, "life is pain/suffering");
        sticker3 = new StickerMessage(marina, "wooooo/ahhh");

        chatRoom1 = new ChatRoom();
        chatRoom2 = new ChatRoom();
        chatRoom3 = new ChatRoom();

        photoRoom1 = new PhotoRoom();
        photoRoom2 = new PhotoRoom();
        photoRoom3 = new PhotoRoom();

        Jose = new PremiumUser("Jose", "hellped");
        Miku = new StandardUser("Miku", "weeb");
        MexHeart = new StandardUser("MexHeart", "Pride");

    }

    @Test (expected = OperationDeniedException.class)
    public void testillegalPhotType() throws  OperationDeniedException {
        photo1 = new PhotoMessage(marina, "lmao.2eex");
        photo2 = new PhotoMessage(Ivan, "hi.ll");
        photo3 = new PhotoMessage(Ivan, "omg.if");
    }

    @Test (expected = AssertionError.class)
    public void testMessageexception() throws OperationDeniedException {
        assertEquals(firstMessage.contents, 3);
        assertEquals(secondMessage.contents, " ");
    }
    @Test
    public void testMessage() throws OperationDeniedException {
        assertEquals(firstMessage.contents, "this class hard");
        assertEquals(secondMessage.contents, "bruh");
        assertEquals(thirdMessage.contents, "Dope Artist");
    }

    @Test
    public void testGetContents() throws OperationDeniedException {
        assertEquals(firstMessage.getContents(), "<Instructor> Marina [2020-04-20]: this class hard");
        assertEquals(secondMessage.getContents(), "<I am a God> Ivan [2020-04-20]: bruh");
        assertEquals(thirdMessage.getContents(), "AnnnieRose [2020-04-20]: Dope Artist");
    }

    @Test
    public void testGetSender() throws OperationDeniedException {
        assertEquals(firstMessage.getSender(), marina);
    }

    @Test
    public void testGetContentsPicture() throws OperationDeniedException {
        assertEquals(photo1.getContents(), "<Instructor> Marina [2020-04-20]: Picture at lmao.png");
    }

    @Test(expected = ComparisonFailure.class)
    public void testGetContentsPictureException() throws OperationDeniedException {
        assertEquals(photo1.getContents(), "<Instructor> Marina [2020-04-20]: Picture at lmao.hahah");
    }
    @Test
    public void testExtension() {
        assertEquals(photo1.getExtension(), "png");
    }


    @Test
    public void testStickerGetContents() {
        assertEquals(sticker1.getContents(), "<I am a God> Ivan [2020-04-20]: Sticker[lmao] from Pack [yeah idk man]");
    }

    @Test
    public void testStickergetPackName() {
        assertEquals(sticker1.getPackName(), "yeah idk man");
    }

    @Test
    public void testGetLog() {
        ArrayList<Message> log = new ArrayList<Message>();
        assertEquals(chatRoom1.getLog(), log);
    }

    @Test
    public void testGetUserAddUser() {
        ArrayList<User> users = new ArrayList<User>();
        assertEquals(chatRoom1.getLog(), users);

        ArrayList<User> users2 = new ArrayList<User>();
        users2.add(marina);
        users2.add(Ivan);
        users2.add(AnnnieRose);

        chatRoom1.addUser(marina);
        chatRoom1.addUser(Ivan);
        chatRoom1.addUser(AnnnieRose);

        assertEquals(chatRoom1.getUsers(), users2);
    }

    @Test
    public void testRemoveUser() {
        ArrayList<User> users2 = new ArrayList<User>();
        users2.add(marina);
        users2.add(AnnnieRose);

        chatRoom1.addUser(marina);
        chatRoom1.addUser(AnnnieRose);

        chatRoom1.removeUser(Ivan);
        assertEquals(users2, chatRoom1.getUsers());
        chatRoom1.removeUser(AnnnieRose);
        users2.remove(1);
        chatRoom1.removeUser(marina);
        users2.remove(0);
        assertEquals(users2, chatRoom1.getUsers());
    }

    @Test
    public void testRecordMessage() {
        assertTrue(chatRoom1.recordMessage(firstMessage));
        assertTrue(chatRoom1.recordMessage(secondMessage));
        assertTrue(chatRoom1.recordMessage(sticker1));
    }

    @Test
    public void testaddUserPhotoRoom() {
        ArrayList<User> users2 = new ArrayList<User>();
        users2.add(Ivan);
        users2.add(marina);

        photoRoom1.addUser(Ivan);
        photoRoom1.addUser(AnnnieRose);
        photoRoom1.addUser(marina);

        assertEquals(users2, photoRoom1.getUsers());
    }

    @Test
    public void testGetLogPhotoRoom() {
        ArrayList<Message> log = new ArrayList<Message>();
        assertEquals(photoRoom1.getLog(), log);
    }

    @Test
    public void testRemoveUserPhotoRoom() {
        ArrayList<User> users2 = new ArrayList<User>();
        users2.add(marina);

        photoRoom1.addUser(marina);
        photoRoom1.addUser(AnnnieRose);

        photoRoom1.removeUser(Ivan);
        assertEquals(users2, photoRoom1.getUsers());
        photoRoom1.removeUser(AnnnieRose);
        users2.remove(0);
        photoRoom1.removeUser(marina);
        assertEquals(users2, photoRoom1.getUsers());
        users2.add(marina);
        photoRoom1.addUser(marina);
        assertEquals(users2, photoRoom1.getUsers());
    }

    @Test
    public void testRecordMessagePitcureRoom() {
        assertTrue(photoRoom1.recordMessage(photo1));
        assertTrue(photoRoom1.recordMessage(photo2));
        assertTrue(photoRoom1.recordMessage(photo3));
    }

    @Test(expected = AssertionError.class)
    public void testAssertionerrorPictureRoom() {
        assertTrue(photoRoom1.recordMessage(firstMessage));
        assertTrue(photoRoom1.recordMessage(secondMessage));
        assertTrue(photoRoom1.recordMessage(sticker1));
    }

    @Test
    public void testStandardUserDisplayName() {
        assertEquals(AnnnieRose.displayName(), "AnnnieRose");
        assertEquals(Miku.displayName(), "Miku");
        assertEquals(MexHeart.displayName(), "MexHeart");
    }

    @Test
    public void testFetchMessage() {
        chatRoom1.addUser(Jose);
        chatRoom1.addUser(marina);
        chatRoom1.recordMessage(firstMessage);
        chatRoom2.addUser(Ivan);
        chatRoom2.recordMessage(secondMessage);
        assertEquals(marina.fetchMessage(chatRoom1), firstMessage.getContents() + "\n");
        assertEquals(Jose.fetchMessage(chatRoom1), firstMessage.getContents() + "\n");
        assertEquals(Ivan.fetchMessage(chatRoom2), secondMessage.getContents() + "\n");
    }

    @Test
    public void testFetchMessagePhotoRoom() {
        photoRoom1.addUser(Jose);
        photoRoom1.addUser(marina);
        photoRoom1.recordMessage(photo1);
        photoRoom2.addUser(Ivan);
        photoRoom2.recordMessage(photo2);
        assertEquals(marina.fetchMessage(photoRoom1), photo1.getContents() + "\n");
        assertEquals(Jose.fetchMessage(photoRoom1), photo1.getContents() + "\n");
        assertEquals(Ivan.fetchMessage(photoRoom2), photo2.getContents() + "\n");
    }

    @Test
    public void testdisplayname() {
        assertEquals(Jose.displayName(), "<hellped> Jose");
        assertEquals(Ivan.displayName(), "<I am a God> Ivan");
        assertEquals(marina.displayName(), "<Instructor> Marina");
    }

    @Test
    public void testSetCutsomTitle() {
        Jose.setCustomTitle("Father of a God");
        Ivan.setCustomTitle("Son of a God");
        marina.setCustomTitle("Sadist");

        assertEquals(Jose.displayName(), "<Father of a God> Jose");
        assertEquals(Ivan.displayName(), "<Son of a God> Ivan");
        assertEquals(marina.displayName(), "<Sadist> Marina");
    }

    @Test
    public void testCreatePhotoRoom() {
        ArrayList<User> myList = new ArrayList<User>();
        myList.add(Jose);

        PhotoRoom tester = new PhotoRoom();
        tester.addUser(Jose);
        tester.addUser(Ivan);
        assertEquals(Ivan.createPhotoRoom(myList).getUsers(), tester.getUsers());

        PhotoRoom tester2 = new PhotoRoom();
        myList.add(marina);
        tester2.addUser(Jose);
        tester2.addUser(marina);
        tester2.addUser(Ivan);
        assertEquals(Ivan.createPhotoRoom(myList).getUsers(), tester2.getUsers());

        PremiumUser randomPremium = new PremiumUser("Rand", "Na");
        ArrayList<User> myList2 = new ArrayList<User>();
        PhotoRoom tester3 = new PhotoRoom();
        tester3.addUser(randomPremium);
        assertEquals(randomPremium.createPhotoRoom(myList2).getUsers(), tester3.getUsers());
    }

    @Test
    public void testSetGetBio() {
        Ivan.setBio("I am a dope person");
        assertEquals(Ivan.displayBio(), "I am a dope person");
    }

    @Test
    public void testQuitRoom() {
        PhotoRoom testRoom = new PhotoRoom();
        photoRoom1.addUser(Ivan);
        Ivan.quitRoom(photoRoom1);
        assertEquals(photoRoom1.getUsers(), testRoom.getUsers());

        PhotoRoom testRoom2 = new PhotoRoom();
        photoRoom1.addUser(Jose);
        Jose.quitRoom(photoRoom1);
        assertEquals(photoRoom1.getUsers(), testRoom2.getUsers());

        PhotoRoom testRoom3 = new PhotoRoom();
        photoRoom1.addUser(marina);
        marina.quitRoom(photoRoom1);
        assertEquals(photoRoom1.getUsers(), testRoom3.getUsers());
    }

    /*
      Recap: Assert exception without message
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPremiumUserThrowsIAE() {
        marina = new PremiumUser("Marina", null);
    }

    /*
      Assert exception with message
     */
    @Test
    public void testPhotoMessageThrowsODE() {
        try {
            PhotoMessage pm = new PhotoMessage(marina, "PA02.zip");
            fail("Exception not thrown");
            // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(INVALID_INPUT, ode.getMessage());
        }
    }

    @Test
    public void testCreateRoom() {
        ArrayList<User> myList = new ArrayList<User>();
        myList.add(MexHeart);

        ChatRoom tester = new ChatRoom();
        tester.addUser(MexHeart);
        tester.addUser(Miku);
        assertEquals(Miku.createChatRoom(myList).getUsers(), tester.getUsers());

        ChatRoom tester2 = new ChatRoom();
        myList.add(AnnnieRose);
        tester2.addUser(MexHeart);
        tester2.addUser(AnnnieRose);
        tester2.addUser(Miku);
        assertEquals(Miku.createChatRoom(myList).getUsers(), tester2.getUsers());

        StandardUser randomPremium = new StandardUser("Rand", "Na");
        ArrayList<User> myList2 = new ArrayList<User>();
        ChatRoom tester3 = new ChatRoom();
        tester3.addUser(randomPremium);
        assertEquals(randomPremium.createChatRoom(myList2).getUsers(), tester3.getUsers());
    }

    @Test
    public void testSendMessage() {
        Ivan.sendMessage(photoRoom1, 1001, "ahhhhhh.png");
        marina.sendMessage(photoRoom1, 1001, "fwachwbdia.png");
        Jose.sendMessage(photoRoom1, 1001, "wa3e21ia.png");
    }
}
