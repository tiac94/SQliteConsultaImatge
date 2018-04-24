package org.ieselcaminas.alu53787365w.deportesbbdd;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

public class DeportesAdapter extends ArrayAdapter<AndroidDeporte> {
    private ArrayList<AndroidDeporte> deportes;

    public DeportesAdapter(Context context, ArrayList<AndroidDeporte> depor) {
        super(context, R.layout.about, depor);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View item = convertView;
        ViewHolder holder;

        if(item == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.hImage = (ImageView)item.findViewById(R.id.idLogo);
            holder.hTitulo = (TextView)item.findViewById(R.id.idTitulo);
            holder.hSubTitulo = (TextView)item.findViewById(R.id.idSubTitulo);

            item.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)item.getTag();
        }

        final AndroidDeporte deporte = getItem(position);

        //holder.hImage.setImageResource(deporte.getLogo());
        // Ara és un byte[] no un int
        byte [] img = deporte.getLogo();
        Bitmap imgBmp = BitmapFactory.decodeByteArray(img,0,img.length);
        holder.hImage.setImageBitmap(imgBmp);
        holder.hTitulo.setText(deporte.getTitulo());
        holder.hSubTitulo.setText(deporte.getSubTitulo());



        return(item);
    }







}

