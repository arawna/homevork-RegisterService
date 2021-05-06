package homeWorkRegisterService.business.concretes;

import java.util.regex.Pattern;

import homeWorkRegisterService.business.abstracts.RegisterService;
import homeWorkRegisterService.core.abstracts.VerificationService;
import homeWorkRegisterService.dataAccess.abstracts.UserDao;
import homeWorkRegisterService.entities.concretes.User;

public class StandartRegister implements RegisterService {

	UserDao userDao;
	VerificationService verificationService;
	

	
	public StandartRegister(UserDao userDao, VerificationService verificationService) {
		super();
		this.userDao = userDao;
		this.verificationService = verificationService;
	}

	@Override
	public void register(User user) {
		if (user.getFirstName().length() >= 2) {

		} else {
			System.out.println("�sim 2 karakterden uzun olmal�d�r");
			return;
		}
		if (user.getLastName().length() >= 2) {

		} else {
			System.out.println("Soyisim 2 karakterden uzun olmal�d�r");
			return;
		}
		if (user.getPassword().length() >= 6) {

		} else {
			System.out.println("�ifre 6 karakterden uzun olmal�d�r");
			return;
		}
		if (isEmailValid(user.getEmail())) {

		} else {
			System.out.println("Email ge�erli bir email de�il");
			return;
		}
		if (userDao.isEmailUnUsing(user.getEmail())) {

		} else {
			System.out.println("Bu email zaten kay�tl�");
			return;
		}

		verificationService.sendVerify(user);
		userDao.add(user);
		System.out.println(user.getEmail() + " Adresine do�rulama mailiniz g�nderildi (Standart Kay�t)");

	}

	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}

}
