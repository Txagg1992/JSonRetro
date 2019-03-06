package com.curiousca.jsonretro;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.curiousca.jsonretro.model.PayLoad;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.JsonViewHolder> {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String PREF_SWITCH = "prefSwitch";


    private Context mContext;
    private ArrayList<PayLoad> mPayload;

    public JsonAdapter(Context context, ArrayList<PayLoad> examplePayload) {
        this.mContext = context;
        this.mPayload = examplePayload;
    }

    @NonNull
    @Override
    public JsonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.json_item, parent, false);
        return new JsonViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull JsonViewHolder holder, int position) {
        PayLoad currentItem = mPayload.get(position);//gets the item at position of array

        String name = currentItem.getName();
        String subTitle = currentItem.getSubtitle();
        Boolean pushAvailable = currentItem.getPushAvailable();
        Boolean emailAvailable = currentItem.getEmailAvailable();
        Boolean smsAvailable = currentItem.getSmsAvailable();
        Boolean pushEnabled = currentItem.getSmsAvailable();
        Boolean emailEnabled = currentItem.getSmsAvailable();
        Boolean smsEnabled = currentItem.getSmsAvailable();

        holder.mName.setText(name);
        holder.mSubTitle.setText(subTitle);
        if (pushAvailable){
            holder.mPushLayout.setVisibility(View.VISIBLE);
        }else {
            holder.mPushLayout.setVisibility(View.GONE);
        }
        if (emailAvailable){
            holder.mEmailLayout.setVisibility(View.VISIBLE);
        }else {
            holder.mEmailLayout.setVisibility(View.GONE);
        }
        if (smsAvailable){
            holder.mSmsLayout.setVisibility(View.VISIBLE);
        }else {
            holder.mSmsLayout.setVisibility(View.GONE);
        }
        holder.mEmailSwitch.setChecked(emailEnabled);
        holder.mSmsSwitch.setChecked(smsEnabled);
        holder.mPushSwitch.setChecked(pushEnabled);

        if (!pushAvailable && !emailAvailable && ! smsAvailable){
            holder.mName.setVisibility(View.GONE);
            holder.mSubTitle.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return mPayload.size();
    }

    public class JsonViewHolder extends RecyclerView.ViewHolder{

        public RelativeLayout mPushLayout;
        public RelativeLayout mEmailLayout;
        public RelativeLayout mSmsLayout;

        public TextView mName;
        public TextView mSubTitle;
        public TextView mPushText;
        public TextView mEmailText;
        public TextView mSmsText;
        public Switch mPushSwitch;
        public Switch mEmailSwitch;
        public Switch mSmsSwitch;

        public JsonViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.tv_name);
            mSubTitle = itemView.findViewById(R.id.tv_subtitle);
            mPushText = itemView.findViewById(R.id.tv_push_note);
            mEmailText = itemView.findViewById(R.id.tv_email);
            mSmsText = itemView.findViewById(R.id.tv_text_message);
            mPushSwitch = itemView.findViewById(R.id.switch_push);
            mEmailSwitch = itemView.findViewById(R.id.switch_email);
            mSmsSwitch = itemView.findViewById(R.id.switch_sms);
            mPushLayout = itemView.findViewById(R.id.rel_lay_push_note);
            mEmailLayout = itemView.findViewById(R.id.rel_lay_email);
            mSmsLayout = itemView.findViewById(R.id.rel_lay_text_message);

            selectViewsFromAPI();
            //onSwitch();

        }

        public void selectViewsFromAPI(){

            mName.setVisibility(View.VISIBLE);
            mSubTitle.setVisibility(View.VISIBLE);


//            if (!mPushLayout.isEnabled()){
//                mPushLayout.setVisibility(View.INVISIBLE);
//            }else {
//                mPushLayout.setVisibility(View.VISIBLE);
//            }

//            mEmailLayout.setVisibility(View.VISIBLE);
//            mSmsLayout.setVisibility(View.VISIBLE);

        }

        private void onSwitch(){

            SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            final SharedPreferences.Editor editor = sharedPreferences.edit();
            mPushSwitch.setChecked(sharedPreferences.getBoolean(PREF_SWITCH, false));
            editor.putBoolean(PREF_SWITCH, mPushSwitch.isChecked());

            mPushSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        editor.putBoolean(PREF_SWITCH, true);
                        Toast.makeText(mContext, "ON", Toast.LENGTH_SHORT).show();
                    } else {
                        editor.putBoolean(PREF_SWITCH, false);
                        Toast.makeText(mContext, "OFF", Toast.LENGTH_SHORT).show();
                    }
                    editor.apply();
                }
            });

            mEmailSwitch.setChecked(sharedPreferences.getBoolean(PREF_SWITCH, false));
            editor.putBoolean(PREF_SWITCH, mEmailSwitch.isChecked());

            mEmailSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        editor.putBoolean(PREF_SWITCH, true);
                        Toast.makeText(mContext, "ON", Toast.LENGTH_SHORT).show();
                    } else {
                        editor.putBoolean(PREF_SWITCH, false);
                        Toast.makeText(mContext, "OFF", Toast.LENGTH_SHORT).show();
                    }
                    editor.apply();
                }
            });
        }
    }
private void isPushAvailable(){

}

}
