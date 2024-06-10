package projeto.android.appestacio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import projeto.android.appestacio.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {


    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val peso = intent.getStringExtra("peso")
            val carac = intent.getIntExtra("carac", R.string.pastor_alemão_Carac)
            val desc = intent.getIntExtra("desc", R.string.pastor_alemao_Desc)
            val image = intent.getIntExtra("image", R.drawable.pastor_alemao)

            binding.detailName.text = name
            binding.detailPeso.text = peso
            binding.detailDescription.setText(desc)
            binding.detailCarac.setText(carac)
            binding.detailImage.setImageResource(image)
        }

    }
}
