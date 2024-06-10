package projeto.android.appestacio

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import projeto.android.appestacio.databinding.ActivitySingupBinding

class SingupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingupBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingupBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.button3.setOnClickListener {
            val signupUsername = binding.editTextTextEmailAddress2.text.toString()
            val signupPassword = binding.editTextTextPassword.text.toString()
            signupDatabase(signupUsername, signupPassword)
        }

        binding.loginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity2::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun signupDatabase(username: String, password: String){
        val insertedRowID = databaseHelper.insertUser(username, password)
        if (insertedRowID != -1L){
            Toast.makeText( this, "Cadastro Realizado Com Sucesso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity2::class.java)
            startActivity(intent)
            finish()
        } else{
            Toast.makeText(this, "Cadastro Falhou", Toast.LENGTH_SHORT).show()
        }
    }
}