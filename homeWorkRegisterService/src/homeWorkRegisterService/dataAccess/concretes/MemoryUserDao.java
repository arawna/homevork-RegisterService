package homeWorkRegisterService.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import homeWorkRegisterService.dataAccess.abstracts.UserDao;
import homeWorkRegisterService.entities.concretes.User;

public class MemoryUserDao implements UserDao {

	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);

	}

	@Override
	public void delete(User user) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				users.remove(i);
				break;
			}
		}

	}

	@Override
	public void updateEmail(User user, String newEmail) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				users.get(i).setEmail(newEmail);
				break;
			}
		}

	}

	@Override
	public User getUserById(int id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				return users.get(i);
			}
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public boolean isEmailUnUsing(String email) {
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getEmail()==email) {
				return false;
			}
		}
		return true;
		
	}

	@Override
	public User getUserByEmail(String email) {
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getEmail()==email) {
				return users.get(i);
			}
		}
		return null;
	}

	@Override
	public void verifyUser(User user) {
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId()==user.getId()) {
				users.get(i).setVerifyed(true);
				break;
			}
		}
		
	}

}
