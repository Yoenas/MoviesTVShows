package com.yoenas.movietvshow.presentation

import com.yoenas.movietvshow.presentation.home.MainViewModel
import junit.framework.TestCase
import org.junit.Before

import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun testGetListMovie() {
        val moviesEntities = viewModel.getListMovie()
        TestCase.assertNotNull(moviesEntities)
        TestCase.assertEquals(20, moviesEntities.size)
    }

    @Test
    fun testGetListTvShow() {
        val tvShowsEntities = viewModel.getListTvShow()
        TestCase.assertNotNull(tvShowsEntities)
        TestCase.assertEquals(20, tvShowsEntities.size)
    }
}