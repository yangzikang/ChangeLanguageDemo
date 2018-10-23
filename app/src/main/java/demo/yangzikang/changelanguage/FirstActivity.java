package demo.yangzikang.changelanguage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class FirstActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        String locale = Locale.getDefault().toString();
        Toast.makeText(this,"系统语言："+locale, Toast.LENGTH_LONG).show();//只为了显示

        String language = new SpManager().read(this);
        if(!language.isEmpty()){
            Publisher.setLanguage(FirstActivity.this,language);
        }

        findViewById(R.id.to_next_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, MainActivity.class));
            }
        });
    }


}
