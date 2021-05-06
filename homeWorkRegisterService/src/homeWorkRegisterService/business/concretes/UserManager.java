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
			System.out.println("Böyle bir eposta kayýtlý deðil");
			return;
		}
		if(userDao.getUserByEmail(email).isVerifyed()==false) {
			System.out.println("Giriþ yapmak için email edresinizi onaylamanýz gerekmektedir");
			return;
		}
		if(userDao.getUserByEmail(email).getEmail()==email && userDao.getUserByEmail(email).getPassword()==password) {
			System.out.println(userDao.getUserByEmail(email).getFirstName()+" "+userDao.getUserByEmail(email).getLastName()+" Baþarý ile giriþ yaptýnýz");
			
		}else {
			System.out.println("Þifre hatalý");
		}
		
	}
	
	
	
	


	@Override
	public void verifyUser(User user) {
		if(userDao.getUserById(user.getId())==null) {
			System.out.println("Böyle bir kullanýcý yok doðrulama yapamazsiniz");
			return;
		}
		userDao.verifyUser(user);
		System.out.println(user.getFirstName()+" "+user.getLastName()+" Mailiniz onaylandý kaydýnýz aktif edildi");
	}
	
}
