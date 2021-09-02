package casaInteligente;

import java.util.Objects;

public class SmartDevice {
    private String id;
    private boolean on;

    public SmartDevice () {
        this.id = "";
        this.on = false;
    }

    public SmartDevice (SmartDevice device) {
        this.setID(device.getID());
        this.on = device.on;
    }

    public SmartDevice (String id, boolean on) {
        this.id = id;
        this.on = on;
    }

    public SmartDevice (String id) {
        this.id = id;
        this.on = false;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String toString() {
        return "SmartDevice{" +
                "nome='" + id + '\'' +
                ", on=" + on +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartDevice that = (SmartDevice) o;
        return on == that.on && Objects.equals(id, that.id);
    }

    public SmartDevice clone () {
        return new SmartDevice(this);
    }
}
