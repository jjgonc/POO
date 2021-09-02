package ficha3;

import java.util.ArrayList;
import java.util.Date;

public class Ficha3_ex3 {
    private String videoName;
    private long videoContent;
    private Date uploadDate;
    private int res;
    private int dur_Min;
    private int dur_Seg;
    private ArrayList<String> comments;
    private int numLikes;
    private int numDislikes;

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public long getVideoContent() {
        return videoContent;
    }

    public void setVideoContent(long videoContent) {
        this.videoContent = videoContent;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public int getDur_Min() {
        return dur_Min;
    }

    public void setDur_Min(int dur_Min) {
        this.dur_Min = dur_Min;
    }

    public int getDur_Seg() {
        return dur_Seg;
    }

    public void setDur_Seg(int dur_Seg) {
        this.dur_Seg = dur_Seg;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public int getNumDislikes() {
        return numDislikes;
    }

    public void setNumDislikes(int numDislikes) {
        this.numDislikes = numDislikes;
    }


    public Ficha3_ex3 (String videoName, long videoContent, Date uploadDate, int res, int dur_Min, int dur_Seg, ArrayList<String> comments, int numLikes, int numDislikes) {
        this.videoName = videoName;
        this.videoContent = videoContent;
        this.uploadDate = uploadDate;
        this.res = res;
        this.dur_Min = dur_Min;
        this.dur_Seg = dur_Seg;
        this.comments = new ArrayList<String>(comments.size());
        for (String comments_AL: comments) this.comments.add(comments_AL);
        this.numLikes = numLikes;
        this.numDislikes = numDislikes;
    }

    public Ficha3_ex3 (Ficha3_ex3 yt) {
        this.videoName = yt.videoName;
        this.videoContent = yt.videoContent;
        this.uploadDate = yt.uploadDate;
        this.res = yt.res;
        this.dur_Min = yt.dur_Min;
        this.dur_Seg = yt.dur_Seg;
        this.comments = new ArrayList<String>(yt.comments.size());
        for (String comments_AL: yt.comments) this.comments.add(comments_AL);
        this.numLikes = yt.numLikes;
        this.numDislikes = yt.numDislikes;
    }

    public Ficha3_ex3 () {
        this.videoName = "n/a";
        this.videoContent = 0;
        this.uploadDate = null;
        this.res = 1080;
        this.dur_Min = 0;
        this.dur_Seg = 0;
        this.comments = null;
        this.numLikes = 0;
        this.numDislikes = 0;
    }

    public Ficha3_ex3 clone (Ficha3_ex3 yt) {
        return new Ficha3_ex3(this);
    }


    public String toString() {
        final StringBuffer sb = new StringBuffer("Video: {");
        sb.append("Name: ").append(videoName);
        sb.append(", Content: ").append(videoContent);
        sb.append(", UpDate: ").append(uploadDate.toString());
        sb.append(", Resolution: ").append(res);
        sb.append(", Duration: ").append(dur_Min);
        sb.append(":").append(dur_Seg);
        sb.append(", Comments: ").append(comments);
        sb.append(", Likes: ").append(numLikes);
        sb.append(", Dislikes: ").append(numDislikes);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals (Object o) {
        if (this == o) return true;
        if (o==null || this.getClass() != o.getClass()) return false;
        Ficha3_ex3 yt = (Ficha3_ex3) o; //fazer este cast do object para o tipo Ficha3_ex3
        return (this.videoName.equals(yt.getVideoName()) && this.getVideoContent() == yt.getVideoContent() && this.getUploadDate() == yt.getUploadDate() && this.getRes() == yt.getRes() && this.getDur_Min() == yt.getDur_Min() && this.getDur_Seg() == yt.getDur_Seg() && this.getComments().toString().equals(yt.getComments().toString()) && this.getNumLikes() == yt.getNumLikes() && this.getNumDislikes() == yt.getNumDislikes());
    }


    //alinea b
    public void insereComentario (String comentario) {
        this.comments.add(comentario);
    }

    //alinea c
    public long qtsDiasDepois() {
        Date today = new Date();
        long dif = today.getTime() - this.uploadDate.getTime();

        return (dif)/(24*60*60*1000);
    }

    //alinea d
    public void thumbsUp () {
        this.numLikes++;
    }

    //alinea e
    public String processa() {
        return (""+this.videoContent);
    }
}
