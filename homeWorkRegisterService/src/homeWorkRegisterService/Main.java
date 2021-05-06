package homeWorkRegisterService;

import java.util.List;

import homeWorkRegisterService.business.abstracts.UserService;
import homeWorkRegisterService.business.concretes.GoogleRegister;
import homeWorkRegisterService.business.concretes.StandartRegister;
import homeWorkRegisterService.business.concretes.UserManager;
import homeWorkRegisterService.core.abstracts.VerificationService;
import homeWorkRegisterService.core.concretes.EmailVerification;
import homeWorkRegisterService.dataAccess.abstracts.UserDao;
import homeWorkRegisterService.dataAccess.concretes.MemoryUserDao;
import homeWorkRegisterService.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserDao userDao=new MemoryUserDao();
		VerificationService verificationService=new EmailVerification();
		StandartRegister standartRegister=new StandartRegister(userDao, verificationService);
		GoogleRegister googleRegister=new GoogleRegister(userDao, verificationService);
		UserService userService=new UserManager(userDao,verificationService);
		User user1=new User(1,"Ali","Hocaoglu","alihocaoglu34@hotmail.com","123");
		User user2=new User(2,"Tolga","Tok","tolgatok@hotmail.com","987654");
		userService.register(user1,standartRegister);
		userService.verifyUser(user1);
		userService.register(user2,googleRegister);
		userService.verifyUser(user2);
		userService.login("alihocaoglu34@hotmail.com", "123456");

		
		System.out.println("----------Dadabasedeki kayitlar----------");
		List<User> users;
		users=userDao.getAllUsers();
		for(int i=0; i<users.size();i++) {
			System.out.println(users.get(i).getFirstName()+" "+users.get(i).getEmail()+" Verifly:"+users.get(i).isVerifyed());
		}
	}

}
