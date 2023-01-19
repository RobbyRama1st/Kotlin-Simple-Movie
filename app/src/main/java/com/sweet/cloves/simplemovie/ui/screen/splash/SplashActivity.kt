package com.sweet.cloves.simplemovie.ui.screen.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.sweet.cloves.simplemovie.databinding.ActivitySplashBinding
import com.sweet.cloves.simplemovie.ui.base.BaseActivity
import com.sweet.cloves.simplemovie.ui.screen.main.MainActivity
import com.sweet.cloves.simplemovie.util.viewBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    private val binding by viewBinding(ActivitySplashBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        goToMain()
    }

    private fun goToMain(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}