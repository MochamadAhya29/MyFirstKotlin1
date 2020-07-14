package com.mochamadahya.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mochamadahya.myapplication.fragment.ExplorerFragment
import com.mochamadahya.myapplication.fragment.HomeFragment
import com.mochamadahya.myapplication.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav.setOnNavigationItemSelectedListener (onBottomNavListener)
        bottom_nav.getOrCreateBadge(R.id.itemExplorer).apply {
            number = 10
            isVisible = true
            backgroundColor = resources.getColor(R.color.colorAccent)
        }

        val frag = supportFragmentManager.beginTransaction()
        frag.add(R.id.frame_container, HomeFragment())
        frag.commit()

    }

    private val onBottomNavListener = BottomNavigationView.OnNavigationItemSelectedListener {i->

        var selectedFragment: Fragment = HomeFragment()

        when (i.itemId){
            R.id.itemHome -> {
                selectedFragment = HomeFragment()
            }
            R.id.itemExplorer -> {
                selectedFragment = ExplorerFragment()
                bottom_nav.getOrCreateBadge(R.id.itemExplorer).apply {
                    number = 0
                    isVisible = false
                }
            }
            R.id.itemSearch -> {
                selectedFragment = SearchFragment()
            }
        }

        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.frame_container, selectedFragment)
        frag.commit()

        true
    }

//    override fun onPause() {
//        super.onPause()
//        val frag = supportFragmentManager.beginTransaction()
//        frag.replace(R.id.frame_container, HomeFragment())
//        frag.commit()
//    }
}