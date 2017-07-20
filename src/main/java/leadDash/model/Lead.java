package leadDash.model;

/**
 *
 * @author David
 */

 
import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ld_table")
public class Lead implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    
    private int phone;
    
    private String email;
    
    private String address;
    
    private String city;
    
    private String state;
    
    private int zip;
    
    private String description;
    
    private String status;
    
    public int getId() {
        return id;
    } 
    public void setId(int i) {
        id = i;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public int getPhone(){
        return phone;
    }
    
    public void setPhone(int p){
        phone = p;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String e){
        email = e;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String a){
        address = a;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String c) {
        city = c;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String s){
        state = s;
    }
    
    public int getZip() {
        return zip;
    }
    
    public void setZip(int z) {
        zip = z;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String d) {
        description = d;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String s) {
        status = s;
    }
    
}
