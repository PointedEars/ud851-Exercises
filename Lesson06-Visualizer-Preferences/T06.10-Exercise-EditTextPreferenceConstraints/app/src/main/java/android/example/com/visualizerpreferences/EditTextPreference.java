package android.example.com.visualizerpreferences;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by pelinux on 11.02.18.
 */

public class EditTextPreference extends android.support.v7.preference.EditTextPreference {
    private final String SUMMARY_FORMAT = getContext().getString(R.string.pref_size_summary_format);

    public EditTextPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public EditTextPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextPreference(Context context) {
        super(context);
    }

//    @Override
//    public CharSequence getSummary() {
//        if (super.getSummary() == null) { return null; }
//        String summary = super.getSummary().toString();
//        return String.format(summary, this.getText());
//    }

    @Override
    public void setText(String text) {
        super.setText(text);
<<<<<<< Updated upstream
//        this.setSummary(this.getText());
=======
        this.setSummary(String.format(SUMMARY_FORMAT, Float.parseFloat(this.getText())));
>>>>>>> Stashed changes
    }
}
