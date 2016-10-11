package com.kingleoric.utils.homekeylistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by KingLeoric on 2016/10/10.
 */
public class HomeKeyListenerHelper {

    private Context context;
    private BroadcastReceiver receiver;

    public HomeKeyListenerHelper(Context ctx) {
        context = ctx;
    }

    public void registerHomeKeyListener(HomeKeyListener l) {
        if (null != context) {
            registerListener(l);
        }
    }

    private void registerListener(HomeKeyListener l) {
        receiver = new HomeKeyEventBroadcastReceiver(l);
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        context.registerReceiver(receiver, intentFilter);
    }

    public void unregisterHomeKeyListener() {
        if (null != context && null != receiver) {
            context.unregisterReceiver(receiver);
        }
    }

    public interface HomeKeyListener {
        public void onHomeKeyShortPressed();
        public void onHomeKeyLongPressed();
    }

}
