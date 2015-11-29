package com.example.jomunjeong.hello;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jomunjeong on 2015. 11. 18..
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHoler>{

    public static class ViewHoler extends RecyclerView.ViewHolder {

        CardView cv;
        TextView siteName;
        TextView url;
        TextView id;
        TextView pw;

        ViewHoler(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            siteName = (TextView)itemView.findViewById(R.id.siteName);
            url = (TextView)itemView.findViewById(R.id.url);
            id = (TextView)itemView.findViewById(R.id.id);
            pw = (TextView)itemView.findViewById(R.id.pw);
        }

    }

    private List<Account> accounts;

    RVAdapter(List<Account> accounts){
        this.accounts = accounts;
    }
    @Override
    public int getItemCount() {
        return accounts.size();
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.account_recycler, viewGroup, false);

        ViewHoler viewHoler = new ViewHoler(v);

        return viewHoler;
    }

    @Override
    public void onBindViewHolder(ViewHoler viewHoler, int position) {
        Account account = accounts.get(position);

        viewHoler.siteName.setText(account.siteName);
        viewHoler.url.setText(account.url);
        viewHoler.id.setText(account.id);
        viewHoler.pw.setText(account.pw);


    }
}
