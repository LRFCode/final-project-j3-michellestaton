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
    private String memberName;
    private Date birthDay;

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

    public String getMemberName()
    {
        return memberName;
    }

    public void setmemberName(String memberName)
    {
        this.memberName = memberName;
    }

    public Date getBirthDay()
    {
        return birthDay;
    }

    public void setBirthDay(Date birthDay)
    {
        this.birthDay = birthDay;
    }
}
