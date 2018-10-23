package demo.yangzikang.changelanguage;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Publisher {
    private static List<BaseActivity> list = new ArrayList<>();

    public static void addActivity(BaseActivity activity) {
        list.add(activity);
    }

    public static void remoceActivity(BaseActivity activity) {
        list.remove(activity);
    }

    public static void setLanguage(BaseActivity activity, String lauType) {
        Locale myLocale = new Locale(lauType);
        Resources res = activity.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        if (!conf.locale.equals(myLocale)){
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            activity.recreate();
            syncAllObserver();
        }
    }

    private static void syncAllObserver() {
        //同步所有观察者
        for (BaseActivity activity : list) {
            activity.setFlag(true);
        }
    }
}
