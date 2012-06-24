package objects;

/**
 *
 * GrowlMessage.java
 * 
 * Klasse zum Erstellen eines GrowlMessage-Objekts um angepasste Growl Messages
 * zu erzeugen
 * 
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class GrowlMessage {

    private String messageName;
    private String messageHead;
    private String messageBody;

    // Konstruktor
    public GrowlMessage(String messageName, String messageHead, String messageBody) {
        this.messageName = messageName;
        this.messageHead = messageHead;
        this.messageBody = messageBody;
        showGrowlMessage();
    }

    // Anzeigen der Growl Message
    public void showGrowlMessage() {
        Growl growl = new Growl(messageName, new String[]{messageName}, new String[]{messageName});
        growl.init();
        growl.registerApplication();
        growl.notify(messageName, messageHead, messageBody);
    }
}
