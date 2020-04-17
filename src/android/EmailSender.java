package cordova.plugin.emailSender;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
/**
 * This class echoes a string called from JavaScript.
 */
public class EmailSender extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
          
        if(action.equals("send")) {
            this.send(args, callbackContext);
            return true;
        }
        return false;
    }

   
    private void send(JSONArray args, CallbackContext callback) {
        if (args != null) {
            try {

                String p1 = args.getJSONObject(0).getString("param1");

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Task sent by to-do app");
                intent.putExtra(Intent.EXTRA_TEXT, "Hi, this is a task sent from my to-do app: \n \n " + p1);

                this.cordova.getActivity().getApplicationContext().startActivity(intent);
                callback.success("Email sent!");

            } catch(Exception ex) {
                callback.error("Something went wrong" + ex);
            }
        } else {
            callback.error("Please don't pass null value");
        }
    }
}
