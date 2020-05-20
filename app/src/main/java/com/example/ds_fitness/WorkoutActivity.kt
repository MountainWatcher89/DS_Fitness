package com.example.ds_fitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.workout_layout.*

class WorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workout_layout)

        tab_host.setup()

        //tab1
        var spec = tab_host.newTabSpec("Tab One")
        spec.setContent(R.id.tabOne)
        spec.setIndicator("Work Out Plan 1")
        tab_host.addTab(spec)

        //tab2
        spec = tab_host.newTabSpec("Tab Two")
        spec.setContent(R.id.tabTwo)
        spec.setIndicator("Work Out Plan 2")
        tab_host.addTab(spec)

        //tab3
        spec = tab_host.newTabSpec("Tab Three")
        spec.setContent(R.id.tabThree)
        spec.setIndicator("Work Out Plan 3")
        tab_host.addTab(spec)

        //tab4
        spec = tab_host.newTabSpec("Tab Four")
        spec.setContent(R.id.tabFour)
        spec.setIndicator("Work Out Plan 4")
        tab_host.addTab(spec)

        //tab5
        spec = tab_host.newTabSpec("Tab Five")
        spec.setContent(R.id.tabFive)
        spec.setIndicator("Work Out Plan 5")
        tab_host.addTab(spec)
    }
}
