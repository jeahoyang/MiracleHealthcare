//package com.example.miraclehealthcare;
//
//import android.app.AlertDialog;
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.miraclehealthcare.R;
//
//public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        findViewById(R.id.login_button1).setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.login_button1:
//                new AlertDialog.Builder(this)
//                        .setTitle("알람 팝업")
//                        .setMessage("팝업 창의 내용입니다.\n\n TEST!!")
//                        .setNeutralButton(
//                                "닫기",
//                                (dlg, sumthin) -> {
//                                    // Do nothing
//                                })
//                        .show(); // 팝업창 보여줌
//                break;
//            default:
//                break;
//        }
//    }
//}
