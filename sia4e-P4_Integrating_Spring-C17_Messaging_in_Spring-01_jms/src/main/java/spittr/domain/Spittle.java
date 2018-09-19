package spittr.domain;

import java.io.Serializable;
import java.util.Date;

public class Spittle implements Serializable {

    private static final long serialVersionUID = 319620099308405504L;

    private final Long id;
    private final String text;
    private final Date postedTime;
    private Spitter spitter;

    public Spittle(Long id, Spitter spitter, String text, Date postedTime) {
        this.id = id;
        this.spitter = spitter;
        this.text = text;
        this.postedTime = postedTime;
    }

    public Long getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public Date getPostedTime() {
        return this.postedTime;
    }

    public Spitter getSpitter() {
        return spitter;
    }

}