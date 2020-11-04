package me.codeenzyme.simplecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityLayoutTest {

    static Context appContext;
    private static View root;

    @BeforeClass
    public static void setUpContext() {
        appContext = ApplicationProvider.getApplicationContext();
        root = LayoutInflater.from(appContext).inflate(R.layout.activity_main, null, false);
    }

    @Test
    public void checkForCalculateBtn() {
        Button btn = root.findViewById(R.id.calc_btn);
        Assert.assertNotNull(btn);
    }

    @Test
    public void checkForOpsSpinner() {
        Spinner opsSpinner = root.findViewById(R.id.ops_spinner);
        Assert.assertNotNull(opsSpinner);
        Assert.assertEquals(4, opsSpinner.getCount());
        Assert.assertEquals("Addition", opsSpinner.getItemAtPosition(0).toString());
        Assert.assertEquals("Subtraction", opsSpinner.getItemAtPosition(1).toString());
        Assert.assertEquals("Multiplication", opsSpinner.getItemAtPosition(2).toString());
        Assert.assertEquals("Division", opsSpinner.getItemAtPosition(3).toString());
    }

    @Test
    public void checkForSecondNumberEditText() {
        EditText secondNumEt = root.findViewById(R.id.second_num_et);
        Assert.assertNotNull(secondNumEt);
    }

    @Test
    public void checkForFirstNumberEditText() {
        EditText firstNumEt = root.findViewById(R.id.first_num_et);
        Assert.assertNotNull(firstNumEt);
    }

    @Test
    public void checkForResultTextView() {
        TextView resultTv = root.findViewById(R.id.result_tv);
        Assert.assertNotNull(resultTv);
    }

}
