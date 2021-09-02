package casaInteligente;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CasaInteligente {
    private String morada;
    private Set<SmartDevice> devices;
    private Set<String> rooms;
    private Map<String, Set<SmartDevice>> roomsNdevices;

    public CasaInteligente () {
        this.morada = "";
        this.devices = new HashSet<>();
        this.rooms = new HashSet<>();
        this.roomsNdevices = new HashMap<>();
    }

    public CasaInteligente (String morada) {
        this.morada = morada;
        this.rooms = new HashSet<>();
        this.devices = new HashSet<>();
        this.roomsNdevices = new HashMap<>();
    }

    public boolean existsDevice (String id) {
        for (SmartDevice sd : this.devices) {
            if (sd.getID().equals(id)) return true;
        }
        return false;
    }

    public void addDevice (SmartDevice sd) {
        this.devices.add(sd.clone());
    }

    public SmartDevice getDevice (String id) {
        for (SmartDevice sd : this.devices) {
            if (sd.getID().equals(id)) return sd.clone();
        }
        return null;
    }

    public void setAllOn (boolean on) {
        for (SmartDevice sd : this.devices) {
            sd.setOn(on);
        }
    }

    public void addRoom (String room) {
        this.rooms.add(room);
    }

    public boolean hasRoom (String name) {
        return this.rooms.contains(name);
    }

    public void addToRoom (String roomName, String id) {
        //verificar se eiste o quarto e, caso exista, adicionar aí o novo
        if (this.roomsNdevices.containsKey(roomName)) this.roomsNdevices.get(roomName).add(getDevice(id));
        //caso nao exista, criamos um novo
        else {
            Set <SmartDevice> sd = new HashSet<>();
            sd.add(getDevice(id));
            this.roomsNdevices.put(roomName, sd);
        }
    }

    public boolean roomHasDevice (String roomName, String id) {
        if (this.roomsNdevices.containsKey(roomName)) {
            for (SmartDevice sd : this.roomsNdevices.get(roomName))
                if (sd.getID().equals(id)) return true;
        }
        return false;
    }
}
