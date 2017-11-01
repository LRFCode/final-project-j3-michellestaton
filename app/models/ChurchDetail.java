package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChurchDetail
{
    @Id
    private String membername;
    private String name;
    private int familyId;

    public String getMembername()
    {
        return membername;
    }

    public void setMembername(String membername)
    {
        this.membername = membername;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getFamilyId()
    {
        return familyId;
    }

    public void setFamilyId(int familyId)
    {
        this.familyId = familyId;
    }
}
