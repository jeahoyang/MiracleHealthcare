import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.miraclehealthcare.R

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<View>(R.id.login_button1).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.login_button1 -> AlertDialog.Builder(this)
                .setTitle("알람 팝업")
                .setMessage("팝업 창의 내용입니다.\n\n TEST!!")
                .setNeutralButton(
                    "닫기"
                ) { dlg, sumthin -> }
                .show() // 팝업창 보여줌
        }
    }

}

