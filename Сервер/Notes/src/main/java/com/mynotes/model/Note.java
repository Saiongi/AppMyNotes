package com.mynotes.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

@Entity
@Table(name="notes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Note")
public class Note {
    public Note() {
        super();
    }

    private static final long serialVersionUID = -1232395859408322328L;

    @Id
    @Column(name="note_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="note")
    private String note;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdate")
    private Date createDate;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name="is_done", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isDone;

    public Note(int id, String note, Date createDate, boolean isDone) {
        this.id = id;
        this.note = note;
        this.createDate = createDate;
        this.isDone = isDone;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Note [" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", createDate=" + createDate +
                ", getIsDone=" + isDone +
                "]";
    }
}
