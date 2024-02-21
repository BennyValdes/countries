package com.example.countries

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.countries.model.CountryRepository
import com.example.countries.model.CountryRepositoryImpl
import com.example.countries.model.local.Country
import com.example.countries.model.remote.ApiServices
import kotlinx.coroutines.test.runBlockingTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun `fetchData success`() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.countries", appContext.packageName)
    }

}