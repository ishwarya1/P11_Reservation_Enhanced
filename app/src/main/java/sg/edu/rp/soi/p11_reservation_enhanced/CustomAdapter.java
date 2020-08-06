package sg.edu.rp.soi.p11_reservation_enhanced;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<DataList> ActionList;
    public CustomAdapter (Context context, int resource, ArrayList<DataList> objects){
        super(context,resource,objects);
        parent_context = context;
        layout_id = resource;
        ActionList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=(LayoutInflater)parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvRes = rowView.findViewById(R.id.textViewRes);
        TextView tvDDate = rowView.findViewById(R.id.textViewDDate);
        DataList currentName = ActionList.get(position);
        tvRes.setText(currentName.getName());
        tvDDate.setText(currentName.getDate());
        return rowView;
    }
}