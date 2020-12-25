package com.example.testing;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
class LoginUtilsTest {

    private LoginUtils utils = new LoginUtils();

    //test if email has @, at least 1 character before @, at least 3 including . after @ (false if otherwise)
    @Test
    public void ifValidEmailAddress() throws Exception {
        assertTrue(utils.isValidEmailAddress("a@aaa.com"));
        assertFalse(utils.isValidEmailAddress("aa.com"));
        assertFalse(utils.isValidEmailAddress("aa@a."));
        assertFalse(utils.isValidEmailAddress("aa@aaa"));
    }

    //test if password is at least 8 characters (false if otherwise)
    @Test
    public void ifPasswordSizeValid () throws Exception{
        assertTrue(utils.passwordSize("12345678"));
        assertFalse(utils.passwordSize("abc"));
        assertFalse(utils.passwordSize(""));
    }

    //test if password is all spaces (false if otherwise)
    @Test
    public void ifAllSpaces() throws Exception{
        assertTrue(utils.allSpaces("    "));
        assertFalse(utils.allSpaces(" . "));
        assertFalse(utils.allSpaces(""));
        assertFalse(utils.allSpaces("12345678"));
    }
}
