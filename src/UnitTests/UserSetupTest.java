package UnitTests;

import Model.Image;
import Model.User;

/**
 * Created by Styrmir on 4/7/2017.
 */

public class UserSetupTest {

    public UserSetupTest(){};

    public static void main(String[] args){
        UserSetupTest test = new UserSetupTest();

        Image image = new Image(0);        
        User user = new User(0);

        //Image
        /*
            private int id;
            private String path;
            private String fileName;
        */
        image.setFileName("UnitTests image.jpg");
        image.setPath("../Images/");


        //User
        /*
        	private final int id;
	        private UserProfile userProfile;
	        private String name;
	        private char sex;
	        private String address;
	        private String email;
	        private String phone;
	        private String nationality;
	    */
        user.setName("Name 1");        
        user.setSex('M');
        user.setAddress("Address 1");
        user.setEmail("email1@email.com");
        user.setPhone("846-5484-2648");
        user.setNationality("Netherlands");
        user.setPreferences("234,232,2,2,55,61,3,5,223,5232");

    }

}
