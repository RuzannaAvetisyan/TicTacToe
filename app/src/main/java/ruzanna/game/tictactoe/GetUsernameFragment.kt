package ruzanna.game.tictactoe

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_get_username.*

class GetUsernameFragment: DialogFragment() {
    lateinit var listener: GetUsernameFragmentListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_get_username, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save.setOnClickListener {
            val p1 = player1.text.toString()
            val p2 = player2.text.toString()
            if(p1!= "" && p2 != "" && p1 != p2){
                listener.onDeleteListener(player1.text, player2.text)
            }
        }
    }

    interface GetUsernameFragmentListener{
        fun onDeleteListener(text: Editable, text1: Editable)
    }
}