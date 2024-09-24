package model;

public class Food {

    private String food_id;
    private String food_name;
    private String food_type;
    private int food_price;

    /**
     * @return the id
     */
    public String getId() {
        return food_id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String food_id) {
        this.food_id = food_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return food_name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String food_name) {
        this.food_name = food_name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return food_price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int food_price) {
        this.food_price = food_price;
    }
    
    public String getType() {
        return food_type;
    }

    /**
     * @param price the price to set
     */
    public void setType(String food_type) {
        this.food_type = food_type;
    }
}
