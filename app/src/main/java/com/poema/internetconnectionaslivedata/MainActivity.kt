package com.poema.internetconnectionaslivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poema.internetconnectionaslivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var connectivityLiveData: ConnectionLiveData
    private  var isConnected: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setConnectivityObserver()
    }

    private fun setConnectivityObserver() {
        connectivityLiveData = ConnectionLiveData(application)
        connectivityLiveData.observe(this, {
          isConnected = it
            binding.tvConnection.text = it.toString()

        })
    }
}