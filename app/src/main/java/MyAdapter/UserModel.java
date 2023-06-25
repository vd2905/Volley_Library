package MyAdapter;

public class UserModel
{
    int id;
    String name;
    String username;
    String phone;
    String company;
    String website;
    String address;

    public UserModel(int id, String name, String username, String phone, String company, String website, String address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.company = company;
        this.website = website;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
