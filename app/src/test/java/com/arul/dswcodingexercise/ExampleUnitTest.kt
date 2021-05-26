package com.arul.dswcodingexercise

import com.arul.dswcodingexercise.model.Bag
import com.arul.dswcodingexercise.model.Product
import com.arul.dswcodingexercise.model.Promo
import com.arul.dswcodingexercise.model.Summary
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
//import org.mockito.Mock


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

//    @Mock
//    lateinit var mainActivityViewModel: MainActivityViewModel

    lateinit var nonEmptybag: Bag
    lateinit var emptyBag: Bag

    @Before
    fun setUp() {
        nonEmptybag = getNonEmptyShoppingBag()
        emptyBag = getEmptyShoppingBag()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun check_if_cart_not_rmpty() {
        //Given
        // Class is Loaded

        //When
        nonEmptybag = getNonEmptyShoppingBag()

        //Then
        assertEquals(nonEmptybag.products?.get(0)?.displayName, "Winter Boot")
        assertEquals(nonEmptybag.products?.get(0)?.sku, "12345")
        assertEquals(nonEmptybag.products?.get(0)?.price, "54.99")
        assertNotNull(nonEmptybag.promos?.get(0))
        assertNotNull(nonEmptybag.summary)
    }


    @Test
    fun check_if_cart_rmpty() {
        //Given
        // Class is Loaded

        //When
        emptyBag = getEmptyShoppingBag()

        //Then
        assertNull(emptyBag.products?.get(0)?.displayName)
        assertNull(emptyBag.products?.get(0)?.sku)
        assertNull(emptyBag.products?.get(0)?.price)
        assertNull(emptyBag.promos?.get(0))
        assertNull(emptyBag.summary)
    }

    private fun getEmptyShoppingBag(): Bag {
        return Bag(null, null, null)
    }

    private fun getNonEmptyShoppingBag(): Bag {
        val product = Product("12345", "Winter Boot", "54.99", 1)
        val products = listOf(product)
        val promo = Promo("SUMMER2020", "$5 off any item!", "5")
        val promos = listOf(promo)
        val summary = Summary("54.99", "3.50", "5", "53.49")
        return Bag(products, promos, summary)
    }

}
