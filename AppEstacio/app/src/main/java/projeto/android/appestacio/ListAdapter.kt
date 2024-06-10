package projeto.android.appestacio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView




class ListAdapter(context: Context,dataArrayList: ArrayList<ListData?>?):
ArrayAdapter<ListData?>(context, R.layout.list_item, dataArrayList!!){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        val listData = getItem(position)

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        val listImage = view!!.findViewById<ImageView>(R.id.listImage)
        val listName = view.findViewById<TextView>(R.id.listName)
        val listPeso = view.findViewById<TextView>(R.id.listPeso)


        listImage.setImageResource(listData!!.image)
        listName.text = listData.name
        listPeso.text = listData.peso

        return view
    }

}