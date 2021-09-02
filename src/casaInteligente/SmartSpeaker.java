package casaInteligente;

public class SmartSpeaker extends SmartDevice {
    public static final int MAX = 20;
    public static final int MIN = 0;
    private String channel;
    private int volume;


    public static int getMAX() {
        return MAX;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        if (volume >=20) this.volume = MAX;
        else if (volume <= 0) this.volume = MIN;
        else this.volume = volume;
    }

    public SmartSpeaker () {
        super();
        this.channel = "";
        this.volume = 0;
    }

    public SmartSpeaker (String id) {
        super (id);
        this.channel = "";
        this.volume = 0;
    }

    public SmartSpeaker (String id, boolean on, String channel, int volume) {
        super (id, on);
        this.channel = channel;
        setVolume(volume);
    }

    public SmartSpeaker (SmartSpeaker ss) {
        super (ss.getID(), ss.getOn());
        this.channel = ss.getChannel();
        this.volume = ss.getVolume();
    }

    public SmartSpeaker (String id, String channel, int volume) {
        super(id);
        this.channel = channel;
        setVolume(volume);
    }

    public SmartSpeaker clone() {
        return new SmartSpeaker(this);
    }


    public void volumeUp () {
        if (this.volume < 20) this.volume++;
    }

    public void volumeDown () {
        if (this.volume > 0) this.volume--;
    }
}