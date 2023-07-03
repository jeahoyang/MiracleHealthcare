import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.example.miraclehealthcare.R
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Executor 를 초기화합니다.
        executor = ContextCompat.getMainExecutor(this)

        // BiometricPrompt 를 초기화합니다.
        biometricPrompt = BiometricPrompt(
            this,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    // 인증 오류가 발생한 경우 처리할 코드를 작성합니다.
                    Toast.makeText(applicationContext, "Authentication error: $errString", Toast.LENGTH_SHORT).show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    // 인증에 성공한 경우 처리할 코드를 작성합니다.
                    Toast.makeText(applicationContext, "Authentication succeeded!", Toast.LENGTH_SHORT).show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    // 인증에 실패한 경우 처리할 코드를 작성합니다.
                    Toast.makeText(applicationContext, "Authentication failed!", Toast.LENGTH_SHORT).show()
                }
            })

        // PromptInfo 를 초기화합니다.
        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("지문 인식")
            .setSubtitle("기기에 등록된 지문을 이용하여 인증합니다.")
            .setNegativeButtonText("취소")
            .build()

        // 지문인식 버튼을 초기화합니다.
        val biometricButton = findViewById<Button>(R.id.fingerprint_button)
        biometricButton.setOnClickListener {
            // BiometricPrompt 를 실행합니다.
            biometricPrompt.authenticate(promptInfo)
        }
    }
}
