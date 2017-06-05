package sanya.com.sanya;

import android.app.Application;
import android.test.ApplicationTestCase;
import sanya.com.fragment.Fragment_Guide;
import sanya.com.fragment.SceneryFragment;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public SceneryFragment sceneryFragment=null;
    public Fragment_Guide fragment_guide=null;
    public ApplicationTest() {
        super(Application.class);
    }
}