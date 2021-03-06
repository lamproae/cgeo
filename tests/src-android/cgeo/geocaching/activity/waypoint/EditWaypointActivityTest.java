package cgeo.geocaching.activity.waypoint;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withChild;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.assertj.core.api.Assertions.assertThat;

import cgeo.geocaching.R;

import android.test.suitebuilder.annotation.Suppress;

public class EditWaypointActivityTest extends AbstractEditWaypointActivityTest {

    @Suppress
    public void testFieldsAreNotEmpty() {
        final String name = getWaypoint().getName();
        assertThat(name).isNotEmpty();
        onView(withId(R.id.name)).check(matches(withText(name)));

        final String note = getWaypoint().getNote();
        assertThat(note).isNotEmpty();
        onView(withId(R.id.note)).check(matches(withText(note)));

        onView(withId(R.id.type)).check(matches(withChild(withText(getWaypoint().getWaypointType().getL10n()))));
    }

}
