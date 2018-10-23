package demo.yangzikang.changelanguage;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Sp中存了用户选择的语言，会在FirstActivity onCreate的时候重新使用用户选择的语言(App被杀掉)
 * 一旦设置了用户语言，App不会根据系统语言自动改变
 * 未设置用户语言时，App会根据系统语言自动改变
 */

public class SpManager {

    public void write(Context context, String text) {
        SharedPreferences.Editor editor = context.getSharedPreferences("userLanguage", MODE_PRIVATE).edit();
        editor.putString("language", text);
        editor.commit();
    }

    public String read(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userLanguage", MODE_PRIVATE);
        return sp.getString("language", "");
    }
}
