package demo.yangzikang.changelanguage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this).setMessage(R.string.select_language);
                builder.setNegativeButton("简体中文", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Publisher.setLanguage(MainActivity.this,"zh_CN");
                        new SpManager().write(MainActivity.this,"zh_CN");//用户设置语言会存sp
                        recreate();
                    }
                });
                builder.setNeutralButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Publisher.setLanguage(MainActivity.this,"en");
                        new SpManager().write(MainActivity.this,"en");//用户设置语言会存sp
                        recreate();
                    }
                });
                builder.show();

            }
        });
    }
}
