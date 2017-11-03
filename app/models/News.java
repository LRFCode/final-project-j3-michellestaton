package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
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
    public String getFormattedStartdate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (startdate == null)
        {
            return null;
        }
        else
        {
            return sdf.format(startdate);
        }
    }

    public void setStartdate(Date startdate)
    {
        this.startdate = startdate;
    }

    public Date getExpirationdate()
    {
        return expirationdate;
    }
    public String getFormattedExpirationdate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (expirationdate == null)
        {
            return null;
        }
        else
        {
            return sdf.format(expirationdate);
        }
    }

    public void setExpirationdate(Date expirationdate)
    {
        this.expirationdate = expirationdate;
    }
}
