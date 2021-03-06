package com.yoenas.movietvshow.presentation

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.yoenas.movietvshow.R
import com.yoenas.movietvshow.data.local.DataDummy
import com.yoenas.movietvshow.presentation.home.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val dummyMovie = DataDummy.generateDataMoviesDummy()
    private val dummyTvShow = DataDummy.generateDataTvShowsDummy()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun showMoviesTvShows() {
        onView(withText(R.string.txt_movies)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )

        onView(withText(R.string.txt_tv_shows)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }

    @Test
    fun showDetailMovie() {
        onView(withText(R.string.txt_movies)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                13
            )
        )
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                10,
                click()
            )
        )

        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyMovie[10].title)))

        onView(withId(R.id.tv_released_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_released_detail)).check(matches(withText(dummyMovie[10].released)))

        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyMovie[10].genre)))

        onView(withId(R.id.tv_duration_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration_detail)).check(matches(withText(dummyMovie[10].duration)))

        onView(withId(R.id.tv_rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating_detail)).check(matches(withText(dummyMovie[10].rating)))

        onView(withId(R.id.tv_desc_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc_detail)).check(matches(withText(dummyMovie[10].desc)))

        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_detail)).check(matches(isDisplayed()))

        pressBack()
    }

    @Test
    fun showDetailTvShow() {
        onView(withText(R.string.txt_tv_shows)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                19
            )
        )

        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                19,
                click()
            )
        )

        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyTvShow[19].title)))

        onView(withId(R.id.tv_released_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_released_detail)).check(matches(withText(dummyTvShow[19].released)))

        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyTvShow[19].genre)))

        onView(withId(R.id.tv_duration_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration_detail)).check(matches(withText(dummyTvShow[19].duration)))

        onView(withId(R.id.tv_rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating_detail)).check(matches(withText(dummyTvShow[19].rating)))

        onView(withId(R.id.tv_desc_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc_detail)).check(matches(withText(dummyTvShow[19].desc)))

        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_detail)).check(matches(isDisplayed()))

        pressBack()
    }
}