package homeWorkRegisterService.business.concretes;


import homeWorkRegisterService.business.abstracts.RegisterService;
import homeWorkRegisterService.business.abstracts.UserService;
import homeWorkRegisterService.core.abstracts.VerificationService;
import homeWorkRegisterService.dataAccess.abstracts.UserDao;
import homeWorkRegisterService.entities.concretes.User;

public class UserManager implements UserService {
	
	UserDao userDao;
	VerificationService verificationService;

	public UserManager(UserDao userDao,VerificationService verificationService) {
		this.userDao = userDao;
		this.verificationService=verificationService;
	}
	

	@Override
	public void register(User user,RegisterService registerService) {
		registerService.register(user);
		
		
	}

	@Override
	public void login(String email, String password) {
		if(userDao.getUserByEmail(email)==null) {
			System.out.println("B�yle bir eposta kay�tl� de�il");
			return;
		}
		if(userDao.getUserByEmail(email).isVerifyed()==false) {
			System.out.println("Giri� yapmak i�in email edresinizi onaylaman�z gerekmektedir");
			return;
		}
		if(userDao.getUserByEmail(email).getEmail()==email && userDao.getUserByEmail(email).getPassword()==password) {
			System.out.println(userDao.getUserByEmail(email).getFirstName()+" "+userDao.getUserByEmail(email).getLastName()+" Ba�ar� ile giri� yapt�n�z");
			
		}else {
			System.out.println("�ifre hatal�");
		}
		
	}
	
	
	
	


	@Override
	public void verifyUser(User user) {
		if(userDao.getUserById(user.getId())==null) {
			System.out.println("B�yle bir kullan�c� yok do�rulama yapamazsiniz");
			return;
		}
		userDao.verifyUser(user);
		System.out.println(user.getFirstName()+" "+user.getLastName()+" Mailiniz onayland� kayd�n�z aktif edildi");
	}
	
}
