package POJOClasses_Oath_getter;

import java.util.List;

public class coursesJson {
    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<api> getApi() {
        return api;
    }

    public void setApi(List<api> api) {
        this.api = api;
    }

    public List<mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<mobile> mobile) {
        this.mobile = mobile;
    }

    private List<WebAutomation> webAutomation;
    private List<api> api;
    private List<mobile> mobile;


}
