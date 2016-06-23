package appdoor.com.delivery.data.cach_store;


import android.content.Context;
import android.content.SharedPreferences;

public class CacheStore {

    private final String PREFERENSE_NAME = "cachestorepreferense";
    private final String TABLE_TAG = "tableprefe";
    private SharedPreferences mPreferense;

    public CacheStore(Context context) {
        mPreferense = context.getSharedPreferences(PREFERENSE_NAME, Context.MODE_PRIVATE);
    }
}
