package com.socialnetwork.posts;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.socialnetwork.users.User;

@Entity
@Table(name="Users")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String ID;
	private String authorID, message;
	LocalDateTime timeStamp;
	
	public Post() {
		
	}
	public Post(User user, String message) {
		this.authorID = user.getID();
		this.message = message;
		this.timeStamp= LocalDateTime.now();
	}
	
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
}
