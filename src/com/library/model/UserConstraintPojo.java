package com.library.model;

import java.util.ArrayList;
import java.util.List;

/**
 * checks user reached limit or not
 * @author Test
 *
 */
public class UserConstraintPojo {

	private String userId;
	
	private List<String> takenBookIds = new ArrayList<String>();
	
	public List<String> getTakenBookIds() {
		return takenBookIds;
	}

	public void setTakenBookIds(List<String> takenBookIds) {
		this.takenBookIds = takenBookIds;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserConstraintPojo [userId=" + userId + ", takenBookIds="
				+ takenBookIds + "]";
	}

	

}
