package projeto.android.appestacio

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import projeto.android.appestacio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        val nameList = arrayOf("Pastor Alemão", "Pastor Belga", "Pinscher", "São Bernardo", "PitBull", "Spitz Alemão", "Labrador", "Husky Siberiano", "Golden Retriever", "Fila Brasileiro", "Dachshund", "Border Collie", "Beagle")
        val pesoList = arrayOf("30~43kg", "28~30kg", "4~6kg", "60~90kg", "10~35kg", "12~25kg", "25~34kg", "26~44kg", "27~36kg", "55~70kg", "3~9kg", "13~20kg", "9~35kg")

        val imageList = intArrayOf(
            R.drawable.pastor_alemao,
            R.drawable.pastor_belga,
            R.drawable.pinscher_mini,
            R.drawable.sao_bernardo,
            R.drawable.pit_bull,
            R.drawable.lulu_da_pomerania,
            R.drawable.labrador,
            R.drawable.husky_sibeiano,
            R.drawable.golden_retriver,
            R.drawable.fila_brasileiro,
            R.drawable.dachshund,
            R.drawable.border_collie,
            R.drawable.beagle
        )
        val caracList = intArrayOf(
            R.string.pastor_alemão_Carac,
            R.string.pastor_belga_Carac,
            R.string.Pinscher_mini_Carac,
            R.string.Sao_bernardo_Carac,
            R.string.Pit_Bull_Carac,
            R.string.Lulu_da_Pomeranea_Carac,
            R.string.Labrador_Carac,
            R.string.Husky_siberiano_Carac,
            R.string.Golden_Retriever_Carac,
            R.string.Fila_Brasileiro_Carac,
            R.string.Dachshund_Carac,
            R.string.Border_collie_Carac,
            R.string.Beagle_Carac
        )
        val descList = intArrayOf(
            R.string.pastor_alemao_Desc,
            R.string.pastor_belga_desc,
            R.string.Pinscher_mini_desc,
            R.string.Sao_bernardo_Desc,
            R.string.Pit_Bull_Desc,
            R.string.Lulu_da_Pomeranea_Desc,
            R.string.Labrador_Desc,
            R.string.Husky_siberiano_Desc,
            R.string.Golden_Retriever_Desc,
            R.string.Fila_Brasileiro_Desc,
            R.string.Dachshund_Desc,
            R.string.Border_collie_Desc,
            R.string.Beagle_Desc
        )
        for (i in imageList.indices){
            listData = ListData(nameList[i], pesoList[i], caracList[i], descList[i], imageList[i])
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.lisView.adapter = listAdapter
        binding.lisView.isClickable = true

        binding.lisView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent  = Intent(this@MainActivity,DetailedActivity::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("peso", pesoList[i])
            intent.putExtra("carac", caracList[i])
            intent.putExtra("desc", descList[i])
            intent.putExtra("image", imageList[i])
            startActivity(intent)
        }
    }
}
