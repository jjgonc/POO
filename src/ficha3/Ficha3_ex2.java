package ficha3;

import java.util.Arrays;

public class Ficha3_ex2 {
    private String brand;   //marca
    private String model;   //modelo
    private int resX;   //resoluçao do display em X x Y (X)
    private int resY;   //resoluçao do display em X x Y (Y)
    private long messageStorage;    //dimesao do armazenamento para mensagens de texto (vistas com string)
    private long photoStorage;      //dimensao do armazenamento para as fotos
    private long appStorage;        //dimensao do armazenamento para as aplicaçoes
    private long appsAndPhotoStorage = appStorage + photoStorage;   //espaço total ocupado (em bytes)
    private long usedStorage;   //espaço total ocupado (em bytes)
    private long totalStorage;
    private int nPhotos;   //numero de fotos guardadas
    private int nApps;     //numero de aplicaçoes guardadas
    private int numMessages;
    private String [] appsName; //nome das aplicoes (o seu tamanho é o numero max de apps)
    private String [] messages; //(o seu tamanho é o numero max de mensagens)

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getResX() {
        return resX;
    }

    public void setResX(int resX) {
        this.resX = resX;
    }

    public int getResY() {
        return resY;
    }

    public void setResY(int resY) {
        this.resY = resY;
    }

    public long getMessageStorage() {
        return messageStorage;
    }

    public void setMessageStorage(long messageStorage) {
        this.messageStorage = messageStorage;
    }

    public long getPhotoStorage() {
        return photoStorage;
    }

    public void setPhotoStorage(long photoStorage) {
        this.photoStorage = photoStorage;
    }

    public long getAppStorage() {
        return appStorage;
    }

    public void setAppStorage(long appStorage) {
        this.appStorage = appStorage;
    }

    public long getAppsAndPhotoStorage() {
        return appsAndPhotoStorage;
    }

    public void setAppsAndPhotoStorage(long appsAndPhotoStorage) {
        this.appsAndPhotoStorage = appsAndPhotoStorage;
    }

    public long getUsedStorage() {
        return usedStorage;
    }

    public void setUsedStorage(long usedStorage) {
        this.usedStorage = usedStorage;
    }

    public int getnPhotos() {
        return nPhotos;
    }

    public void setnPhotos(int nPhotos) {
        this.nPhotos = nPhotos;
    }

    public int getnApps() {
        return nApps;
    }

    public void setnApps(int nApps) {
        this.nApps = nApps;
    }

    public int getNumMessages() {
        return numMessages;
    }

    public void setNumMessages(int numMessages) {
        this.numMessages = numMessages;
    }

    public  String [] getAppsName() {
        String [] res = new String[this.appsName.length];
        System.arraycopy(this.appsName, 0, res, 0, this.appsName.length);
        return res;
    }

    public void setAppsName( String [] appsName) {
        this.appsName = appsName;
    }

    public String [] getMessages() {
        String res[] = new String [this.messages.length];
        System.arraycopy(this.messages, 0, res, 0, this.messages.length);
        return res;
    }

    public void setMessages(String [] messages) {
        this.messages = new String[messages.length];
        System.arraycopy(messages, 0, this.messages, 0, this.messages.length);
        int c = 0;
        for (String msg: this.messages) {
            if (msg != null) {
                c++;
            }
        }
        this.numMessages = c;
    }

    public Ficha3_ex2 () {
        this.brand = "n/a";
        this.model = "n/a";
        this.resX = this.resY = 0;
        this.messageStorage = 0;
        this.photoStorage = 0;
        this.appStorage = 0;
        this.appsAndPhotoStorage = 0;
        this.usedStorage = 0;
        this.nPhotos = 0;
        this.nApps =0;
        this.numMessages = 0;
        this.totalStorage = 0;
        this.appsName = new String[100];
        this.messages = new String [100];
    }

    public Ficha3_ex2 (String brand, String model, int resX, int resY, long messageStorage, long photoStorage, long appStorage, long appsAndPhotoStorage, long usedStorage, int nPhotos, int nApps, long totalStorage, int numMessages, String [] appsName, String [] messages) {
        this.brand = brand;
        this.model = model;
        this.resX = resX;
        this.resY = resY;
        this.messageStorage = messageStorage;
        this.photoStorage = photoStorage;
        this.appStorage = appStorage;
        this.appsAndPhotoStorage = appsAndPhotoStorage;
        this.usedStorage = usedStorage;
        this.nPhotos = nPhotos;
        this.nApps = nApps;
        this.numMessages = numMessages;
        this.totalStorage = totalStorage;
        this.appsName = appsName;
        this.messages = messages;
    }

