package com.android.nytimes.view.ui;

import android.content.ClipData;
import android.content.res.Resources;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.nytimes.R;

import junit.extensions.ActiveTestSuite;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;


import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Predicates.instanceOf;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by sathish on 25-02-2018.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

     @Test
    public void checkRecyclerViewPresent(){
         onView(withId(R.id.recyclerview)).check(matches((isDisplayed())));
    }


    @Test
    public void checkItemClickInRecyclerViewWithId(){
        if(getRVcount()>0)
        onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, click()));

        if(getRVcount()>0 )
        onView(withRecyclerView(R.id.recyclerview).atPositionOnView(0,R.id.article_item_view));
    }

    private int getRVcount(){
        int count=0;
        RecyclerView recyclerView = (RecyclerView) activityTestRule.getActivity().findViewById(R.id.recyclerview);
        if(recyclerView.getAdapter()!=null)
            count=recyclerView.getAdapter().getItemCount();
        return count;
    }


    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    public static class RecyclerViewMatcher {
        final int mRecyclerViewId;

        public RecyclerViewMatcher(int recyclerViewId) {
            this.mRecyclerViewId = recyclerViewId;
        }

        public Matcher<View> atPosition(final int position) {
            return atPositionOnView(position, -1);
        }

        public Matcher<View> atPositionOnView(final int position, final int targetViewId) {

            return new TypeSafeMatcher<View>() {
                Resources resources = null;
                View childView;

                public void describeTo(Description description) {
                    int id = targetViewId == -1 ? mRecyclerViewId : targetViewId;
                    String idDescription = Integer.toString(id);
                    if (this.resources != null) {
                        try {
                            idDescription = this.resources.getResourceName(id);
                        } catch (Resources.NotFoundException var4) {
                            idDescription = String.format("%s (resource name not found)", id);
                        }
                    }

                    description.appendText("with id: " + idDescription);
                }

                public boolean matchesSafely(View view) {

                    this.resources = view.getResources();

                    if (childView == null) {
                        RecyclerView recyclerView =
                                (RecyclerView) view.getRootView().findViewById(mRecyclerViewId);
                        if (recyclerView != null) {

                            childView = recyclerView.findViewHolderForAdapterPosition(position).itemView;
                        }
                        else {
                            return false;
                        }
                    }

                    if (targetViewId == -1) {
                        return view == childView;
                    } else {
                        View targetView = childView.findViewById(targetViewId);
                        return view == targetView;
                    }

                }
            };
        }
    }

}