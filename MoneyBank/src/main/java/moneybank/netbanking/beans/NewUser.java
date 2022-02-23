package moneybank.netbanking.beans;

import java.util.Date;
import java.util.List;

public class NewUser {
int user_id;
String fname;
String lname;
String reg_dt_time; 
List<String> doc_list;
char action;
public char getAction() {
	return action;
}
public void setAction(char action) {
	this.action = action;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getReg_dt_time() {
	return reg_dt_time;
}
public void setReg_dt_time(String reg_dt_time) {
	this.reg_dt_time = reg_dt_time;
}
public List<String> getDoc_list() {
	return doc_list;
}
public void setDoc_list(List<String> doc_list) {
	this.doc_list = doc_list;
}
@Override
public String toString() {
	return "NewUser [user_id=" + user_id + ", fname=" + fname + ", lname=" + lname + ", reg_dt_time=" + reg_dt_time
			+ ", doc_list=" + doc_list + ", action=" + action + "]";
}

}
