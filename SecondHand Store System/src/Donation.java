import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Livia
 * This class has the ID of a certain danation which contains all the detailes. 
 * I had various methods to set and get information from it and it provides a
 * list of donations.
 * Class structure:
 *  _______________________________________
 * |           Donation                    |
 * |_______________________________________|
 * |		- donatorID: int           |
 * |		- address: String          |   
 * |		- telephoneNumber: int     |
 * |		- arrayList <furniture>    |
 * |		- pickUpDate: int          |
 * |		- zipCode: int             |
 * |		- email: String            |
 * |_______________________________________|
 * |		+ setDonaterID (): void    |
 * |		+ setAddress: void         |
 * |		+ setTelephone: void       |
 * |		+ setPickUpDate: void      |
 * |		+ setZipCode: void         |
 * |		+ setEmail: void           |
 * |		+ getDonatorID: int        |
 * |		+ getAddress: String       |
 * |		+ getTelephoneNumber: int  |
 * |		+ getPickUpDate: int       |
 * |		+ getZipCode: int          |
 * |		+ getEmail: String         |
 * |_______________________________________|
 */

public class Donation {
	Scanner userinput = new Scanner(System.in);
	private int id;
	private String address = " ";
	private int phone = 0;
	private Date date;
	private int zip = 0;
	private String mail = " ";
        private int status = 1;
	public ArrayList<Furniture> items = new ArrayList<>();
	
	public Donation() {
				
	}
	
        //constructor for the donation class with parameters for the dummy data
	public Donation(String address, int phone, String date, ArrayList<Furniture> furnitures) throws ParseException {
		this.id = setId();
		this.address = address;
		this.phone = phone;
		this.date = setDate(date);
		this.items = furnitures;
	}
	
        /**
         * Method to set the address of a certain donation
         * @param value here value represents the value the user enters
         */
	public void setAddress(String value) {
//		System.out.println("Enter your address: ");
		this.address = value;
	}
	
        /**
         * Method for getting the address assigned to a donation
         * @return the address inputed by the user
         */
	public String getAddress() {
//		System.out.println(address);
		return this.address;
	}
	
	/**
         * Method to set the phone number for a user donation
         */
	public void setPhone() {
		System.out.println("Enter your phone number: ");
		this.phone = userinput.nextInt();
	}
	
        /**
         * Method to get the phone number assigned to a donation
         * @return the value inputed by the user which is stored in the phone 
         * number variable
         */
	public int getPhone() {
		System.out.println(phone);
		return this.phone;		
	}
	
	/**
         * Method to set the zip number assigned to a donation         * 
         */
	public void setZip() {
		System.out.println("Enter your zip code: ");
		this.zip = userinput.nextInt();
	}
        
        /**
         * Method to get the zip number assigned to a donation
         * @return a system out print with the zip of the donation
         */
        public void getZip() {
            System.out.println(this.zip);
	}
	
	/**
         * Method to set the mail of a user assigned to a donation         * 
         */
	public void setMail() {
            System.out.println("Enter your mail: ");
            this.mail = userinput.next();
	} 
	
        /**
         * Method to get the mail assigned to a donation
         * @return the value inputed by the user which is stored in the phone 
         * number variable
         */
	public String getMail() {
            System.out.println(mail);
            return this.mail;
	}
	
        /**
         * Method to get the date assigned to a donation
         * @return the date when a donation is set to be picked up
         */
	public Date getDate() {
            return date;
	}
        
        /**
         * Method to set the date for a donation pick up
         * @param date the date of the pick up
         * @return the date set
         */
	public Date setDate(String date) throws ParseException {
            SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
            return simpleDate.parse(date);
	}
	
	/**
         * Method to set the ID number assigned to a donation
         * @return the number that results from the randomizer
         */
	private int setId() {
		int number = (int) Math.round(Math.random() * 100000);
		return number;
	} 
	
        /**
         * Method to get the ID number assigned to a donation
         * @return the value of the ID
         */
	public int getId() {
		return this.id;
	}
        
        public int getStatus(){
            return this.status;
        }
        
        public void setConfirmed(){
            this.status = 2;
        }
        
        public void setDenied(){
            this.status = 0;
        }
        
        /**
         * Method to get the list of furniture Items from a donation
         * @return the list of items
         */
        public ArrayList<Furniture> getItems() {
            return items;
        }
}
