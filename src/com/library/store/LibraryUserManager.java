package com.library.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.library.config.LibraryAppConstants;
import com.library.exception.UserNotFoundException;
import com.library.model.UserConstraintPojo;
import com.library.model.UserPojo;

/**
 * this class is responsible for managing users in the system. admins who adds
 * user's to the store
 * 
 * @author Test
 *
 */
public class LibraryUserManager {

	/**
	 * singleton class for managing user manager
	 */
	private static volatile LibraryUserManager userstore;

	/**
	 * map for managing users in the library system
	 */
	private static Map<String, UserPojo> userList = new ConcurrentHashMap<String, UserPojo>();

	/**
	 * map for managing users constraints in the library system
	 */
	private static Map<String, UserConstraintPojo> userConstraints = new ConcurrentHashMap<String, UserConstraintPojo>();

	private LibraryUserManager() {

	}

	/**
	 * singleton class
	 * 
	 * @return
	 */
	public static LibraryUserManager getInstance() {
		if (userstore == null) {
			synchronized (LibraryUserManager.class) {
				userstore = new LibraryUserManager();
			}
		}
		return userstore;
	}

	/**
	 * add users to system
	 * 
	 * @param user
	 */
	public void addUsers(UserPojo user) {
		userList.put(user.getUserName(), user);
	}

	/**
	 * search user by name
	 * 
	 * @param userName
	 * @return
	 * @throws UserNotFoundException
	 */
	public UserPojo searchUserByName(String userName)
			throws UserNotFoundException {
		if (userName != null && !userName.isEmpty()) {
			return userList.get(userName);
		} else {
			throw new UserNotFoundException(LibraryAppConstants.USER_NOT_FOUND,
					LibraryAppConstants.USER_NOT_FOUND_MSG);
		}
	}

	/**
	 * check user constraints not reached
	 * 
	 * @param userId
	 * @return
	 */
	public boolean checkUserConstraintsReached(String userId) {
		
		
		//System.out.println("checkUserConstraintsReached ->" + userConstraints);
		UserConstraintPojo pojo = userConstraints.get(userId);

	

		if (pojo != null) {
			
			List<String> ids = pojo.getTakenBookIds();
			
			//System.out.println(ids.size());
		
			if (ids != null && ids.size() >=5) {
				//System.out.println("true");
				return true;
			}

		}
		return false;
	}

	/**
	 * check user constraints not reached
	 * 
	 * @param userId
	 * @return
	 */
	public void addToUserConstraint(String userId, String bookId) {
		UserConstraintPojo pojo = userConstraints.get(userId);

		if (pojo == null) {
			List<String> ids = new ArrayList<String>();
			pojo = new UserConstraintPojo();
			ids.add(bookId);
			pojo.setTakenBookIds(ids);
			pojo.setUserId(userId);
			userConstraints.put(userId, pojo);
		} else {
			List<String> ids = pojo.getTakenBookIds();
			ids.add(bookId);
			pojo.setTakenBookIds(ids);
			pojo.setUserId(userId);
			userConstraints.put(userId, pojo);
		}
		
		//System.out.println("after lending user constraints ->"+userConstraints);

	}

	/**
	 * check user constraints not reached
	 * 
	 * @param userId
	 * @return
	 */
	public void removeFromUserConstraint(String userId, String bookId) {
		UserConstraintPojo pojo = userConstraints.get(userId);
		if (pojo != null) {
			List<String> ids = pojo.getTakenBookIds();
			if (ids != null) {
				Iterator<String> itr = ids.iterator();
				while (itr.hasNext()) {
					if (itr.next().equals(bookId)) {
						itr.remove();
					}
				}
			}
		}
		
		//System.out.println("after return user constrants ->"+userConstraints);

	}

}
