package com.shimmerloadingtutorial

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.shimmerloadingtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            binding.productShimmer.visibility = View.GONE
            binding.shimmerRvLayout.visibility = View.VISIBLE
        }, 3000)

        val productList = mutableListOf(
            Product(1, "Pen", R.drawable.pen, 20),
            Product(2, "Bag", R.drawable.bag, 100),
            Product(3, "Compose Box", R.drawable.compass_box, 30),
            Product(4, "Eraser", R.drawable.eraser, 5),
            Product(5, "Pad", R.drawable.pad, 180),
            Product(6, "Table lamp", R.drawable.table_lamp, 190),
            Product(7, "Wallet", R.drawable.wallet, 99),
            Product(1, "Pen", R.drawable.pen, 20),
            Product(2, "Bag", R.drawable.bag, 100),
            Product(3, "Compose Box", R.drawable.compass_box, 30),
            Product(4, "Eraser", R.drawable.eraser, 5),
            Product(5, "Pad", R.drawable.pad, 180),
            Product(6, "Table lamp", R.drawable.table_lamp, 190),
            Product(7, "Wallet", R.drawable.wallet, 99)
        )
        binding.shimmerRvLayout.apply {
            /* // This is Normal Recycler View Adapter
             val productListAdapter = ProductListAdapter(productList = productList)
             this.adapter = productListAdapter
             this.layoutManager = LinearLayoutManager(this@MainActivity)*/
            adapter = ProductListDiffUtilAdapter()
            this.layoutManager = LinearLayoutManager(this@MainActivity)
            (binding.shimmerRvLayout.adapter as ProductListDiffUtilAdapter).submitList(productList)
        }

    }

}