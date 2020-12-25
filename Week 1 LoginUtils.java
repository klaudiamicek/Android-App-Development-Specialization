package com.example.testing;

public class LoginUtils {

        public static boolean isValidEmailAddress(String email){
            //checks for "@" sign
            int hasAtSign=email.indexOf("@");
            if((hasAtSign==-1)||(hasAtSign==0))
                return false;

            //checks for at least 1 character before the "@" sign
            // and for at least 3 characters, including a "." after the "@" sign
            String sub_string=email.substring(hasAtSign);
            if(sub_string.length()>3 && sub_string.contains(".")){
                return true;
            }
            return false;

        }

        ///checks that password is at least 8 characters long
        public static boolean passwordSize(String password){
            if (password.length()>=8)
            {
               return true;
            }
            else{
                return false;
            }}


        //checks that password is not all spaces
        public static boolean allSpaces(String password){
            if(password.length()==0){
                return false;
            }
            for (int i=0;i<password.length();i++){
                if(password.charAt(i)!=' '){
                    return false;
                }
            }
            return true;
        }
    }

