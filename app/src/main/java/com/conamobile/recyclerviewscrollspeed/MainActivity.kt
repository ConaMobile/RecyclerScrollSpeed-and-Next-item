package com.conamobile.recyclerviewscrollspeed

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

class MainActivity : AppCompatActivity() {

    var catsModel = ArrayList<Model>()
    lateinit var recyclerView: RecyclerView
    private lateinit var retrofitAdapter: RetrofitGetAdapter
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        button = findViewById(R.id.button)

        recyclerView.isEnabled = false

        //

        //magnet recycler
//        val snapHelper: SnapHelper = LinearSnapHelper()
//        snapHelper.calculateScrollDistance(0,1)
//        snapHelper.attachToRecyclerView(recyclerView)
        magnetThread()

        //


        for (i in 0..20){
            catsModel.add(Model(R.drawable.ic_launcher_background, "Name$i"))
        }

        recyclerViewAdapter(catsModel)
        var inner = 0

        button.setOnClickListener {
            retrofitAdapter.notifyDataSetChanged()
//            recyclerView.smoothScrollToPosition(catsModel.indices.first())
            recyclerView.smoothScrollToPosition(PositionObject.position!!.toInt()-1)


            if (PositionObject.position == catsModel.indices.last) {
//                PositionObject.position = 1
                recyclerView.smoothScrollToPosition(catsModel.indices.first)
                recyclerView.smoothScrollToPosition(0)
                retrofitAdapter.notifyDataSetChanged()
            }

        }
    }

    private fun recyclerViewAdapter(photos: java.util.ArrayList<Model>) {
        retrofitAdapter = RetrofitGetAdapter(this, photos)
        recyclerView.adapter = retrofitAdapter
        recyclerView.layoutManager = SpeedyLinearLayoutManager(this)
//        recyclerView.layoutManager = CustomGridLayoutManager(this)
//        run()



    }

    private fun magnetThread() {
        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    //magnet recycler
                    val snapHelper: SnapHelper = LinearSnapHelper()
                    snapHelper.attachToRecyclerView(recyclerView)

                    //
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        thread.start()
    }

    private fun run() {
        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    while (true) {
                        getInfo5()
                        sleep(2000)
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        thread.start()
    }

    private fun getInfo5() {
        recyclerView.smoothScrollToPosition(1)
    }
}