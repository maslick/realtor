package si.ijs.maslick.ai.realtor;

public class House {
    private double houseSize;
    private double lotSize;
    private int bedrooms;
    private int granite;
    private double bathroom;

    // Constructors
    public House() {
    }

    public House(double houseSize, double lotSize, int bedrooms, int granite, double bathroom) {
        this.houseSize = houseSize;
        this.lotSize = lotSize;
        this.bedrooms = bedrooms;
        this.granite = granite;
        this.bathroom = bathroom;
    }

    // Getters, setters
    public double getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(double houseSize) {
        this.houseSize = houseSize;
    }

    public double getLotSize() {
        return lotSize;
    }

    public void setLotSize(double lotSize) {
        this.lotSize = lotSize;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getGranite() {
        return granite;
    }

    public void setGranite(int granite) {
        this.granite = granite;
    }

    public double getBathroom() {
        return bathroom;
    }

    public void setBathroom(double bathroom) {
        this.bathroom = bathroom;
    }

    // Builder
    public static House.HouseBuilder builder() {
        return new House.HouseBuilder();
    }

    public static class HouseBuilder {
        private double houseSize;
        private double lotSize;
        private int bedrooms;
        private int granite;
        private double bathroom;

        HouseBuilder() {
        }

        public House.HouseBuilder houseSize(double houseSize) {
            this.houseSize = houseSize;
            return this;
        }

        public House.HouseBuilder lotSize(double lotSize) {
            this.lotSize = lotSize;
            return this;
        }

        public House.HouseBuilder bedrooms(int bedrooms) {
            this.bedrooms = bedrooms;
            return this;
        }

        public House.HouseBuilder granite(int granite) {
            this.granite = granite;
            return this;
        }

        public House.HouseBuilder bathroom(double bathroom) {
            this.bathroom = bathroom;
            return this;
        }

        public House build() {
            return new House(this.houseSize, this.lotSize, this.bedrooms, this.granite, this.bathroom);
        }
    }
}