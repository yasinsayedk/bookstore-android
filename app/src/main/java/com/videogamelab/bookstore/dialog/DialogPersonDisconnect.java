package com.videogamelab.bookstore.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.videogamelab.bookstore.FragmentCache;
import com.videogamelab.bookstore.R;
import com.videogamelab.bookstore.Utility;
import com.videogamelab.bookstore.activity.ActivityPerson;

public class DialogPersonDisconnect extends DialogFragment {

    private FragmentCache cache;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof ActivityPerson) {
            cache = ((ActivityPerson) activity).getFragmentCache();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.dialog_title_disconnect);
        builder.setMessage(R.string.dialog_message_disconnect);

        builder.setPositiveButton(R.string.dialog_button_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                cache.sendMessage(Utility.MESSAGE_DIALOG_PERSON_DISCONNECT, null);
            }
        });

        builder.setNegativeButton(R.string.dialog_button_no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {}
        });

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        return dialog;
    }

}
