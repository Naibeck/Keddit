package intro.keddit.kotlin.com.keddit

import org.mockito.Mockito

/**
 * Created by Alex Gomez on 5/5/2017.
 */

inline fun <reified T: Any> mock(): T = Mockito.mock(T::class.java)
