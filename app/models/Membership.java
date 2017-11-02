package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;


    @Entity
    @Table(name = "Membership")
    public class Membership
    {
        @Id
        @Column(name = "MembershipId")
        private int membershipId;
        @Column(name = "MemberName")
        private String memberName;
        @Column(name = "Birthday")
        private Date birthday;
        @Column(name = "PhoneNumber")
        private String phonenumber;
        @Column(name = "Email")
        private String email;
        @Column(name = "FamilyId")
        private int familyid;


        public int getMembershipId()
        {
            return membershipId;
        }

        public void setMembershipId(int membershipId)
        {
            this.membershipId = membershipId;
        }

        public String getMemberName()
        {
            return memberName;
        }

        public void setMemberName(String memberName)
        {
            this.memberName = memberName;
        }

        public Date getBirthday()
        {
            return birthday;
        }

        public String getFormattedBirthday()
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (birthday == null)
            {
                return null;
            }
            else
            {
                return sdf.format(birthday);
            }
        }

        public void setBirthday(Date birthday)
        {
            this.birthday = birthday;
        }

        public String getPhonenumber()
        {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber)
        {
            this.phonenumber = phonenumber;
        }

        public String getEmail()
        {
            return email;
        }

        public void setEmail(String email)
        {
            this.email = email;
        }

        public int getFamilyid()
        {
            return familyid;
        }

        public void setFamilyid(int familyid)
        {
            this.familyid = familyid;
        }
    }

