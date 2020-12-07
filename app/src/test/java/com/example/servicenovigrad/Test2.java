package com.example.servicenovigrad;

import org.junit.Test;
import org.junit.Rule;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class Test2 {

    //this rule is saying that mainactivity is going to be launched
    @Rule
    public ActivityTestRule<MainActivity> matr = new ActivityTestRule<MainActivity>(MainActivity.class);
    //reference to activity
    private MainActivity ma = null;

    @Before
    public void setUp() throws Exception{
        ma = matr.getActivity();
    }

    //define view and if the view is not null, then the test case is successful
    @Test
    public void test1() {
        View v = ma.findViewbyId(R.id.textFieldSignUp);
        assertNotNull(v);
    }

    @After
    public void tearDown() throws Exception{
        ma = null;
    }
}