package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MemberDetail
{
    @Id
    private int membershipId;
    private int familyId;
    private String membername;
    private Date birthday;




    public int getMembershipId()
    {
        return membershipId;
    }

    public void setMembershipId(int membershipId)
    {
        this.membershipId = membershipId;
    }

    public int getFamilyId()
    {
        return familyId;
    }

    public void setFamilyId(int familyId)
    {
        this.familyId = familyId;
    }

    public String getName()
    {
        return membername;
    }

    public void setName(String Name)
    {
        this.membername = Name;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }
}
