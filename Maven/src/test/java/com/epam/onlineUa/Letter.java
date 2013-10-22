package com.epam.onlineUa;

public class Letter {
	 public String author;
	 public String subject;
	 public String msgBody;
	 
	 public Letter (String author, String subject, String msgBody){
		 this.author = author;
		 this.subject = subject;
		 this.msgBody = msgBody;
	 }

	@Override
	public String toString() {
		return "Letter [author=" + author + ", subject=" + subject
				+ ", msgBody=" + msgBody + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((msgBody == null) ? 0 : msgBody.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (msgBody == null) {
			if (other.msgBody != null)
				return false;
		} else if (!msgBody.equals(other.msgBody))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	
	 

}
