package com.example.lottietesting


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.model.KeyPath


class MainActivity : AppCompatActivity() {
    var isCheckedDone: Boolean = false;
    var playFrames: Boolean = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationView:LottieAnimationView = findViewById(R.id.animationView)
        val changeThemeButton:Button = findViewById(R.id.changeThemeButton)
        val stopAnimationButton:Button = findViewById(R.id.stopAnimationButton)
        val progressTv:TextView = findViewById(R.id.progressTv)



        // Set up onLoad options, add any dynamic Lottie updates here and they should show up upon the animation successfully loaded
        with(animationView) {



            // Log animation keypaths for reference
            animationView.resolveKeyPath(KeyPath("**")).forEach {
                Log.i("KeyPath", it.toString())
            }

//            animationView.addValueCallback(
//                KeyPath("**", "right-triangle", "right-triangle", "Fill 1"),
//                LottieProperty.COLOR,
//                { Color.rgb(200,11,202)},
//            )
//
//            animationView.addValueCallback(
//                KeyPath("**", "left-triangle", "left-triangle", "Fill 1"),
//                LottieProperty.COLOR,
//                { Color.rgb(212,99,213)},
//            )
//
//            animationView.addValueCallback(
//                KeyPath("**", "bottom-triangle", "bottom-triangle", "Fill 1"),
//                LottieProperty.COLOR,
//                { Color.rgb(223,185,223)},
//            )
        }

        changeThemeButton.setOnClickListener {

            // Log animation keypaths for reference
            animationView.resolveKeyPath(KeyPath("**")).forEach {
                Log.i("KeyPath", it.toString())
            }

            animationView.addValueCallback(
                KeyPath("**", "right-triangle", "right-triangle", "Fill 1"),
                LottieProperty.COLOR,
                { Color.rgb(200,11,202)},
            )

            animationView.addValueCallback(
                KeyPath("**", "left-triangle", "left-triangle", "Fill 1"),
                LottieProperty.COLOR,
                { Color.rgb(212,99,213)},
            )

            animationView.addValueCallback(
                KeyPath("**", "bottom-triangle", "bottom-triangle", "Fill 1"),
                LottieProperty.COLOR,
                { Color.rgb(223,185,223)},
            )

            animationView.playAnimation()
        }

        stopAnimationButton.setOnClickListener {
            animationView.pauseAnimation()
            animationView.setMinFrame(0)
        }





        // Reverse animation on click
        animationView.setOnClickListener {
                if(isCheckedDone) {
                    animationView.speed = -1f
                    animationView.playAnimation()
                    isCheckedDone = false
                } else {
                    animationView.speed = 1f;
                    animationView.playAnimation()
                    isCheckedDone = true;
                }
        }

        // Play specific frames on click
        animationView.setOnClickListener {
            playFrames = if (playFrames) {
                animationView.setMinAndMaxProgress(0.5f, 1.0f)
                animationView.playAnimation()
                false
            } else {
                animationView.setMinAndMaxProgress(0.0f, 0.5f)
                animationView.playAnimation()
                true
            }
        }



   
    }
}

