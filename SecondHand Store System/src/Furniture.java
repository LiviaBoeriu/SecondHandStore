/**
 * 
 * @author Liv
 * This class will provide information about each individual piece of furniture.
 *  _______________________________________
 * |           Furniture                   |
 * |_______________________________________|
 * |		- category: String         |
 * |		- brand: String            |   
 * |		- condition: String        |
 * |		- price: String            |
 * |_______________________________________|
 * |		+ setDonaterID (): void    |
 * |		+ setAddress: void         |
 * |		+ setTelephone: void       |
 * |		+ setPickUpDate: void      |
 * |		+ setZipCode: void         | 
 * |		+ setBrand (): void        |
 * |		+ setCondition (): void    |
 * |		+ setPrice (): void        |
 * |_______________________________________|
 *
 */
public class Furniture {

    String category = " ";
    String condition = " ";
    String brand = " ";
    int id;
    double estimatedPrice, actualPrice;
    /**
     * constructor for the class furniture with parameters
     * @param category represents the category of the furniture
     * @param condition represents the condition of the furniture
     * @param brand represents the brand of the furniture
     */
    public Furniture (String category, String condition, String brand) {
        id = setId();
        this.category = category;
        this.condition = condition;
        this.brand = brand;
        estimatedPrice = setEstimatedPrice(category, condition, brand);
        actualPrice = 0;
    }
    /**
     * method for setting the category of the furniture
     * @param value 
     */
    public void setCategory (String value) {
        condition = value;
        System.out.print(condition);
    }
    /**
     * method for setting the condition of a certain furniture
     */
    public void setCondition () {

    }
    /**
     * method for setting the Brand of a certain furniture
     */
    public void setBrand () {

    }
    /**
     * method for getting the Category of a certain furniture
     * @return 
     */
    public String getCategory() {
        return category;
    }
    /**
     * method for getting the Condition of a certain furniture
     * @return 
     */
    public String getCondition() {
        return condition;
    }
    /**
     * method for getting the Brand of a certain furniture
     * @return 
     */
    public String getBrand() {
        return brand;
    }
/** 
 * method for setting Id of a certain furniture with a random number generator
 * @return returns random number 
 */
    private int setId() {
        int number = (int) Math.round(Math.random() * 100000);
        System.out.println("Furniture ID: " + number);
        return number;
    } 
/**
 * method for getting Id of a certain furniture
 * @return returns Id of a certain furniture
 */
    public int getId() {
        return this.id;
    }
/**
 * switch case method for setting the Estimated Price of the furniture with parameters 
 * @param category of a certain furniture
 * @param condition of a certain furniture
 * @param brand of a certain furniture
 * @return returns the price of a certain furniture
 */
    public double setEstimatedPrice(String category, String condition, String brand) {
        double price = 0;
        
        switch(category.toLowerCase()) {
            case "sofa":    price = 800;
                            break;
            case "skab":  price = 1000;
                            break;
            case "bord":   price = 500;
                            break;
            case "stol":   price = 200;
                            break;
            case "lampe":    price = 150;
                            break;
            case "armstol":  price = 300;
                            break;
                            
        }
        /**
         * switch case method for several conditions for the furniture
         */
        switch(condition.toLowerCase()) {
            case "broken":  price -= (price * 0.3);
                            break;
            case "dårlig":     price -= (price * 0.15);
                            break;
            case "god":    price += (price * 0.15);
                            break;
            case "megetgod":   price += (price * 0.3);
                                break;
        }
        /**
         * switch case method for several brands for the furniture
         */
        switch(brand.toLowerCase()) {
            case "ikea":    price += price * 0.1;
                            break;
            case "bilka":   price += price * 0.07;
                            break;
            case "jysk":    price += price * 0.05;
                            break;
            case "biltema":     price += price * 0.04;
                                break;
        }
        return price;
    }
    /**
     * method for getting the estimated price of a certain furniture
     * @return returns the estimated price of a certain furniture
     */
    public double getEstimatedPrice() {
        return estimatedPrice;
    }
    /**
     * method for setting the actual price of a certain furniture
     * @param keepEstimatedPrice keeps the price of a certain furniture
     * @param newPrice sets a new price of a certain furniture
     */
    public void setActualPrice(boolean keepEstimatedPrice, double newPrice) {
        if(keepEstimatedPrice) {
            actualPrice = getEstimatedPrice();
        } else {
            actualPrice = newPrice;
        }
    }
    /**
     * method for getting the actual price of a certain furniture
     * @return returns the actua price of a certain furniture
     */
    public double getActualPrice() {
        return actualPrice;
    }
        	
}
