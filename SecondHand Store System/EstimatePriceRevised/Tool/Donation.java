package Tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/**
 * @author Livia
 * This class will provide the ID for the submission of the request
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
	public ArrayList<Furniture> items = new ArrayList<Furniture>();
	
	public Donation() {
				
	}
	
	public Donation(String address, int phone, String date, ArrayList<Furniture> furnitures) throws ParseException {
		this.id = setId();
		this.address = address;
		this.phone = phone;
		this.date = setDate(date);
		this.items = furnitures;
	}
	
	public void setAddress(String value) {
//		System.out.println("Enter your address: ");
		this.address = value;
	}
	
	public String getAddress() {
//		System.out.println(address);
		return this.address;
	}
	
	
	public void setPhone() {
		System.out.println("Enter your phone number: ");
		this.phone = userinput.nextInt();
	}
	
	public int getPhone() {
		System.out.println(phone);
		return this.phone;		
	}
	
	
	public void setZip() {
		System.out.println("Enter your zip code: ");
		this.zip = userinput.nextInt();
	}
	 public void getZip() {
		 System.out.println(this.zip);
	}
	
	
	public void setMail() {
            System.out.println("Enter your mail: ");
            this.mail = userinput.next();
	} 
	
	public String getMail() {
            System.out.println(mail);
            return this.mail;
	}
	
	public Date getDate() {
            return date;
	}

	public Date setDate(String date) throws ParseException {
            SimpleDateFormat simpleDate = new SimpleDateFormat("dd/mm/yyyy");
            return simpleDate.parse(date);
	}
	
	
	private int setId() {
		int number = (int) Math.round(Math.random() * 100000);
		return number;
	} 
	
	public int getId() {
		return this.id;
	}
        
        public ArrayList<Furniture> getItems() {
            return items;
        }
}
