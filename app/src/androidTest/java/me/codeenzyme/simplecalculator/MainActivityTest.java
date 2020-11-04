package me.codeenzyme.simplecalculator;

import android.content.Context;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    static Context appContext;

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @BeforeClass
    public static void setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Test
    public void calculateWithEmptyEditText_preventCrash() {
        onView(withId(R.id.calc_btn)).perform(click());
    }

    @Test
    public void performAddCalculation() {
        String op = "Addition";
        onView(withId(R.id.first_num_et)).perform(typeText("30"));
        onView(withId(R.id.second_num_et)).perform(typeText("30"));
        onView(withId(R.id.ops_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is(op))
        ).perform(click());
        Espresso.pressBack();

        onView(withId(R.id.calc_btn)).perform(click());
        onView(withId(R.id.result_tv)).check(matches(withText("60.0")));
    }

    @Test
    public void performSubtractionCalculation() {
        String op = "Subtraction";
        onView(withId(R.id.first_num_et)).perform(typeText("60"));
        onView(withId(R.id.second_num_et)).perform(typeText("30"));
        onView(withId(R.id.ops_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is(op))
        ).perform(click());
        Espresso.pressBack();

        onView(withId(R.id.calc_btn)).perform(click());
        onView(withId(R.id.result_tv)).check(matches(withText("30.0")));
    }

    @Test
    public void performMultiplicationCalculation() {
        String op = "Multiplication";
        onView(withId(R.id.first_num_et)).perform(typeText("30"));
        onView(withId(R.id.second_num_et)).perform(typeText("30"));
        onView(withId(R.id.ops_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is(op))
        ).perform(click());
        Espresso.pressBack();

        onView(withId(R.id.calc_btn)).perform(click());
        onView(withId(R.id.result_tv)).check(matches(withText("900.0")));
    }

    @Test
    public void performDivisionCalculation() {
        String op = "Division";
        onView(withId(R.id.first_num_et)).perform(typeText("30"));
        onView(withId(R.id.second_num_et)).perform(typeText("30"));
        onView(withId(R.id.ops_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is(op))
        ).perform(click());
        Espresso.pressBack();

        onView(withId(R.id.calc_btn)).perform(click());
        onView(withId(R.id.result_tv)).check(matches(withText("1.0")));
    }

    @Test
    public void performDivisionByZeroCalculation() {
        String op = "Division";
        onView(withId(R.id.first_num_et)).perform(typeText("30"));
        onView(withId(R.id.second_num_et)).perform(typeText("0"));
        onView(withId(R.id.ops_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)),
                is(op))
        ).perform(click());
        Espresso.pressBack();

        onView(withId(R.id.calc_btn)).perform(click());
        onView(withId(R.id.result_tv)).check(matches(withText("Infinity")));
    }

}
