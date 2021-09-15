
public class User {

	 protected String name;
	 protected String date;
	 protected String location;
	 protected String time;
	
	 public User() {}
	 
	 public User(String name, String date, String location, String time) {
	 super();
	 this.name = name;
	 this.date = date;
	 this.location = location;
	 this.time = time;
	 }
	 public String getName() {
	 return name;
	 }
	 public void setName(String eventName) {
	 this.name = name;
	 }
	 public String getDate() {
	 return date;
	 }
	 public void setDate(String date) {
	 this.date = date;
	 }
	 public String getLocation() {
	 return location;
	 }
	 public void setLocation(String location) { 
	 this.location = location;
	 }
	 public String getTime() {
	 return time;
	 }
	 public void setTime(String time) {
	 this.time = time;
	 }

}
