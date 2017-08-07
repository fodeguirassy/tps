package com.furkilic.tptest;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.furkilic.tptest.MainActivity.ERROR_MESSAGE;
import static com.furkilic.tptest.MainActivity.SUCCESS_MESSAGE;

/**
 * Created by furki on 07/07/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityIntrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testTwoEditTextNotEqual(){
        onView(withId(R.id.firstEditText)).perform(typeText("TOTO"));
        onView(withId(R.id.secondEditText)).perform(typeText("TATA"));
        onView(withId(R.id.validatorButton)).perform(click());

        onView(withId(R.id.resultTextView)).check(matches(withText(ERROR_MESSAGE)));
    }

    @Test
    public void testTwoEditTextEqual(){
        onView(withId(R.id.firstEditText)).perform(typeText("TOTO"));
        onView(withId(R.id.secondEditText)).perform(typeText("TOTO"));
        onView(withId(R.id.validatorButton)).perform(click());

        onView(withId(R.id.resultTextView)).check(matches(withText(SUCCESS_MESSAGE)));
    }
}
