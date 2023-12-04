package entitys;

public class EmployeeEntity {
    private long uId;
    private String userName;
    private String designation;
    private String location;
    private long phoneNumber;
    private long salary;

    public EmployeeEntity() {
        super();
    }

    public EmployeeEntity(long uId, String userName, String designation, String location, long phoneNumber, long salary) {
        super();
        this.uId = uId;
        this.userName = userName;
        this.designation = designation;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeEntity [uId=" + uId + ", userName=" + userName + ", designation=" + designation + ", location="
                + location + ", phoneNumber=" + phoneNumber + ", salary=" + salary + "]";
    }
}
