package ru.iteco.fmhandroid.ui.viewElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesElements {

    public ViewInteraction quoteText = onView(allOf(withId(R.id.our_mission_title_text_view)));

}
