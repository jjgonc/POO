package ficha3;

public class Ficha3_ex4 {
    private Ficha3_ex4_LampModes lampMode;
    private long tempo_consumo;
    private long total_consumo;
    private int consumoPorMilissec;

    public Ficha3_ex4() {
        this.lampMode = Ficha3_ex4_LampModes.OFF;
        this.tempo_consumo = 0;
        this.total_consumo = 0;
        this.consumoPorMilissec = 0;
    }

    public Ficha3_ex4(Ficha3_ex4 lamp) {
        this.lampMode = lamp.lampMode;
        this.tempo_consumo = lamp.tempo_consumo;
        this.total_consumo = lamp.total_consumo;
        this.consumoPorMilissec = lamp.consumoPorMilissec;
    }

    public Ficha3_ex4(Ficha3_ex4_LampModes mode, long tempo_consumo, long total_consumo, int consumoPorMilissec) {
        this.lampMode = mode;
        this.total_consumo = total_consumo;
        this.tempo_consumo = tempo_consumo;
        this.consumoPorMilissec = consumoPorMilissec;
    }


    public Ficha3_ex4_LampModes getLampMode() {
        return lampMode;
    }

    public void setLampMode(Ficha3_ex4_LampModes lampMode) {
        this.lampMode = lampMode;
    }

    public long getTempo_consumo() {
        return tempo_consumo;
    }

    public void setTempo_consumo(long tempo_consumo) {
        this.tempo_consumo = tempo_consumo;
    }

    public long getTotal_consumo() {
        return total_consumo;
    }

    public void setTotal_consumo(long total_consumo) {
        this.total_consumo = total_consumo;
    }

    public int getConsumoPorMilissec() {
        return consumoPorMilissec;
    }

    public void setConsumoPorMilissec(int consumoPorMilissec) {
        this.consumoPorMilissec = consumoPorMilissec;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Ficha3_ex4 that = (Ficha3_ex4) o;
        return tempo_consumo == that.tempo_consumo && total_consumo == that.total_consumo && consumoPorMilissec == that.consumoPorMilissec && lampMode == that.lampMode;
    }


    public String toString() {
        return "Ficha3_ex4{" +
                "lampMode=" + lampMode +
                ", tempo_consumo=" + tempo_consumo +
                ", total_consumo=" + total_consumo +
                ", consumoPorMilissec=" + consumoPorMilissec +
                '}';
    }
}
