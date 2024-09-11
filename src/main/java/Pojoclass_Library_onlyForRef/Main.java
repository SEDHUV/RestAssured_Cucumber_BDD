package Pojoclass_Library_onlyForRef;

import java.util.List;

public class Main {
    private String dashboard;
    private String purchaseAmount;
    private String website;
    private List<courses> courses;

    public String getDashboard() {
        return dashboard;
    }

    public void setDashboard(String dashboard) {
        this.dashboard = dashboard;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Pojoclass_Library_onlyForRef.courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Pojoclass_Library_onlyForRef.courses> courses) {
        this.courses = courses;
    }
}
