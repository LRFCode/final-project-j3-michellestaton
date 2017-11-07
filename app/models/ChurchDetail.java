package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



    @Entity
    @Table(name="Title")
    public class ChurchDetail
    {
        @Id
        @Column(name="TitleId") private int titleid;
        @Column(name="StaffPicture")   private byte[] picture;

        public int getTitleid()
        {
            return titleid;
        }

        public void setTitleid(int titleid)
        {
            this.titleid = titleid;
        }

        public byte[] getPicture()
        {
            return picture;
        }

        public void setPicture(byte[] picture)
        {
            this.picture = picture;
        }
    }
