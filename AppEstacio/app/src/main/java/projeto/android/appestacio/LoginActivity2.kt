package projeto.android.appestacio

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import projeto.android.appestacio.databinding.ActivityLogin2Binding

class LoginActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityLogin2Binding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogin2Binding.inflate(layoutInflater)

        binding.loginButtom.setOnClickListener {
            val loginUsername = binding.loginUsername.text.toString()
            val loginPassword = binding.loginPassword.text.toString()
            loginDatabase(loginUsername, loginPassword)
        }
        binding.cadastroRedirect.setOnClickListener {
            val intent = Intent(this, SingupActivity::class.java)
            startActivity(intent)
            finish()
        }
        enableEdgeToEdge()
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)
    }

    private fun loginDatabase(username: String, password: String){
        val userExists = databaseHelper.readUser(username,password)
        if (userExists){
            Toast.makeText(this,"Login Efetuado com Sucesso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else{
            Toast.makeText(this,"Usuário ou Senha estão errados", Toast.LENGTH_SHORT).show()

        }
    }

}
