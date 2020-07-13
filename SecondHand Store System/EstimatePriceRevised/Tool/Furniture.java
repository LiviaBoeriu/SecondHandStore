package Tool;

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
    


    public Furniture (String category, String condition, String brand) {
        id = setId();
        this.category = category;
        this.condition = condition;
        this.brand = brand;
        estimatedPrice = setEstimatedPrice(category, condition, brand);
        actualPrice = 0;
    }

    public void setCategory (String value) {
        condition = value;
        System.out.print(condition);
    }

    public void setCondition () {

    }

    public void setBrand () {

    }
    
    public String getCategory() {
        return category;
    }
    
    public String getCondition() {
        return condition;
    }
    
    public String getBrand() {
        return brand;
    }

    private int setId() {
        int number = (int) Math.round(Math.random() * 100000);
        System.out.println("Furniture ID: " + number);
        return number;
    } 

    public int getId() {
        return this.id;
    }

    public double setEstimatedPrice(String category, String condition, String brand) {
        double price = 0;
        
        switch(category.toLowerCase()) {
            case "sofa":    price = 800;
                            break;
            case "closet":  price = 1000;
                            break;
            case "table":   price = 500;
                            break;
            case "chair":   price = 200;
                            break;
            case "lamp":    price = 150;
                            break;
            case "armchair":  price = 300;
                            break;
                            
        }
        
        switch(condition.toLowerCase()) {
            case "broken":  price -= (price * 0.3);
                            break;
            case "bad":     price -= (price * 0.15);
                            break;
            case "good":    price += (price * 0.15);
                            break;
            case "excellent":   price += (price * 0.3);
                                break;
        }
        
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
    
    public double getEstimatedPrice() {
        return estimatedPrice;
    }
    
    public void setActualPrice(boolean keepEstimatedPrice, double newPrice) {
        if(keepEstimatedPrice) {
            actualPrice = getEstimatedPrice();
        } else {
            actualPrice = newPrice;
        }
    }
    
    public double getActualPrice() {
        return actualPrice;
    }
        	
}
