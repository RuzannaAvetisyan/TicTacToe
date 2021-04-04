package ruzanna.game.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GetUsernameFragment.GetUsernameFragmentListener {
    lateinit var player1: String
    lateinit var player2: String
    private val getUsernameFragment = GetUsernameFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUsernameFragment.listener = this
        getUsernameFragment.show(supportFragmentManager, "GetUsernameFragment")
        r1c1.setOnClickListener {
            play(r1c1)
        }
        r1c2.setOnClickListener {
            play(r1c2)
        }
        r1c3.setOnClickListener {
            play(r1c3)
        }
        r2c1.setOnClickListener {
            play(r2c1)
        }
        r2c2.setOnClickListener {
            play(r2c2)
        }
        r2c3.setOnClickListener {
            play(r2c3)
        }
        r3c1.setOnClickListener {
            play(r3c1)
        }
        r3c2.setOnClickListener {
            play(r3c2)
        }
        r3c3.setOnClickListener {
            play(r3c3)
        }
        reset.setOnClickListener{
            queue.text = player1
            imageView.setImageResource(R.drawable.x)
            clear()
            reset.visibility = View.INVISIBLE
        }

    }

    private fun play(textView: TextView) {
        if(reset.visibility == View.INVISIBLE){
            if (textView.text.toString() == ""){
                if(queue.text.toString() == player1){
                    textView.text = "X"
                }else{
                    textView.text = "O"
                }
                val res = checker()
                if(res.first){
                    if(res.second == "Draw") {
                        result.text = res.second
                    }
                    else{
                        result.text = "${res.second} is winner!!!"
                    }
                    reset.visibility = View.VISIBLE
                }else{
                    if(queue.text.toString() == player1){
                        queue.text = player2
                        imageView.setImageResource(R.drawable.o)
                    }else{
                        queue.text = player1
                        imageView.setImageResource(R.drawable.x)
                    }

                }
            }
        }
    }

    override fun onDeleteListener(text: Editable, text1: Editable) {
        getUsernameFragment.dismiss()
        player1 = text.toString().capitalize()
        player2 = text1.toString().capitalize()
        queue.text = player1
    }

    private fun checker(): Pair<Boolean, String>{
        var endGame = false
        var winner = queue.text.toString()
        when{
            r1c1.text == r1c2.text && r1c3.text == r1c2.text && r1c1.text != ""-> {
                endGame = true
            }
            r2c1.text == r2c2.text && r2c3.text == r2c2.text && r2c1.text != "" -> {
                endGame = true
            }
            r3c1.text == r3c2.text && r3c3.text == r3c2.text && r3c1.text != "" ->  {
                endGame = true
            }
            r1c1.text == r2c1.text && r3c1.text == r2c1.text && r1c1.text != "" ->  {
                endGame = true
            }
            r1c2.text == r2c2.text && r3c2.text == r2c2.text && r2c2.text != "" ->  {
                endGame = true
            }
            r1c3.text == r2c3.text && r3c3.text == r2c3.text && r2c3.text != "" ->  {
                endGame = true
            }
            r1c1.text == r2c2.text && r3c3.text == r2c2.text && r2c2.text != "" ->  {
                endGame = true
            }
            r1c3.text == r2c2.text && r3c1.text == r2c2.text && r2c2.text != "" ->  {
                endGame = true
            }
            r1c1.text != "" && r1c2.text != "" && r1c3.text != "" &&
                    r2c1.text != "" && r2c2.text != "" && r2c3.text != "" &&
                    r3c1.text != "" && r3c2.text != "" && r3c3.text != "" -> {
                winner = "Draw"
                endGame = true
            }
        }
        return Pair(endGame, winner)
    }
    private fun clear(){
        r1c1.text = ""
        r1c2.text = ""
        r1c3.text = ""
        r2c1.text = ""
        r2c2.text = ""
        r2c3.text = ""
        r3c1.text = ""
        r3c2.text = ""
        r3c3.text = ""
        result.text = ""
    }
}
