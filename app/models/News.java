package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity

public class News
{
    @Id
    private int newsid;
    private String newsname;
    private String announcement;
    private Date startdate;
    private Date expirationdate;

    public int getNewsid()
    {
        return newsid;
    }

    public void setNewsid(int newsid)
    {
        this.newsid = newsid;
    }

    public String getNewsname()
    {
        return newsname;
    }

    public void setNewsname(String newsname)
    {
        this.newsname = newsname;
    }

    public String getAnnouncement()
    {
        return announcement;
    }

    public void setAnnouncement(String announcement)
    {
        this.announcement = announcement;
    }

    public Date getStartdate()
    {
        return startdate;
    }

    public void setStartdate(Date startdate)
    {
        this.startdate = startdate;
    }

    public Date getExpirationdate()
    {
        return expirationdate;
    }

    public void setExpirationdate(Date expirationdate)
    {
        this.expirationdate = expirationdate;
    }
}
