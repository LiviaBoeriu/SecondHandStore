package Tool;

import Tool.Archive;
import Tool.Donation;
import Tool.Furniture;
import java.util.ArrayList;

public class Store {
	private ArrayList<Donation> donations;
	private Archive archive;

	public Store () {
		this.donations = new ArrayList<Donation>();
		this.archive = new Archive();
	}
	
	public void addDonation (Donation donation) {
		donations.add(donation);
		
		ArrayList<Furniture> items = donation.items;
		
		for (int i = 0; i < items.size(); i++) {
			archive.add(items.get(i));
		}
	}
	
	public ArrayList<Furniture> getArchiveItems () {
		return archive.getArchive();
	}
        
         public ArrayList<Donation> getDonations() {
            return donations;
        }
}
