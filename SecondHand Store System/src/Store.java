import java.util.ArrayList;
/**
 * This class contains the list of donations
 * added to the store
 * @author Lala
 */
public class Store {
	private ArrayList<Donation> donations;
	private Archive archive;
/**
 * contructor for the class Store 
 * constructs a new List of donations and a new Archive
 */
	public Store () {
		this.donations = new ArrayList<Donation>();
		this.archive = new Archive();
	}
	/**
         * method for adding a donation to the Store 
         * @param donation represents adding a donation to the Store 
         */
	public void addDonation (Donation donation) {
		donations.add(donation);
		
		ArrayList<Furniture> items = donation.items;
		
		for (int i = 0; i < items.size(); i++) {
			archive.add(items.get(i));
		}
	}
	/**
         * method for getting the list of items from the Archive
         * @return represents getting a return list of items from the Archive
         */
	public ArrayList<Furniture> getArchiveItems () {
		return archive.getArchive();
	}
        /**
         * method for getting the donations 
         * @return represents getting the donations from the Archive
         */
         public ArrayList<Donation> getDonations() {
            return donations;
        }
}
