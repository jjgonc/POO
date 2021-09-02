package casaInteligente;

public class SmartBulb extends SmartDevice {

    //public pq tem que ser visivel de outras classes para poder definir o ligh mode uma bulb
    //static pq é uma propriedade da classe (o valor 2 é sempre warm para todas as bulbs) (o valor que o tom pode tomar)
    //final pq se refere a uma constante

    public static final int WARM = 2;
    public static final int NEUTRAL = 1;
    public static final int COLD = 0;
    private int tone;

    public int getTone() {
        return this.tone;
    }

    public void setTone(int tone) {
        if (tone >=2) this.tone = WARM;
        else if (tone <= 0) this.tone = COLD;
        else this.tone = NEUTRAL;
    }

    public SmartBulb () {
        super();
        this.tone = NEUTRAL;
    }

    public SmartBulb (String id) {
        super(id);
        this.tone = NEUTRAL;
    }

    public SmartBulb (String id, int tone) {
        super(id);
        this.tone = tone;
    }

    public SmartBulb (String id, boolean on, int tone) {
        super(id, on);
        this.tone = tone;
    }

    public SmartBulb (SmartBulb smartBulb) {
        super (smartBulb.getID(), smartBulb.getOn());
        this.setTone(smartBulb.getTone());
    }

    public SmartBulb clone () {
        return new SmartBulb(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartBulb smartBulb = (SmartBulb) o;
        return (this.tone == smartBulb.tone && this.getID().equals(smartBulb.getID()));
    }
}
