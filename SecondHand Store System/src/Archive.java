import java.util.ArrayList;

/**
 * Class which holds all the furnitures processed in the donations
 * @author Livia Boeriu
 */
public class Archive {
	
    //the array list of furniture items stored in the store
    private ArrayList<Furniture> archive;

    //the constructor for the archive class
    public Archive(){
    archive = new ArrayList<>();
    }
    /**
     * Method which adds the furniture items to the array list of the archive
     * @param furniture the item added to the array list
     */
    public void add(Furniture furniture) {
            archive.add(furniture);	
    }
    /**
     * method to get the array list from the archive
     * @return the array list with all the furniture in the archive
     */
    public ArrayList<Furniture> getArchive() {
            return archive;
    }
}
