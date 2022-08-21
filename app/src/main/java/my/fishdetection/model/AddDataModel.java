package my.fishdetection.model;

public class AddDataModel {

    String fishName,commonName,description,distribution,threatToHumans,image;

    public AddDataModel(String fishName, String commonName, String description, String distribution, String threatToHumans, String image) {
        this.fishName = fishName;
        this.commonName = commonName;
        this.description = description;
        this.distribution = distribution;

        this.threatToHumans = threatToHumans;
        this.image = image;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThreatToHumans() {
        return threatToHumans;
    }

    public void setThreatToHumans(String threatToHumans) {
        this.threatToHumans = threatToHumans;
    }
}
