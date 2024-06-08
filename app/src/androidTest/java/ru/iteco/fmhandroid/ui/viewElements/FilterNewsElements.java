package ru.iteco.fmhandroid.ui.viewElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterNewsElements {
    public ViewInteraction filterNewsButton = onView(withId(R.id.filter_button));
    public ViewInteraction mainFilterButton = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction categoryFilter = onView(withId(R.id.news_item_category_text_auto_complete_text_view));

}
