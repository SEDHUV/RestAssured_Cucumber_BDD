package POJOClasses_Oath_setter;

import java.util.List;

public class SetterClass {

    public void setLocation(POJOClasses_Oath_setter.location location) {
        this.location = location;
    }



    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getWebsite() {
        return website;
    }

    public String getLanguage() {
        return language;
    }

    public POJOClasses_Oath_setter.location getLocation() {
        return location;
    }

    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private List<String> types;
    private String website;
    private String language;
    private location location;
}