    public Ficha3_ex2 (Ficha3_ex2 phone) {
        this.brand = phone.getBrand();
        this.model = phone.getModel();
        this.resX = phone.getResX();
        this.resY = phone.getResY();
        this.messageStorage = phone.getMessageStorage();
        this.photoStorage = phone.getPhotoStorage();
        this.appStorage = phone.getAppStorage();
        this.appsAndPhotoStorage = phone.getAppsAndPhotoStorage();
        this.usedStorage = phone.getUsedStorage();
        this.nPhotos = phone.getnPhotos();
        this.nApps = phone.getnApps();
        this.numMessages = phone.numMessages;
        this.totalStorage = phone.totalStorage;
        this.appsName = phone.getAppsName();
        this.messages = phone.getMessages();
    }


    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Ficha3_ex2 p = (Ficha3_ex2) o;  //temos que fazer este cast!!
        return (this.getBrand().equals(p.getBrand()) && this.getAppStorage() == p.getAppStorage() && this.getMessageStorage() == p.getMessageStorage()
                && this.resX == p.getResX() && this.getResY() == p.getResY() && this.getAppsName().toString().equals(this.getAppsName().toString()) && this.getMessages().toString().equals(p.getMessages().toString())
                && this.getnApps() == p.getnApps() && this.numMessages == p.numMessages && this.totalStorage == this.totalStorage && this.getnPhotos() == p.getnPhotos() && this.getModel().equals(p.getModel()) && this.getPhotoStorage() == p.getPhotoStorage() && this.getUsedStorage() == p.getUsedStorage());
    }

    public Ficha3_ex2 clone () {
        return new Ficha3_ex2(this);
    }

    public String toString() {
        return "Ficha3_ex2{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", resX=" + resX +
                ", resY=" + resY +
                ", messageStorage=" + messageStorage +
                ", photoStorage=" + photoStorage +
                ", appStorage=" + appStorage +
                ", appsAndPhotoStorage=" + appsAndPhotoStorage +
                ", usedStorage=" + usedStorage +
                ", totalStorage=" + totalStorage +
                ", nPhotos=" + nPhotos +
                ", nApps=" + nApps +
                ", numMessages=" + numMessages +
                ", appsName=" + Arrays.toString(appsName) +
                ", messages=" + Arrays.toString(messages) +
                '}';
    }


    //alinea a
    public boolean existeEspaco (int numBytes) {
        if (this.usedStorage + numBytes < this.totalStorage) return true;
        else return false;
    }

    //exercicio b
    public void instalaApp (String nome, int tamanho) {
        if (existeEspaco(tamanho) && nApps < this.appsName.length) {
            this.appStorage += tamanho;
            this.appsName [this.nApps] = nome;  //é assim pq começa no zero, logo a app do indice napps nao vai estar ocuoada aidna
            this.nApps++;
        }
    }

    //exercicio c
    public void recebeMsg (String msg) {
        if (this.messages.length > numMessages) {
            this.messageStorage += msg.length();
            this.messages [this.numMessages] = msg;
            this.numMessages++;
        }
    }

    //exercicio d
    public double tamMedioApps () {
        return ((double) this.appStorage / this.nApps);
    }

    //exercicio e
    public String maiorMsg () {
        String maior = messages[0];
        for (int i=0; i < this.messages.length; i++) {
            if (this.messages[i].length() > maior.length()) maior = this.messages[i];
        }
        return maior;
    }

    //exercicio f

    public int existeApp (String [] nome) {
        int r = -1;
        for (int i=0; i < appsName.length; i++) {
            if (messages[i].equals(nome)) r = i;        //ver qual é o erro aqui
        }
        return r;
    }

    public void removeApp (String [] nome, int tamanho) {
        int ind = existeApp(nome);
        if (ind == -1) return;
        for (int i=ind; i<this.appsName.length; i++) {
            this.appsName[i] = this.appsName[i + 1]; //puxar tudo para tras
        }
        this.nApps--;
        this.appStorage -= tamanho;
    }

}
