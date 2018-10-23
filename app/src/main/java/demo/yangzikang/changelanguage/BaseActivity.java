package demo.yangzikang.changelanguage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private boolean flag = false;

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Publisher.addActivity(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        if(flag) {
            recreate(); //所有BaseActivity做为观察者，都会把flag设为true，在recreate后会flag重新变为false
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Publisher.remoceActivity(this);
    }
}
