package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="eventcalendar")
public class CalendarInfo
{
    @Id
    private int calendarid;
    private String description;
    private Date calendardate;
    private int eventtypeid;

    public int getCalendarid()
    {
        return calendarid;
    }

    public void setCalendarid(int calendarid)
    {
        this.calendarid = calendarid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCalendardate()
    {
        return calendardate;
    }

    public void setCalendardate(Date calendardate)
    {
        this.calendardate = calendardate;
    }

    public int getEventtypeid()
    {
        return eventtypeid;
    }

    public void setEventtypeid(int eventtype)
    {
        this.eventtypeid = eventtype;
    }
}
