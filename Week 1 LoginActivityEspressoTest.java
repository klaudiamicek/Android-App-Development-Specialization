package com.example.testing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.util.regex.Pattern.matches;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityEspressoTest {
    @Rule
    public ActivityScenarioRule<LoginActivity> mActivityRule=new ActivityScenarioRule<LoginActivity>(LoginActivity.class);


    //test for LoginActivity having place to enter email address
    @Test
    public void checkEmailFieldExists() throws Exception {
        onView(withId(R.id.email)).check(matches(withText(isDisplayed())));
    }
    
    //test for LoginActivity having place to enter password
    @Test
    public void checkPasswordFieldExists() throws Exception{
        onView(withId(R.id.password)).check(matches(isDisplayed()));
    }

    //test for LoginActivity having login button, displays "Login"
    @Test
    public void checkLoginButtonText() throws Exception{
        onView(withId(R.id.email_sign_in_button)).check(matches(withText("Login")));
    }
    //when button clicked, checks password at least 8 characters long
    // displays "The provided password is too short" if too short (error)
    @Test
    public void checkPasswordTooShortError() throws Exception{
        onView(withId(R.id.email)).perform(typeText("a@aaa.com"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("abc"), closeSoftKeyboard());
        onView(withId(R.id.email_sign_in_button)).perform(click());
        onView(withId(R.id.error)).check(matches(isDisplayed()));
        onView(withId(R.id.error)).check(matches(withText("The provided password is too short")));

    }
    //when button clicked, checks password not all spaces
    // displays "The provided password is invalid" if all spaces (error)
    @Test
    public void checkAllSpaces() throws Exception{
        onView(withId(R.id.email)).perform(typeText("a@aaa.com"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("         "), closeSoftKeyboard());
        onView(withId(R.id.email_sign_in_button)).perform(click());
        onView(withId(R.id.error)).check(matches(isDisplayed()));
        onView(withId(R.id.error)).check(matches(withText("The provided password is invalid")));
    }
    //when button clicked, checks email address has @ sign, at least 1 character before @ sign, 3 characters including "." after @
    //displays "Invalid email address" if invalid (error)
    @Test
    public void checkValidEmailAddress() throws Exception{
        onView(withId(R.id.email)).perform(typeText("a@aaa"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("12345678"),closeSoftKeyboard());
        onView(withId(R.id.email_sign_in_button)).perform(click());
        onView(withId(R.id.error)).check(matches(isDisplayed()));
        onView(withId(R.id.error)).check(matches(withText("Invalid email address")));

    }
    
    //if email address and password are valid, displays "Login success"
    @Test
    public void checkLoginSuccess() throws Exception{
        onView(withId(R.id.email)).perform(typeText("a@aaa.com"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("12345678"),closeSoftKeyboard());
        onView(withId(R.id.email_sign_in_button)).perform(click());
        onView(withId(R.id.error)).check(matches(isDisplayed()));
        onView(withId(R.id.error)).check(matches(withText( "Login success")));
    }

}
