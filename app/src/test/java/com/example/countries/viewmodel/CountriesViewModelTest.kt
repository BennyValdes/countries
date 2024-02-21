package com.example.countries.viewmodel

import com.example.countries.model.CountryRepository
import com.example.countries.model.local.Country
import com.example.countries.model.remote.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CountriesViewModelTest {

    // Required to test suspend functions
    @get:Rule
    val coroutineTestRule = TestCoroutineRule()

    @Mock
    lateinit var apiServices: ApiServices

    // Mock dependencies
    @Mock
    lateinit var countryRepository: CountryRepository

    // System under test
    private lateinit var countriesViewModel: CountriesViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        countriesViewModel = CountriesViewModel()
    }

    @Test
    fun `test fetchData success`() = coroutineTestRule.runBlockingTest {
        // Mock response
        val mockResponse = listOf(
            Country("Country1", "Region1", "Code1", "Capital1"),
            Country("Country2", "Region2", "Code2", "Capital2")
        )
        // Mock successful response from repository
        `when`(countryRepository.getCountries()).thenReturn(Result.success(mockResponse))

//        countriesViewModel.repository = countryRepository

        // Call the function to be tested
        countriesViewModel.fetchData()

        // Verify that the LiveData is updated with the expected data
        assertEquals(mockResponse, countriesViewModel.countryData.value)
    }

    @Test
    fun `test fetchData error`() = coroutineTestRule.runBlockingTest {
        // Mock error response from repository
        `when`(countryRepository.getCountries()).thenReturn(Result.failure(Exception("Error")))

        // Call the function to be tested
        countriesViewModel.fetchData()

        // Verify that the LiveData is not updated
        assertNull(countriesViewModel.countryData.value)
    }
}

class TestCoroutineRule : TestWatcher() {

    private val testDispatcher = TestCoroutineDispatcher()

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    fun runBlockingTest(block: suspend TestCoroutineScope.() -> Unit) =
        testDispatcher.runBlockingTest {
            block()
        }
}