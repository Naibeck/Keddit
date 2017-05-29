package intro.keddit.kotlin.com.keddit.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import intro.keddit.kotlin.com.keddit.R
import intro.keddit.kotlin.com.keddit.ui.fragment.NewsFragment

class MainActivity : RxAppCompatActivity() {
    private val mFragmentManager by lazy {
        supportFragmentManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            changeFragment(NewsFragment())
        }
    }

    fun changeFragment(fragment: Fragment, cleanStack: Boolean = false) {
        if (cleanStack) {
            clearBackStack()
        }

        mFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .replace(R.id.containerView, fragment)
                .addToBackStack(null)
                .commit()
    }

    fun clearBackStack() {
        if (mFragmentManager.backStackEntryCount > 0) {
            val first = mFragmentManager.getBackStackEntryAt(0)
            mFragmentManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        if (mFragmentManager.backStackEntryCount > 1) {
            mFragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}
