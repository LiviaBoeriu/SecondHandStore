package Tool;

import java.util.ArrayList;

public class Archive {
	
	private ArrayList<Furniture> archive;
	
	public Archive(){
        archive = new ArrayList<>();
    }

	public void add(Furniture furniture) {
		archive.add(furniture);	
	}
	
	public ArrayList<Furniture> getArchive() {
		return archive;
	}
}
