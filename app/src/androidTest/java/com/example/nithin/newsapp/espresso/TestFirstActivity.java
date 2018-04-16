package com.example.nithin.newsapp.espresso;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.IdlingRegistry;

import com.example.nithin.newsapp.EspressoIdlingResources;
import com.example.nithin.newsapp.FirstActivity;
import com.example.nithin.newsapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by nithin on 22/3/18.
 */


@RunWith(AndroidJUnit4.class)
public class TestFirstActivity {

    @Rule
    public ActivityTestRule<FirstActivity> ActivityRule =
            new ActivityTestRule<>(FirstActivity .class);

    @Before
    public void registerIdlingResource() {
        // let espresso know to synchronize with background tasks
        IdlingRegistry.getInstance().register(EspressoIdlingResources.getIdlingResource());
    }

    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.getIdlingResource());
    }

    @Test
    public void ensureText(){
        try{

            onView(withId(R.id.edittext)).perform(click());
            onView(withId(R.id.edittext)).perform(typeText("Hello"));
            onView(withId(R.id.edittext)).check(matches(withText("Hello")));
            onView(withId(R.id.button)).perform(click());
            EspressoIdlingResources.increment();
            Espresso.registerIdlingResources(ActivityRule.getActivity().getIdlingResource());
            onView(withId(R.id.rv)).check(matches(isDisplayed()));
            EspressoIdlingResources.decrement();
            onView(withId(R.id.title)).check(matches(withText("Body cam footage shows Ohio police officers saving choking baby")));
            onView(withId(R.id.description)).check(matches(isDisplayed()));
            onView(withId(R.id.description)).check(matches(withText("Body cam footage shows two police officers in Shaker heights, Ohio, rescuing a choking baby, as the mother's vehicle was stopped in the middle of the traffic")));
            onView(withId(R.id.showTitle)).check(matches(isDisplayed()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
